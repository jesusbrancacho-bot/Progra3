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
