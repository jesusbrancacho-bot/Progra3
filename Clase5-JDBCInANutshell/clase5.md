# Introducción a JDBC

El propósito principal de JDBC es permitir que una aplicación se conecte y acceda a una fuente de datos, la cual puede ser un sistema de Gestión de Bases de Datos (DBMS), un sistema de archivos heredado (*legacy file system*), o cualquier otra fuente de información que cuente con su correspondiente controlador JDBC.

<img width="533" height="437" alt="image" src="https://github.com/user-attachments/assets/e1029997-d801-46a0-ae75-343bd24bd69c" />

JDBC funciona como un intermediario que requiere un controlador específico del fabricante para comunicarse con la base de datos elegida (por ejemplo, `com.mysql.cj.jdbc.Driver` para MySQL o `org.apache.derby.jdbc.EmbeddedDriver` para Java DB).

Cada controlador contiene clases que implementan la interfaz `java.sql.Driver` entre otras interfaces definidas en el paquete `java.sql.*` (`Connection`, `Statement`, `PreparedStatement`, `ResultSet`, etc.).

# La clase DriverManager e interfaz Connection

- La clase `DriverManager` es una clase de JDBC que permite conectar una aplicación a una fuente de datos mediante una JDBC URL. Esta conexión se logra a través de la implementación de la interfaz `java.sql.Connection` dada por el controlador JDBC.

- Al intentar establecer una conexión por primera vez, esta clase carga automáticamente cualquier controlador JDBC 4.0 que se encuentre en la ruta de clases (*class path*).

- Para saber si el driver es versión 4.0 dentro del driver JDBC (file `.jar`) deberá existir el archivo `META-INF/services/java.sql.Driver`. (En caso no existir el archivo deberá cargar la clase del Driver usando `Class.forName`).


El método `DriverManager.getConnection` requiere de una JDBC URL la cual permite especificar información del tipo de fuente de datos al cual deseamos conectarnos, dirección y puerto de este; y parámetros adicionales que podemos especificar. El nombre de usuario y la contraseña necesarios para acceder al DBMS se pueden definir utilizando un objeto `Properties`.

Por ejemplo, una URL típica de MySQL para acceder a una base llamada `"my-database"` ubicada en el servidor `my-server.com` es:

```text
jdbc:mysql://my-server.com:3306/my-database?param1=value1&...&paramN=valueN
```
# Ejemplo de obtención de conexión:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// 1. Se crea un objeto Properties con las credenciales, tal como indican las fuentes
Properties credentials = new Properties();
credentials.put("user", "tu_usuario");
credentials.put("password", "tu_contraseña");

// 2. Se define la URL de la base de datos MySQL
String url = "jdbc:mysql://localhost:3306/my-database";

// 3. Se pasa la URL y las credenciales al método getConnection
Connection connection = DriverManager.getConnection(url, credentials);

// do your stuff here
connection.close();
```

# La interfaz java.sql.Statement

- Un objeto de tipo `Statement` se utiliza para ejecutar comandos y consultas en la base de datos, lo que habitualmente genera un objeto `ResultSet` (una tabla que representa los resultados de la búsqueda).

- Interfaces más avanzadas como `PreparedStatement` y `CallableStatement` también extienden la interfaz `Statement`.

- La interfaz permite procesar comandos únicos mediante métodos como `executeUpdate`, el cual envía la instrucción a la base de datos y retorna un número que indica la cantidad de filas que fueron afectadas.


```java
import java.sql.Statement;

// here I’ve already obtain a connection object

Statement stmt = connection.createStatement();

// Se envía un único comando UPDATE usando executeUpdate, también puede enviar sentencias INSERT o DELETE
String sql = "UPDATE COFFEES SET PRICE = 9.99 WHERE COF_NAME = 'Amaretto'";
int filasAfectadas = stmt.executeUpdate(sql);

