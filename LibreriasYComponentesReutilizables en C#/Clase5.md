#### Librerías y Componentes Reutilizables en C#
**¿Qué es una DLL?**
- DLL significa **Dynamic Link Library**, y representa una biblioteca utilizada en aplicaciones .NET.
- Es un archivo compilado que contiene clases, métodos y otros elementos de código reutilizable.
- Una DLL puede ser utilizada por múltiples aplicaciones, lo que permite compartir funcionalidad y evitar
duplicación de código.


**Librería vs DLL**
- Una librería es un concepto que representa código reutilizable dentro de un sistema.
- Una DLL es la forma física en la que una librería se distribuye en .NET.
- En este sentido, toda DLL es una libreriía, pero una librería no es necesariamente un archivo.

**Tipos de Proyectos en .NET**
- En .NET existen distintos tipos de proyectos que permiten desarrollar aplicaciones ejecutables o componentes reutilizables.
- Las **aplicaciones de consola** y **aplicaciones web** funcionan como programas completos que pueden ser ejecutados por el usuario o un servidor.
- Las **librerías de clases** generan archivos DLL que encapsulan funcionalidades reutilizables dentro del sistema.
- Todos estos proyectos se compilan en ensamblados que contienen el código intermedio ejecutado por la plataforma .NET.


**Aplicación de Consola**
- Genera un ensamblado principal en formato DLL que contiene el código compilado del programa. Adicionalmente, se genera un archivo ejecutable (.exe) que actúa como lanzador de aplicación.
- En aplicaciones .NET modernas, el código compilado se encuentra dentro del archivo DLL. **El archivo .exe no contiene la lógica del programa, sino que se encarga de iniciar la ejecución.** Esto permite que el mismo código puede ejecutarse en diferente plataformas utilizando el **runtime** de .NET.

**Creación de una Aplicación de Consola**
- Una aplicación de consola puede ser creada usando la herramienta de línea de comandos de .NET.
- El comando **dotnet new console** permite generar automáticamente la estructura base del proyecto.
- Este proyecto incluye un archivo principal (**Program.cs**) donde se define el punto de entrada del programa.
- Posteriormente, el comando **dotnet build** compila el código y genera los ensamblados necesarios  para su ejecución.
- Finalmente, el comando **dotnet run** permite ejecutar la aplicación desde la consola.
- El comando **dotnet new console** permite crear una aplicación de consola con un nombre por defecto.
- El parámetro **-n** permite especificar el nombre del proyecto de forma explícita.
- Es recomendable utilizar **-n** para mantener un mejor control sobre la organización de los proyectos.
  
<img width="616" height="142" alt="image" src="https://github.com/user-attachments/assets/6881f354-9776-463d-ad44-8fa11a479b80" />

- Al crear una aplicación de consola, **.NET** genera automáticamente una estructura básica de proyecto.
- El archivo **Program.cs** contiene el punto de entrada donde se inicia la ejecución del programa.
- El archivo .csproj define la configuración del proyecto, incluyendo dependencias y versión del **framework**.
- La carpeta **bin/** contiene los archivos compilados, como el ensamblado en formato DLL y el archivo ejecutable.
- La carpeta **obj/** almacena  archivos temporales utilizados durante el proceso de compilación.

#### Espacios de nombres - Namespaces
- Es un mecanismo que permite organizar clases y otros elementos dentro de un proyecto.
- Su función principal es facilitar la estructuración del código.
- En C$, los espacios de nombres son conceptualmente equivalentes a los **paquetes** en Java. Sin embargo, a diferencia de los paquetes, los espacios de nombres no dependen obligatoriamente de la estructura de carpetas del proyecto. En C#, el **namespace** es una organización lógica, mientras que en Java el **package** suele estar ligado a la estructura física del proyecto.


#### Namespace y Using en C#
- La palabra clave **namespace**  permite definir el espacio de nombres al que pertenece una clase.
- La palabra clave **using** permite acceder a los elementos de un espacio de nombres sin necesidad de escribir su nombre completo.
- Esto facilita la escritura del código y mejora su legilibilidad.

# Clase Operacion.cs

```csharp
namespace Matematicas {

    class Operacion {

        public int Sumar(int a, int b) {
            return a + b;
        }

    }

}
