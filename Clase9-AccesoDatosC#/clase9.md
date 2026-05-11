# Capa de Dominio

- La **capa de dominio** (modelo), es responsable de representar los **conceptos del negocio** mediante clases que encapsulan atributos y comportamientos relevantes para el sistema.

- En esta capa se definen las **entidades del dominio**, tales como: Area, Empleado, Cliente, Producto, entre otras, las cuales son utilizadas por la lógica de negocio y el acceso a datos.

- Es importante destacar que estas clases no deben depender de detalles de implementación como la base de datos o la interfaz de usuario, **ya que su propósito es modelar el negocio de forma independiente.**

- Esta capa será implementada como un proyecto dentro de la solución denominado `SoftProgDomain` o `SoftProgModel`, el cual será reutilizado por las demás capas del sistema.


- Estas clases son **independientes** de otras capas, por lo que no deben contener lógica relacionada con la base de datos, la interfaz de usuario u otros aspectos de infraestructura.

- A diferencia de enfoques centrados en la persistencia, esta capa no representa directamente las tablas de la base de datos ni estructuras de transferencia de datos (DTO), sino el **modelo conceptual del negocio.**

- Asimismo, las entidades pueden incluir comportamientos y validaciones propias, contribuyendo a mantener la coherencia del dominio. Esta capa será implementada en el proyecto `SoftProgDomain` o `SoftProgModel`, el cual será reutilizado por las demás capas del sistema.


# Capas en Visual Studio

- Para implementar una arquitectura en capas en Visual Studio, es necesario partir de la creación de una solución, la cual actúa como contenedor de los distintos proyectos que representarán las capas del sistema.

- Una solución permite organizar de manera estructurada los componentes del sistema, facilitando la separación de responsabilidades y la reutilización de código entre las distintas capas.

- Se creará una solución denominada `SoftProgSolution`, dentro de la cual se incorporarán progresivamente los proyectos correspondientes a cada capa de la arquitectura.

- Como primer paso, se añadirá un proyecto de tipo `Class Library` denominado `SoftProgDomain`, el cual representará la capa de modelo o dominio del sistema.

- Este proyecto contendrá las entidades del negocio y será utilizado por las demás capas, constituyendo la base para el desarrollo del sistema.

- Identificamos la plantilla a utilizar:
<img width="923" height="214" alt="image" src="https://github.com/user-attachments/assets/80852d8f-4be3-4604-814c-9be38db45e0f" />

- Esto se debe a que el proyecto `SoftProgDomain` será de tipo biblioteca de clases (`Class Library`), ya que su propósito es definir las entidades del dominio y ser reutilizado por las demás capas del sistema.

- Este tipo de proyecto no genera una aplicación ejecutable, sino un conjunto de clases que pueden ser referenciadas por otros proyectos.




- **Nombre del proyecto:** Se define como `SoftProgDomain`, siguiendo la convención de nombres en `PascalCase` y representando la capa de dominio del sistema.

- **Nombre de la solución:** Se establece como `SoftProgSolution`, ya que agrupa todos los proyectos que conformarán las distintas capas del sistema.

- **Ubicación del proyecto:** Permite organizar físicamente los archivos del sistema en el equipo; se recomienda una ruta clara y accesible para el desarrollo.

- **Tipo de proyecto (`Class Library`):** Se selecciona este tipo porque el proyecto contendrá clases reutilizables y no una aplicación ejecutable.

<img width="1013" height="621" alt="image" src="https://github.com/user-attachments/assets/e525688e-ffc6-4f86-9e2e-92476c0a64ce" />


<img width="1199" height="393" alt="image" src="https://github.com/user-attachments/assets/86dd9c48-1590-43b7-8f7b-deb5b9375923" />



- En C#, la organización lógica del código se realiza mediante espacios de nombres (`namespaces`), los cuales permiten agrupar clases relacionadas dentro del sistema.

- A diferencia de Java, donde se utilizan paquetes con rutas como `pe.edu.pucp.softprog...`, en C# los namespaces se definen a partir del nombre del proyecto y la estructura de carpetas.

- En el proyecto `SoftProgDomain`, se crearán carpetas que representen los distintos módulos del dominio, tales como: `RRHH`, `GestionClientes`, `Ventas`, `Almacen`, etc.

- Cada carpeta define automáticamente un namespace. Esta organización permite mantener el código estructurado, facilitando su comprensión, mantenimiento y reutilización dentro del sistema.

