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
