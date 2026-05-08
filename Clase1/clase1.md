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


##### En Java

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


<pre>
##### En C#
// Clase base: Profesor
public class Profesor {
    private string nombre;
    private int edad;
    private string asignatura;

    // Constructor de la clase Profesor
    public Profesor(string nombre, int edad, string asignatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.asignatura = asignatura;
    }

    // Método para obtener los detalles del profesor
    public string obtenerDetalles() {
        return $"Nombre: {nombre}, Edad: {edad}, Asignatura: {asignatura}";
    }
}

// Clase derivada: ProfesorTiempoParcial
public class ProfesorTiempoParcial : Profesor {
    private int cantHorasDictadoPorSemana;
    private double tarifaPorHora;

    // Constructor de la clase ProfesorTiempoParcial
    public ProfesorTiempoParcial(string nombre, int edad, string asignatura, int cantHorasDictadoPorSemana, double tarifaPorHora)
        : base(nombre, edad, asignatura) { // Llama al constructor de la clase base
        this.cantHorasDictadoPorSemana = cantHorasDictadoPorSemana;
        this.tarifaPorHora = tarifaPorHora;
    }

    // Método para calcular el salario mensual
    public double calcularSalarioMensual() {
        return cantHorasDictadoPorSemana * tarifaPorHora * 4; // 4 semanas al mes
    }

    // Sobrescribir el método obtenerDetalles para incluir más información
    public new string obtenerDetalles() {
        return base.obtenerDetalles() + $", Horas por semana: {cantHorasDictadoPorSemana}, Tarifa por hora: {tarifaPorHora}";
    }
}

// Uso de las clases
class Program {
    static void Main() {
        ProfesorTiempoParcial profesor = new ProfesorTiempoParcial("Juan Pérez", 40, "Matemáticas", 10, 50);
        Console.WriteLine(profesor.obtenerDetalles());
        Console.WriteLine($"Salario mensual: {profesor.calcularSalarioMensual()}");
    }
}
</pre>

### Polimorfismo
Propiedad de enviar mensajes sintacticamente iguales a objetos de tipos distintos. El único requisito que deben cumplir los objetos que se utilizan de manera polimorfica es saber responder a los mensajes que se envía.

### Tipos:

#### De Subtipo
Capacidad de una clase base de comportarse como cualquier objeto de una clase derivada de esa misma clase base. Se implementa mediante herencia y métodos virtuales y abstractos.
<img width="1335" height="577" alt="image" src="https://github.com/user-attachments/assets/2d26edd1-27af-49e8-9260-3d31435466e1" />

**Clase figura**
<pre>
public class Figura {
    public double base;
    public double altura;

    public Figura(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public void calcularArea(){
        System.out.println("Procedimiento para calcular el area");
    }
}
</pre>

**Clase Triangulo**
<pre>
public class Triangulo extends Figura {

    public Triangulo(double base, double altura){
        super(base, altura);
    }

    @Override
    public void calcularArea(){
        System.out.println(base * altura / 2);
    }
}
</pre>

**Clase Cuadrado**
<pre>
public class Cuadrado extends Figura {

    public Cuadrado(double base, double altura){
        super(base, altura);
    }

    @Override
    public void calcularArea(){
        System.out.println(base * altura);
    }
}
</pre>


**Clase Principal**
<pre>
public class Principal {

    public static void main(String[] args){
        Figura t1 = new Triangulo(10,20);
        Figura c1 = new Cuadrado(10,20);
        
        t1.calcularArea(); 
        c1.calcularArea();
        
        Triangulo t2 = new Triangulo(10,20);
        Cuadrado c2 = new Cuadrado(10,20);
        
        t2.calcularArea(); 
        c2.calcularArea();
    }
}
</pre>

#### Polimorfismo Paramétrico
Se refiere a la capacidad  de escribir código que pueda trabajar con ***cualquier tipo de datos***. En este contexto, "paramétrico" se refiere a los parámetros de tipo que se utilizan
para definir comportamientos o estructuras de datos que pueden ser parametrizados por un tipo específico.

<pre>
public class Contenedor<T> {
    public T dato;