<img width="1373" height="615" alt="image" src="https://github.com/user-attachments/assets/ab3d3ef2-7b7a-4145-887d-47687608ab32" />

```csharp
namespace SoftProgDomain.RRHH
{
    public class Area
    {
        private int _idArea;
        private String? _nombre;
        private bool _activa;

        public int IdArea { get => _idArea; set => _idArea = value; }

        public string? Nombre { get => _nombre; set => _nombre = value; }

        public bool Activa { get => _activa; set => _activa = value; }
    }
}
```


# Proyecto SoftProgDBManager

- Para gestionar la conexión a la base de datos y centralizar las operaciones de acceso a datos, se creará un nuevo proyecto dentro de la solución en Visual Studio.

- Este proyecto se denominará `SoftProgDBManager` y será de tipo `Class Library`, ya que contendrá clases reutilizables encargadas de la conexión y manejo de la base de datos.

- Su principal responsabilidad será proporcionar los mecanismos necesarios para establecer la conexión con la base de datos, así como servir de base para la implementación de la capa de acceso a datos (DAO).

- Este proyecto dependerá del uso de `ADO.NET`, junto con un proveedor de datos (por ejemplo, `MySQL Connector`), para gestionar la conexión a la base de datos, y será utilizado por otras capas del sistema, como la lógica de negocio y el acceso a datos.

- La separación de este proyecto permite mantener una adecuada organización del sistema, promoviendo la reutilización del código y la independencia entre capas.


# ADO .NET

- `ADO.NET` es una tecnología del entorno .NET que proporciona un conjunto de clases para el acceso a datos desde aplicaciones desarrolladas en C#.

- Permite establecer conexiones con distintos motores de base de datos, ejecutar instrucciones SQL y recuperar información de manera estructurada.

- `ADO.NET` trabaja a través de proveedores de datos, los cuales son específicos para cada sistema gestor de bases de datos, como SQL Server o MySQL.

- Entre sus principales componentes se encuentran:
  - `Connection`: establece la conexión con la base de datos.
  - `Command`: ejecuta consultas.
  - `SQLDataReader`: permite leer resultados de forma eficiente.
  - `DataSet`: representa datos en memoria.


 ### Proyecto SoftProgDBManager

<img width="1401" height="623" alt="image" src="https://github.com/user-attachments/assets/910c7094-8387-455e-afae-ee63d5509829" />
<img width="904" height="193" alt="image" src="https://github.com/user-attachments/assets/58eac4df-4e08-4707-853f-de7ba289227b" />

- El proyecto `SoftProgDBManager` se define como una biblioteca de clases (`Class Library`), ya que su propósito no es ejecutar una aplicación, sino proveer funcionalidades reutilizables relacionadas con la conexión a la base de datos.

- Este proyecto contendrá clases encargadas de establecer la conexión utilizando `ADO.NET` y un proveedor de datos (por ejemplo, `MySQL Connector`), las cuales serán utilizadas por otras capas del sistema.

- Al no ser una aplicación ejecutable, este proyecto no posee un punto de entrada (`Main`), sino que es referenciado por otros proyectos, como la lógica de negocio o la capa de acceso a datos.



# Configuración con appsettings.json

- En aplicaciones modernas de .NET, la configuración del sistema se gestiona mediante el archivo `appsettings.json`, el cual permite definir parámetros como cadenas de conexión, configuraciones de entorno y valores generales de la aplicación.

- Este archivo utiliza formato JSON, lo que facilita la organización y lectura de los datos de configuración.

- A diferencia de enfoques tradicionales como `app.config` o archivos `.properties`, `appsettings.json` es el estándar en aplicaciones basadas en .NET moderno, incluyendo ASP.NET y Blazor.

- En el contexto del curso, se utilizará este archivo para almacenar la cadena de conexión a la base de datos, la cual será consumida por el proyecto `SoftProgDBManager`.

- El archivo `appsettings.json` se coloca en el proyecto de inicio (`startup project`).

```csharp
public class DBManager
{
    private static DBManager _instance;
    private readonly string _connectionString;

    public static DBManager Instance
    {
        get { return _instance; }
    }

    private DBManager(string connectionString)
    {
        _connectionString = connectionString;
    }

    public static void Initialize(string connectionString)
    {
        if (_instance == null)
        {
            _instance = new DBManager(connectionString);
        }
    }

    public MySqlConnection GetConnection()
    {
        return new MySqlConnection(_connectionString);
    }
}
```

