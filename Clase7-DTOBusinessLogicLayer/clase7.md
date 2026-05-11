# La interfaz java.sql.PreparedStatement

- Es una interfaz que extiende la funcionalidad de `PreparedStatement`.

- Se utiliza específicamente para llamar y ejecutar procedimientos almacenados (`stored procedures`) directamente en la base de datos.

- A diferencia de otras sentencias, está diseñado para manejar tanto parámetros de entrada como de salida, permitiendo enviar datos al procedimiento y recuperar los resultados calculados por este.

- Al ser una extensión de sentencias previas, también puede generar objetos `ResultSet` al ejecutarse y soporta la agrupación de operaciones para actualizaciones por lotes (`Statement` y `PreparedStatement` soportan también actualización por lotes).


```sql
-- Se define el siguiente procedimiento almacenado en MySQL el cual recibe dos parámetros:
-- _id_area el cual es un parámetro OUT
-- _nombre el cual es un parámetro IN

DELIMITER $

CREATE PROCEDURE INSERTAR_AREA(
    OUT _id_area INT,
    IN _nombre VARCHAR(75)
)
BEGIN
    INSERT INTO area(nombre,activa) VALUES(_nombre,1);

    SET _id_area = @@last_insert_id;
END$

DELIMITER ;
```

```java
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

// we've already got a connection

try (CallableStatement cs = connection.prepareCall("{CALL INSERTAR_AREA(?, ?)}")) {

    // Registrar el parámetro de salida (índice 1)
    cs.registerOutParameter(1, Types.INTEGER);

    // Establecer el parámetro de entrada (índice 2)
    cs.setString(2, "Sistemas");

    // Ejecutar
    cs.execute();

    // Recuperar el ID generado
    int idGenerado = cs.getInt(1);

    System.out.println("ID del área insertada: " + idGenerado);
}

cs.close();
connection.close();
```

```sql
-- Se define el siguiente procedimiento almacenado en MySQL el cual recibe un parámetro:
-- _id_area el cual es un parámetro IN

DELIMITER $

CREATE PROCEDURE OBTENER_AREA_X_ID(
    IN _id_area INT
)
BEGIN
    SELECT id_area, nombre, activa
    FROM area
    WHERE id_area = _id_area;
END$

DELIMITER ;
```

```java
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

// we've already got a connection

try (CallableStatement cs = connection.prepareCall("{CALL OBTENER_AREA_X_ID(?)}")) {

    // Establecer el parámetro de entrada (IN)
    cs.setInt(1, idBusqueda);

    // Ejecutar y obtener el conjunto de resultados (ResultSet)
    try (ResultSet rs = cs.executeQuery()) {

        if (rs.next()) { // Si existe al menos una fila

            // Extraer los datos por nombre de columna o índice
            int id = rs.getInt("id_area");
            String nombre = rs.getString("nombre");
            boolean activa = rs.getBoolean("activa");

            System.out.println(
                "Área Encontrada> ID: " + id +
                ", Nombre: " + nombre +
                ", Activa: " + activa
            );

        } else {
            System.out.println(
                "No se encontró ninguna área con el ID: " + idBusqueda
            );
        }
    }
}
```

# Data Transfer Object (DTO)

Dado que estamos trabajando con OOP un registro de una tabla corresponderá a un objeto de la clase que representa esa tabla, por ejemplo si tengo mi tabla empleado y el registro del ID 5 eso quiere decir que en mi aplicación tendré la clase Empleado y una instancia de ID 5 (la cuál representa el registro en mención).

¿A qué clase mapearía los resultados de la ejecución de este query en donde por cada año - mes se reporta el monto total de ventas y cantidad de productos?

```sql
Query:

SELECT
    year(o.fecha_hora) AS _year,
    month(o.fecha_hora) AS _month,
    sum(o.total) AS _total,
    sum(lov.cantidad) AS cantidad
FROM
    orden_venta o
    INNER JOIN linea_orden_venta lov
        ON lov.fid_orden_venta = o.id_orden_venta
GROUP BY
    year(o.fecha_hora),
    month(o.fecha_hora)
ORDER BY
    1 DESC,
    2 DESC;
```

Se requiere de una clase que mapee la estructura de la tupla resultante de este query -> DTO


# Data Transfer Object (DTO)

- Para responder a la pregunta anterior se requiere definir un Data Transfer Object (DTO).

- El DTO es una clase que solo contiene los atributos específicos que necesitas mover de un lugar a otro.

- Para el query anterior tendría que definir el DTO:

```java
class SalesReportRecordDTO {

    private Integer year;
    private Integer month;
    private Double totalAmount;
    private Integer quantity;

}
```

# Business Layer

- Esta capa es el "corazón" del software, donde reside la lógica que define cómo funciona el negocio, independientemente de cómo se guarden los datos (Base de Datos) o cómo se muestren (UI).

<img width="609" height="501" alt="image" src="https://github.com/user-attachments/assets/0dc74c17-aae2-46be-bbc3-f0993dcbab05" />

# Business Layer

- Generación de ordenes de ventas en SoftProg:

  - El empleado genera una orden de venta con la información de los productos que el cliente desea adquirir y, por cada producto, se especifica la cantidad de este.

  - El sistema recibe la orden de venta y procede de la siguiente forma:

    - Valida que el empleado este activo

    - Valida que el cliente exista

    - Por cada producto se válida si hay stock disponible. En caso de no tener stock se emite el mensaje de error respectivo.

    - Si hay stock en todos los producto se procede a crear la orden de venta y sus líneas de orden de venta

    - Por cada producto se actualiza el stock de estos

    - Como paso final, se emite el número (o ID) de la orden de venta generada.
   
```java
// Generación de ordenes de ventas en SoftProg:

interface OrdenVentaBL {

    void registrar(OrdenVenta ordenVenta);

    // otros métodos aquí

}
```

```java
// Generación de ordenes de ventas en SoftProg:

class OrdenVentaBLImpl implements OrdenVentaBL {

    public void registrar(OrdenVenta ordenVenta) {

        // 1. La operación de registro de orden de venta debe ser indivisible
        // 2. Valida que el empleado exista y este activo
        // 3. Valida que el cliente exista
        // 4. Se valida el stock. Si no hay stock suficiente, se debería lanzar una Exception
        // 5. Se procede a registrar la orden de venta y sus líneas
        // 6. Se procede a actualizar el stock de los productos
        // 7. Confirmo la t.....

    }

}
```

¿Se necesita de los objetos de la capa DAO?  
¿Cómo garantizamos el punto (1) de los comentarios?


# Generación de ordenes de ventas en SoftProg

Respondiendo a las preguntas:

## ¿Se necesita de los objetos de la capa DAO?

Sí, dado que necesitamos validar el stock de los productos necesitamos cargar la información de estos además de validar que el empleado este activo y que el cliente exista.

## ¿Cómo garantizamos el punto (1) de los comentarios?

Cuando se menciona indivisible se refiere a que toda esa lógica se ejecute el todo o nada y esto lo garantizamos haciendo uso de transacciones. Entonces la idea es usar la misma Connection a lo largo de la ejecución de la operación de negocio.