    public Contenedor(T dato) {
        this.dato = dato;
    }

    public void imprimirTipoDato() {
        System.out.println(dato.getClass().getSimpleName());
    }
}
</pre>



<pre>
public class Principal {
    public static void main(String[] args) {
        Contenedor<Integer> contenedorEntero = new Contenedor<>(10);
        Contenedor<String> contenedorString = new Contenedor<>("Hola");

        contenedorEntero.imprimirTipoDato();
        contenedorString.imprimirTipoDato();
    }
}
</pre>


#### Encapsulamiento
Se refiere a ocultar los detalles internos de un objeto y solo exponer las operaciones o funcionalidades. Consiste en agrupar los datos y los métodos que operan sobre esos datos dentro de una clase y controlar el acceso a estos mediante modificadores de acceso ("private", "public", "protected", etc.). Esto significa que los datos son inaccesibles directamente desde fuera de la clase y solo pueden ser modificados o accedidos mediante métodos específicos proporcionados por la clase (conocidos como **getters** y **setters**).

**En Java**
<pre>
public class Estudiante {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
</pre>


**En C#**
<pre>
public class Estudiante {
    private string nombre;

    public string Nombre {
        get {
            return nombre;
        }
        set {
            this.nombre = value;
        }
    }
}
</pre>


¿Qué significa **protected** en Java y C#?
Se utiliza para que una variable o método sea accesible dentro de ***su propia clase, por las clases dervidas (subclases) y por clases en el mismo paquete (en Java) o mismo ensamblado (en C#)***.

Es un nivel de acceso intermedio entre private (solo accesible dentro de la clase) y public (accesible desde cualquier parte del código).


#### Clase abstracta
- Puede declarar una clase como abstracta si desea evitar la creación directa de instancias por medio de la palabra clave new. Si hace esto, la clase solo se puede utilizar si una nueva clase se deriva de ella.

- Basta con que un método sea abstracto para que la clase sea abstracta. A las clases que tienen todos sus métodos implementados se les llama "clases concretas". De manera similar, un método declarado y no implementado se le dice "método abstracto", y uno implementado se le dice "método concreto".

<img width="1287" height="566" alt="image" src="https://github.com/user-attachments/assets/f2147b55-e683-4e99-bf5d-e8a70eee54a3" />

***En Java***
***Clase Persona***

<pre>
public abstract class Persona {
    private String codigoPUCP;

    public Persona(String codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
    }

    public void imprimirCodigoPUCP() {
        System.out.println(codigoPUCP);
    }

    public abstract void realizarActividad();
}
</pre>

**Clase derivada de la abstracta***
<pre>
public class Estudiante extends Persona {

    public Estudiante(String codigoPUCP) {
        super(codigoPUCP);  // Llama al constructor de la clase base
    }

    // Implementación del método abstracto
    @Override
    public void realizarActividad() {
        System.out.println("El estudiante está realizando una actividad académica.");
    }
}
</pre>

**Uso**
<pre>
public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("20222828");
        estudiante.imprimirCodigoPUCP();  // Imprime el código PUCP
        estudiante.realizarActividad();  // Imprime el mensaje sobre la actividad
    }
}   
</pre>



### Interfaz
- Define el comportamiento de una clase, pero no la implementación.
- Las interfaces se utilizan para definir funciones específicas para las clases que no tienen necesariamente una relación de identidad.
- No se establece el modo de acceso de los métodos de una interfaz. Por defecto son públicos.

<img width="1239" height="510" alt="image" src="https://github.com/user-attachments/assets/51de1827-2d49-4810-b763-f4b1046a5991" />


<pre>
</pre>


<pre>
</pre>


<pre>
</pre>


<pre>
</pre>


<pre>
</pre>