# Instalación de librerías en C#

- En aplicaciones desarrolladas en C#, es necesario incorporar librerías externas para extender la funcionalidad del sistema, como el acceso a bases de datos o la gestión de configuración.

- En el entorno de Visual Studio, estas librerías se gestionan mediante `NuGet`, el administrador de paquetes de .NET.

- La instalación de estos paquetes se realiza a través de la opción `"Manage NuGet Packages"` del proyecto en Visual Studio.

- De manera alternativa, es posible descargar manualmente los archivos `.dll` y agregarlos como referencias al proyecto.

- Para trabajar con bases de datos MySQL, es necesario instalar el paquete:
  - `MySql.Data`, el cual proporciona clases como `MySqlConnection`, `MySqlCommand` y `MySqlDataReader`.

- Asimismo, para el manejo de archivos de configuración (`appsettings.json`), se deben instalar los siguientes paquetes:
  - `Microsoft.Extensions.Configuration`
  - `Microsoft.Extensions.Configuration.Json`
  - `Microsoft.Extensions.Configuration.FileExtensions`
  - `System.Configuration.ConfigurationManager`
  - `System.Security.Permissions`
 

<img width="1266" height="637" alt="image" src="https://github.com/user-attachments/assets/52a55c4d-519e-489a-9bb8-45095be91fd2" />

<img width="1516" height="735" alt="image" src="https://github.com/user-attachments/assets/8471848b-cbbd-4acf-84c3-ab0cb1bae58e" />

<img width="1403" height="630" alt="image" src="https://github.com/user-attachments/assets/54cba687-8e0e-4a9c-8b10-500ed7ffb43a" />

<img width="1427" height="524" alt="image" src="https://github.com/user-attachments/assets/2130b24e-41f3-4ef1-8155-2895d66a1469" />

<img width="1262" height="628" alt="image" src="https://github.com/user-attachments/assets/6f04ddc4-3b92-4f56-aeac-fa412b53bfc8" />

<img width="1427" height="429" alt="image" src="https://github.com/user-attachments/assets/40486748-7bb1-41f9-9e61-34d840c96a74" />

<img width="1421" height="604" alt="image" src="https://github.com/user-attachments/assets/4f9577fb-2be3-4c2f-b485-479526e0e7af" />


# Creación del Proyecto Consola SoftProg

- Para ejecutar y probar la funcionalidad del sistema, se creará un proyecto de tipo aplicación de consola dentro de la solución en Visual Studio.

- Este proyecto se denominará `SoftProg` y será el encargado de actuar como punto de entrada del sistema, permitiendo la ejecución de las distintas operaciones implementadas.

- A diferencia de las bibliotecas de clases, este tipo de proyecto sí posee un método `Main`, el cual define el inicio de la ejecución de la aplicación.

- En este proyecto se configurará el archivo `appsettings.json`, desde donde se obtendrá la cadena de conexión a la base de datos.

- Asimismo, este proyecto hará uso de las clases definidas en otros proyectos, como `SoftProgDomain` y `SoftProgDBManager`, mediante referencias entre proyectos.

<img width="1456" height="607" alt="image" src="https://github.com/user-attachments/assets/b8d3db8d-eba2-4e78-a62d-cf5b89e95c59" />


# Creación de appsettings.json

- Para gestionar la configuración de la aplicación, se creará un archivo denominado `appsettings.json` dentro del proyecto de consola `SoftProg`.

- Este archivo permite almacenar parámetros de configuración de forma estructurada, como la cadena de conexión a la base de datos.

- El formato JSON facilita la organización y lectura de los datos, siendo el estándar en aplicaciones modernas de .NET.

## appsettings.json

```json
{
  "ConnectionStrings": {
    "MySqlConnection": "Server=localhost;Port=3306;Database=softprog;Uid=root;Pwd=1234;"
  }
}
```

<img width="1440" height="316" alt="image" src="https://github.com/user-attachments/assets/64f7e046-4f54-40ee-bcba-2b52e666a42f" />

<img width="1367" height="698" alt="image" src="https://github.com/user-attachments/assets/2d330b64-0757-4ed7-a2e0-201c1bf9bd37" />

# Referencias entre Proyectos en la Solución

- En una solución organizada en capas, es necesario establecer referencias entre proyectos, de modo que un proyecto pueda utilizar las clases definidas en otro.

