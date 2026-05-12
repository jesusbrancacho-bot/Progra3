# Objeto
==================================================================================================================================================================
- <mark>Representación del estado y comportamiento</mark> de un ***objeto real*** o abstracto
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

**En Java**
<pre>
interface IOperaciones {
    void realizarConsultaMedica();
}

public class Cirujano implements IOperaciones {
    @Override
    public void realizarConsultaMedica() {
        System.out.println("El cirujano está realizando una cirugía");
    }

    public static void main(String[] args) {
        Cirujano cirujano = new Cirujano();
        cirujano.realizarConsultaMedica();
    }
}
</pre>

***En C#**
<pre>
interface IOperaciones {
    void realizarConsultaMedica();
}

public class Cirujano : IOperaciones {
    public void realizarConsultaMedica() {
        System.Console.WriteLine("El cirujano está realizando una cirugía");
    }

    public static void Main(string[] args) {
        Cirujano cirujano = new Cirujano();
        cirujano.realizarConsultaMedica();
    }
}
</pre>

#### Miembros Estáticos
- Constituyen datos, métodos y tipos que forman parte de un tipo de dato (por ejemplo, una clase) pero que no requieren una instancia de este para ser utilizados.

- Los miembros estáticos en programación son aquellos que pertenecen a la clase en sí, en lugar de a las instancias de la clase. Esto significa que puedes acceder a ellos sin necesidad de crear un objeto de la clase. A continuación, te doy ejemplos en Java y C# para ilustrar cómo funcionan.

***En Java***
<pre>
public class Contador {
    // Miembro estático
    public static int cuenta = 0;

    // Método estático
    public static void incrementarCuenta() {
        cuenta++;
    }

    public static void main(String[] args) {
        // Acceder al miembro estático sin crear una instancia
        Contador.incrementarCuenta();
        System.out.println("Cuenta: " + Contador.cuenta);  // Salida: Cuenta: 1
    }
}
</pre>

***En C#***
<pre>
using System;

public class Contador {
    // Miembro estático
    public static int cuenta = 0;

    // Método estático
    public static void IncrementarCuenta() {
        cuenta++;
    }

    public static void Main() {
        // Acceder al miembro estático sin crear una instancia
        Contador.IncrementarCuenta();
        Console.WriteLine("Cuenta: " + Contador.cuenta);  // Salida: Cuenta: 1
    }
}
</pre>


### Clase Anidada
- Es una clase definida como miembro de otra clase.
- En general, un tipo de dato definido dentro de otro se le llama tipo de dato anidado.
- Se le conoce como clase ***inner***, y a la clase dentro de la que se definen, clase ***outer***.

**En Java**

***Clase inner Computador y clase outer Microprocesador***
<pre>
public class Computador {
    public void imprimir(){
        System.out.println("Imprimir desde Computador");
    }

    public class Microprocesador {
        public void imprimir(){
            System.out.println("Imprimir desde Microprocesador");
        }
    }
}
</pre>

***Clase principal***
<pre>
public class Principal {
    public static void main(String[] args) {
        Computador c = new Computador();
        c.imprimir();
        Computador.Microprocesador m = c.new Microprocesador();
        m.imprimir();
    }
}
</pre>


***En C#***

<pre>
public class Computador {
    public void imprimir(){
        System.Console.WriteLine("Imprimir desde Computador");
    }

    public class Microprocesador {
        public void imprimir(){
            System.Console.WriteLine("Imprimir desde Microprocesador");
        }
    }
}
</pre>


<pre>
public class Principal {
    public static void Main(string[] args) {
        Computador c = new Computador();
        c.imprimir();
        Computador.Microprocesador m = c.new Microprocesador();
        m.imprimir();
    }
}
</pre>


¿Cuándo es correcto usar clases anidadas?

Las clases anidadas son útiles cuando tienes una clase que está estrechamente asociada con otra y no tiene sentido que exista por sí misma. En general, las clases anidadas se utilizan en los siguientes casos:

- Encapsulamiento: Si una clase no tiene sentido sin la clase exterior, se puede usar una clase anidada para ocultarla.
- Acceso limitado: Si una clase debe tener un acceso muy restringido y solo ser utilizada dentro de la clase exterior.
- Mejora del diseño: Si el comportamiento de una clase está completamente dependiente de la clase exterior, puede mejorar la legibilidad y organización del código al definirla como anidada.