stmt.close();
connection.close();
```


- En el ejemplo anterior de código, ¿qué pasaría si el valor de `COF_NAME` es recibido en una variable llamada `cofName`? Entonces nuestra sentencia SQL cambiaría a:
```String sql = "UPDATE COFFEES SET PRICE = 9.99 WHERE COF_NAME = '" + cofName + "'";```

¿Qué problema puede generar la sentencia SQL anterior?
SQL INJECTION

# La interfaz java.sql.ResultSet

- Es la representación en forma de tabla de los datos obtenidos tras ejecutar una consulta SQL en la base de datos.

- Emplea un "cursor" o puntero para recorrer la información fila por fila. Este cursor inicia su recorrido justo antes del primer registro y avanza utilizando el método `next()`, el cual te indica (`true` o `false`) si todavía existen registros disponibles por leer.

- Para recuperar los datos se hace uso de métodos getter (como `getString` o `getInt`, etc.) para extraer los valores precisos de la fila en la que se encuentra posicionado el cursor. Se puede ubicar la columna que deseas leer usando su número de índice (comenzando siempre desde el `1`) o proporcionando su nombre o alias.

```java
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

// here I’ve already obtain a connection object
Statement stmt = con.createStatement();

// Se genera el ResultSet al ejecutar una consulta SELECT
ResultSet rs = stmt.executeQuery("SELECT COF_NAME, SUPPLIER_ID FROM COFFEES");

// rs.next() mueve el cursor a la siguiente fila. Devuelve false si no hay más filas.
while (rs.next()) {

    // Se recuperan los valores usando el nombre de la columna
    String nombreCafe = rs.getString("COF_NAME");
    int idProveedor = rs.getInt("SUPPLIER_ID");

    System.out.println("Café: " + nombreCafe + ", Proveedor: " + idProveedor);
}

rs.close();
stmt.close();
connection.close();
```

# La interfaz java.sql.PreparedStatement

- Es un objeto derivado de `Statement` para enviar sentencias SQL (`INSERT`, `UPDATE`, `DELETE`, `SELECT`, etc.) a la base de datos.

- Ofrece alto rendimiento dado que la consulta se precompila al crearse, lo que permite ejecuciones repetidas de forma mucho más rápida.

- Permite el uso de parámetros dinámicos (`?`). Utiliza signos de interrogación como marcadores en lugar de concatenar texto. Estos se inyectan usando métodos setter (ej. `setString`).

- Ofrecen máxima seguridad. Evita la inyección SQL al tratar los datos del usuario estrictamente como valores y nunca como código ejecutable.

- Expone métodos como `executeQuery` o `executeUpdate` sin pasarle argumentos, porque el objeto ya contiene la consulta.

```java
import java.sql.Connection;
import java.sql.PreparedStatement;

// here i've already created a connection

// 1. Se crea el PreparedStatement pasando la consulta con los signos de interrogación (?)
String query = "UPDATE COFFEES SET SALES = ? WHERE COF_NAME = ?";
PreparedStatement updateSales = connection.prepareStatement(query);

// 2. Se suministran los valores para cada marcador de posición (?) usando los métodos setter.
// El primer argumento es el índice del signo de interrogación (comenzando desde 1).
updateSales.setInt(1, 50);          // El primer '?' (SALES) será 50
updateSales.setString(2, "Espresso"); // El segundo '?' (COF_NAME) será "Espresso"

// 3. Se ejecuta la consulta llamando al método sin argumentos.
// executeUpdate devuelve un entero ('n') con la cantidad de filas que fueron actualizadas.
int n = updateSales.executeUpdate();

System.out.println("Filas actualizadas: " + n);

