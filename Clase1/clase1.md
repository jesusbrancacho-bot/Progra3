# Objeto
==================================================================================================================================================================
- Representación del estado y comportamiento de un ***objeto real*** o abstracto
- **Estado** está representado por un conjunto de datos.
- **Comportamiento** está representado por un conjunto de métodos.

# Clase 
==================================================================================================================================================================
- Un conjunto de ***objetos*** que comparten el mismo comportamiento y tipos de sus datos (no los valores) se dice que pertenecen a la misma clase.
- Una clase es un tipo de Dato, cuyas instancias son objetos.
- Una clase contiene la descripción de los datos y métodos de un conjunto de objetos.

### Constructor de una Clase

##### En Java
<pre> 
    public class Estudiante {
    private String nombre;
    private double CRAEST;

    public Estudiante() {
        //Se utilza esto para:
        //- La asignación de valores más tarde: Crea el objeto primero y luego le asigna valores
        //- 
    }

    public Estudiante(String nombre, double CRAEST) {
        this.nombre = nombre;
        this.CRAEST = CRAEST;
    }
} </pre>


Constructor sin parámetros sirve para que le pueda asignar los valores después de crearlos.
<pre> 
 Estudiante estudiante1 = new Estudiante();  // Se crea un objeto sin valores definidos
 estudiante1.setNombre("Ana");
 estudiante1.setCRAEST(16.5);   
</pre>

Constructor con parámetros sirve para que le pueda asignar los valores mientras se construye el objeto

<pre> 
Estudiante estudiante2 = new Estudiante("Carlos", 19.2);  // Se crea un objeto con los valores definidos
</pre>

##### En C#
<pre>
public class Estudiante {
    private string nombre;
    private double CRAEST;

    public Estudiante() {
    }

    public Estudiante(string nombre, double CRAEST) {
        this.nombre = nombre;
        this.CRAEST = CRAEST;
    }
}
</pre>