#### Enumerados
La enumeración (también denominado enum) proporciona una manera eficaz de definir un conjunto de constantes integrales con nombre que pueden asignarse a una variable.

**En Java**
<pre>
enum Dias {
    Domingo, Lunes, Martes, Miércoles, Jueves, Viernes, Sabado
}

public class Principal {
    public static void main(String[] args) {
        Dias d = Dias.Domingo;
    }
}
</pre>

**En C#**
<pre>
enum Dias {
    Domingo, Lunes, Martes, Miércoles, Jueves, Viernes, Sabado
}

public class Principal {
    public static void Main(string[] args) {
        Dias hoyDia = Dias.Lunes;
    }
}
</pre>


#### Arreglos
<pre>
public class Prueba {
    public static void Main() {
        // Unidimensionales
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int[] b = new int[10] {0,1,2,3,4,5,6,7,8,9};

        // Múltiples dimensiones
        int[,] aa = { {0,0},{1,1},{2,2} };
        int[,] bb = new int[2,3];

        // Matrices escalonadas
        int[][] aaa = new int[3][]; //Cantidad de filas
        aaa[0] = new int[2]; //Cantidad de columnas en fila 0
        aaa[1] = new int[3]; //Cantidad de columnas en fila 1
        aaa[2] = new int[4]; //Cantidad de columnas en fila 2
    }
}
</pre>

<pre>
public class Arreglo {
    public static void main(String[] args) {
        // Unidimensionales
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int[] b = new int[10]{0,1,2,3,4,5,6,7,8,9};

        // Matrices escalonadas
        int[][] bb = new int[3][]; //Cantidad de filas
        bb[0] = new int[2]; //Cantidad de columnas en la fila 1
        bb[1] = new int[3]; //Cantidad de columnas en la fila 2
        bb[2] = new int[4]; //Cantidad de columnas en la fila 3

        int[][] aa = {
            {6,7,5,0},
            {1,0,2,7},
            {9,5}
        };
    }
}
</pre>

#### Indizadores

Los ***indizadores*** son un tipo especial de ***propiedad*** en algunos lenguajes de programación, como C#, que permiten a un objeto ser accedido de forma similar a un ***arreglo***. A través de un indizador, puedes acceder a los elementos de un objeto usando índices, tal como lo harías con un arreglo, pero sin necesidad de declarar explícitamente un arreglo.

En C#
***Departamento***
<pre>
public class Departamento {
    private string[] empleados = new string[10];

    // Indizador que permite acceder a los empleados como si fuera un arreglo
    public string this[int indice] {
        set {
            empleados[indice] = value;  // Asignar valor al índice
        }
        get {
            return empleados[indice];  // Obtener valor del índice
        }
    }
}
</pre>

***Principal***
<pre>
public class Principal {
    public static void Main() {
        Departamento d = new Departamento();
        d[0] = "Juan";
        d[1] = "Marco";
        System.Console.WriteLine(d[0]);
        System.Console.WriteLine(d[1]);
    }
}
</pre>

#### Manejo de Fechas - Date JAVA

***En C#***
<pre>
using System;

public class Principal {
    public static void Main(string[] args){
        DateTime fecha = DateTime.ParseExact("18-03-2024 15:00", 
            "dd-MM-yyyy HH:mm", System.Globalization.CultureInfo.InvariantCulture);
        System.Console.WriteLine(fecha.ToString("dd-MM-yyyy HH:mm"));
    }
}   
</pre>

***En JAVA***
<pre>
import java.util.Date;
import java.text.SimpleDateFormat;

public class Principal {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date fecha = sdf.parse("18-03-2024 15:00");
        System.out.println(sdf.format(fecha));
    }
}
</pre>

#### Lectura por consola

***En C#***
<pre>
public class Principal {
    public static void Main(string[] args){
        string nombre = System.Console.ReadLine();
        System.Console.WriteLine(nombre);
    }
}
</pre>

***En JAVA***
Primera forma
<pre>
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        String nombre;
        Scanner teclado = new Scanner(System.in);
        nombre = teclado.nextLine();
        System.out.println(nombre);
    }
}    
</pre>

Segunda forma
<pre>
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {
    public static void main(String[] args) throws Exception {
        String nombre;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        nombre = teclado.readLine();
        System.out.println(nombre);
    }
}
</pre>