// Se cierra el recurso al finalizar
updateSales.close();
connection.close();
```

# Manejo de transacciones

- ¿Qué es una transacción? Es una unidad indivisible de sentencias SQL; se ejecuta todo o no se ejecuta nada.

- Pasos para iniciar una transacción:

  a. Usar `con.setAutoCommit(false)` para desactivar el autoguardado y agrupar comandos.

  b. Llamar a `con.commit()` para hacer los cambios permanentes en la base de datos.

  c. Llamar a `con.rollback()` ante una `SQLException` o Excepción de aplicación para deshacer los cambios intermedios y proteger la integridad de los datos.


```java
try {
    // 1. Iniciar transacción (desactivar auto-guardado)
    connection.setAutoCommit(false);

    // 2. Ejecutar las sentencias SQL preparadas
    updateSales.executeUpdate();
    updateTotal.executeUpdate();

    // 3. Confirmar cambios (hacerlos permanentes)
    connection.commit();

} catch (SQLException e) {

    // 4. Deshacer todo en caso de error
    if (connection != null) con.rollback();

} finally {

    // DO NOT FORGET to close the preparedStatement objects

    // 5. Restaurar el auto-guardado al terminar
    if (connection != null) connection.setAutoCommit(true);
}
```

# Buenas prácticas en el uso de JDBC

- **Consultas Seguras y Rápidas:** Utiliza `PreparedStatement`. Previene los ataques de Inyección SQL y, al estar precompilada, mejora el rendimiento si se ejecuta múltiples veces.

- **Eficiencia en ResultSet:** Recupera los datos utilizando índices numéricos en lugar de nombres. Lee siempre las columnas de izquierda a derecha y una sola vez por fila.

- **Transacciones:** Desactiva el auto-commit antes de empezar una transacción. Utilizar siempre el método `rollback` al capturar una `SQLException` para asegurarte de proteger la integridad de los datos si algo falla.

- **Gestión automática de recursos:** Utiliza bloques `try-with-resources` al instanciar tus objetos de conexión y consultas. Esto garantiza el cierre automático de los recursos (`Connection`, `Statement`, `ResultSet`), reduce el código repetitivo y evita fugas de memoria.


```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

// URL de base de datos (ejemplo con sintaxis de MySQL)
String url = "jdbc:mysql://localhost:3306/midatabase";

// 1. Declaramos Connection, Statement y ResultSet dentro de los paréntesis del try.
// Se separan por punto y coma (;).
try (
    Connection con = DriverManager.getConnection(url, "usuario", "password");
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT COF_NAME, SUPPLIER_ID FROM COFFEES")
) {

    // 2. Iteramos a través de los datos del ResultSet usando su cursor
    while (rs.next()) {

        // 3. Extraemos los valores de cada fila usando los getters
        String nombreCafe = rs.getString("COF_NAME");
        int idProveedor = rs.getInt("SUPPLIER_ID");

        System.out.println("Café: " + nombreCafe + ", Proveedor ID: " + idProveedor);
    }

} catch (SQLException e) {

    // Manejamos cualquier error que ocurra durante el proceso
    System.out.println("Ocurrió un error en la base de datos.");
    e.printStackTrace();
}

// ¡Al salir del bloque try, 'rs', 'stmt' y 'con' se cierran automáticamente!
```

<img width="1309" height="693" alt="image" src="https://github.com/user-attachments/assets/1c6d3e8a-2214-4f6d-b318-c7e597f1d2c4" />
<img width="1357" height="595" alt="image" src="https://github.com/user-attachments/assets/b1a83dd7-3b3b-4274-9b43-684bfc3b6638" />
<img width="1377" height="472" alt="image" src="https://github.com/user-attachments/assets/59505c5c-06dd-48fd-814e-821534104fe2" />

# El patrón Data Access Object (DAO)

- Es un patrón estructural que aísla la capa de negocio (tu aplicación) de la capa de persistencia (tu base de datos).

- El objetivo principal es ocultar a la aplicación toda la complejidad técnica necesaria para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar).

- Permite cambiar la capa de persistencia de datos (por ejemplo, de una lista en memoria a MySQL) sin modificar el código de tu aplicación principal (pocos cambios).

- Se implementa utilizando una API abstracta (una Interfaz) que define las operaciones, respaldada por una clase concreta que maneja los detalles técnicos de la base de datos.


# Clase de Dominio

```java
public class User {

    private Long id;
    private String name;
    private String email;

    // constructores
    // setters
    // getters estándar
}
```

# Interfaz DAO

```java
import java.util.List;

public interface UserDAO {

    User get(long id);

    List<User> getAll();

    void save(User t);

    void update(User t);

    void delete(User t);
}
```


```java
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private List<User> users = new ArrayList<>();

    public UserDAOImpl() {
        users.add(new User("John", "john@domain.com"));
        users.add(new User("Susan", "susan@domain.com"));
    }

    @Override
    public User get(long id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        // Logic here to update the user
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}
```

- Notar que la clase UserDAOImpl implementa los métodos en la interfaz UserDAO.
- En este ejemplo hemos usado como repositorio de datos una lista.
- Otras operaciones se pueden definir en la interfaz, por ejemplo: listar usuarios filtrados por nombre.

