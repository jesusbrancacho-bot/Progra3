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


### Destructor de una clase
En Java y C# no es necesario implementar un método destructor, ya que el Garbage Collector libera la memoria cuando las instancias de los objetos de los objetos no quedan referenciados.


##### En Java

<pre>
public class Estudiante {
    private String nombre;
    private double CRAEST;

    public Estudiante() {
    }

    public void finalize() {
        System.out.println("El objeto se esta destruyendo");
    }
}
</pre>


##### En C#

<pre>
public class Estudiante {
    private string nombre;
    private double CRAEST;

    public Estudiante() {
    }

    ~Estudiante() {
        System.Console.WriteLine("Se esta destruyendo un objeto");
    }
}
</pre>


# Herencia
==================================================================================================================================================================
- Permite crear nuevas clases que reutilizan, extienden y modifican el comportamiento que se define en otra clases. La clase cuyos miembros se heredan se denomina ***clase base*** y la clase que hereda se denomina ***clase derivada***. Un clase derivada solo puede tener una clase base directa.

<img width="1331" height="579" alt="image" src="https://github.com/user-attachments/assets/acb05256-370a-4d47-afe4-a5d5794a2d7e" />


### En Java

<pre>
// Clase base: Profesor
public class Profesor {
    private String nombre;
    private int edad;
    private String asignatura;

    // Constructor de la clase Profesor
    public Profesor(String nombre, int edad, String asignatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.asignatura = asignatura;
    }

    // Método para obtener los detalles del profesor
    public String obtenerDetalles() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Asignatura: " + asignatura;
    }
}

// Clase derivada: ProfesorTiempoParcial
public class ProfesorTiempoParcial extends Profesor {
    private int cantHorasDictadoPorSemana;
    private double tarifaPorHora;

    // Constructor de la clase ProfesorTiempoParcial
    public ProfesorTiempoParcial(String nombre, int edad, String asignatura, int cantHorasDictadoPorSemana, double tarifaPorHora) {
        super(nombre, edad, asignatura); // Llama al constructor de la clase base
        this.cantHorasDictadoPorSemana = cantHorasDictadoPorSemana;
        this.tarifaPorHora = tarifaPorHora;
    }

    // Método para calcular el salario mensual
    public double calcularSalarioMensual() {
        return cantHorasDictadoPorSemana * tarifaPorHora * 4; // 4 semanas al mes
    }

    // Sobrescribir el método obtenerDetalles para incluir más información
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Horas por semana: " + cantHorasDictadoPorSemana + ", Tarifa por hora: " + tarifaPorHora;
    }
}

// Uso de las clases
public class Main {
    public static void main(String[] args) {
        ProfesorTiempoParcial profesor = new ProfesorTiempoParcial("Juan Pérez", 40, "Matemáticas", 10, 50);
        System.out.println(profesor.obtenerDetalles());
        System.out.println("Salario mensual: " + profesor.calcularSalarioMensual());
    }
}
</pre>