- En el contexto de la solución `SoftProgSolution`, se establecerán las siguientes referencias:
  - `SoftProg → SoftProgDBManager`
  - `SoftProg → SoftProgDomain`

- Para agregar una referencia, se debe hacer clic derecho sobre el proyecto → `Agregar` → `Referencia del Proyecto...`, y seleccionar el proyecto correspondiente.

- Una vez agregada la referencia, es posible utilizar las clases del proyecto referenciado mediante la directiva `using`.


# Inserción de Datos desde el Método Main()

- El método `Main` inicializa la configuración de la aplicación y establece la conexión a la base de datos utilizando la clase `DBManager`.

- En este caso, se emplea el método `Initialize` para configurar la instancia única del `DBManager` con la cadena de conexión obtenida desde el archivo `appsettings.json`.

- Posteriormente, se utiliza la propiedad `Instance` para acceder al `DBManager` y ejecutar operaciones sobre la base de datos.

- Para insertar datos, se utiliza la clase `MySqlCommand` junto con parámetros, evitando así problemas de seguridad y mejorando la claridad del código.


# Configuración del Proyecto de Inicio

- En una solución con múltiples proyectos, es necesario definir cuál de ellos será el proyecto de inicio, es decir, el que se ejecutará al iniciar la aplicación.

- En el contexto del sistema `SoftProgSolution`, el proyecto de inicio debe ser `SoftProg`, ya que contiene el método `Main`, que representa el punto de entrada de la aplicación.

- Para configurar el proyecto de inicio en Visual Studio, se debe realizar lo siguiente: Clic derecho sobre el proyecto `SoftProg`. Seleccionar la opción `"Establecer como proyecto de inicio"`. Una vez configurado, Visual Studio ejecutará automáticamente este proyecto al presionar Run (`F5`).


# Paquetes Requeridos en el Proyecto de Ejecución

- El proyecto de ejecución `SoftProg` deberá tener instalados los siguientes paquetes para el manejo de configuración y acceso a datos:
  - `Microsoft.Extensions.Configuration`
  - `Microsoft.Extensions.Configuration.Json`
  - `Microsoft.Extensions.Configuration.FileExtensions`

- Asimismo, para el correcto funcionamiento del proveedor de MySQL en .NET moderno, puede ser necesario instalar los siguientes paquetes adicionales:
  - `System.Configuration.ConfigurationManager`
  - `System.Security.Permissions`

- Estos paquetes permiten la lectura del archivo `appsettings.json` y aseguran la compatibilidad de las librerías utilizadas para la conexión a la base de datos.


<img width="1092" height="614" alt="image" src="https://github.com/user-attachments/assets/90a7fb41-0e8f-4bfa-9cdf-f3f49976867d" />

```csharp
using System;
using System.IO;
using Microsoft.Extensions.Configuration;
using MySql.Data.MySqlClient;
using SoftProgDBManager;

class Program
{
    static void Main(string[] args)
    {
        IConfiguration configuration = new ConfigurationBuilder()
            .SetBasePath(Directory.GetCurrentDirectory())
            .AddJsonFile("appsettings.json")
            .Build();

        string connectionString = configuration.GetConnectionString("MySqlConnection");

        // Inicializamos el Singleton
        DBManager.Initialize(connectionString);
    }
}
```


```csharp
using (MySqlConnection connection = DBManager.Instance.GetConnection())
{
    connection.Open();

    string sql = "INSERT INTO area(nombre, activa) VALUES (@nombre, @activa)";

    MySqlCommand command = new MySqlCommand(sql, connection);
    command.Parameters.AddWithValue("@nombre", "Recursos Humanos");
    command.Parameters.AddWithValue("@activa", true);

    int filasAfectadas = command.ExecuteNonQuery();

    Console.WriteLine("Filas insertadas: " + filasAfectadas);
}
```

# ¿Cómo funciona IConfiguration?

- `IConfiguration` es un objeto que permite leer valores de configuración, como los que están en `appsettings.json`.

  - `ConfigurationBuilder`: Es un constructor de configuración. Le indicamos de dónde leer datos.
  
  - `SetBasePath(...)`: Le indicamos dónde está el archivo, en la carpeta donde corre el programa.
  
  - `AddJsonFile(...)`: Le indicamos que lea el archivo JSON.
  
  - `Build()`: Construye el objeto final (`IConfiguration`).

- Finalmente, buscamos en el JSON la cadena de conexión llamada `MySqlConnection`.