#### Manejo de Listas

***En C#***
<pre>
using System.Collections.Generic;

class Empleado{
    public string nombre;
    public Empleado(string nombre) { this.nombre = nombre; }
}

public class Principal{
    public static void Main(string[] args){
        Empleado emp1 = new Empleado("Juan");
        Empleado emp2 = new Empleado("Andrea");
        List<Empleado> empleados = new List<Empleado>();
        empleados.Add(emp1); empleados.Add(emp2);
        foreach(Empleado emp in empleados) {
            System.Console.WriteLine(emp.nombre);
        }
    }
}
</pre>

***BindingList***
<pre>
using System.ComponentModel;

class Empleado{
    public string nombre;
    public Empleado(string nombre) { this.nombre = nombre; }
}

public class Principal{
    public static void Main(string[] args){
        Empleado emp1 = new Empleado("Juan");
        Empleado emp2 = new Empleado("Andrea");
        BindingList<Empleado> empleados = new BindingList<Empleado>();
        empleados.Add(emp1); empleados.Add(emp2);
        foreach(Empleado emp in empleados) {
            System.Console.WriteLine(emp.nombre);
        }
    }
}
</pre>

***En Java***
<pre>
import java.util.ArrayList;

class Empleado{
    public String nombre;
    public Empleado(String nombre) { this.nombre = nombre; }
}

public class Principal{
    public static void main(String[] args){
        Empleado emp1 = new Empleado("Juan");
        Empleado emp2 = new Empleado("Andrea");
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(emp1); empleados.add(emp2);
        for(Empleado emp : empleados){
            System.out.println(emp.nombre);
        }
    }
}
</pre>

#### instanceof (JAVA)- is (C#)
- Son operadores que se utilizan para comprobar si un objeto es una instancia de una clase específica, una instancia de una subclase o una instancia de una clase que implementa una determinada clase de tipo interface.
- Los operadores devuelven **true** si el objeto es una instancia de la clase especificada o de alguna de sus subclases, o si el objeto implementa la interface especificada. De lo contrario, devuelve ***false***.

#### En Java
<pre>
class Auto extends Vehiculo { }
class Moto extends Vehiculo { }
class Vehiculo { }

public class Principal {
    public static void main(String[] args) {
        Vehiculo veh01 = new Auto();
        Vehiculo veh02 = new Moto();
        System.out.println(veh01 instanceof Vehiculo);
        System.out.println(veh01 instanceof Auto);
        System.out.println(veh01 instanceof Moto);
    }
}
</pre>

#### En C#
<pre>
class Auto : Vehiculo { }
class Moto : Vehiculo { }
class Vehiculo { }

public class Principal {
    public static void Main(string[] args) {
        Vehiculo veh01 = new Auto();
        Vehiculo veh02 = new Moto();
        System.Console.WriteLine(veh01 is Vehiculo);
        System.Console.WriteLine(veh01 is Auto);
        System.Console.WriteLine(veh01 is Moto);
    }
}
</pre>

#### Programando relaciones entre clases

<img width="1315" height="643" alt="image" src="https://github.com/user-attachments/assets/a490f861-0328-4bd8-97c1-d37c693ef760" />

<pre>
import java.util.ArrayList;

class Cliente{
    private ArrayList<OrdenCompra> ordenesCompra;

    public ArrayList<OrdenCompra> getOrdenesCompra(){
        return ordenesCompra;
    }

    public void setOrdenesCompra(ArrayList<OrdenCompra> ordenesCompra){
        this.ordenesCompra = ordenesCompra;
    }
}

class OrdenCompra{
    private Cliente cliente;

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
}
</pre>

La clase OrdenCompra tiene los métodos set y get para el atributo cliente porque cliente es una referencia a un objeto de la clase Cliente. Estos métodos permiten acceder a este atributo y modificarlo de forma controlada.

<pre>
using System.ComponentModel;

class Cliente{
    private BindingList<OrdenCompra> ordenesCompra;

    public BindingList<OrdenCompra> OrdenesCompra{
        get{ return ordenesCompra; }
        set{ this.ordenesCompra = value; }
    }
}

class OrdenCompra{
    private Cliente cliente;

    public Cliente Cliente{
        get{ return cliente; }
        set{ this.cliente = value; }
    }
}
</pre>

