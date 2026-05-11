#### Librerias y componentes reutilizables en Java

¿Qué es un componente Reutilizable?
Es una **pieza de software** diseñada para ser **usada varias veces** en distintos programas o móduos sin tener que volver a escribirla.

En Java, un componente reutilizable puede ser por ejemplo:
- Conjunto de clases
- Paquetes
- Librerias (JAR)
- Módulos o servicios

En C#, puede ser:
- Conjunto de clases
- Ensamblados (.dll, .exe)
- Librerías (ensamblados reutilizables)

#### Características de un componente Reutilizable
- Modular: Debe cumplir una función específica.
- Independiente: No debe depender demasiado de otras partes del sistema.
- Flexible: Debe poder adaptarse a distintos contextos.
- Encapsulado: Debe ocultar su implementación interna y exponer solo lo necesario.
- Mantenible: Debe ser fácil de modificar y mejorar
- Documentado: Debe indicar cómo se usa, qué recibe y qué devuelve.

#### Principios para construir componentes reutilizables
- Alta cohesión: El componente debe hacer una sola tarea bien definida.
- Bajo acoplamiento: Debe depender lo menos posible de otras clases.
- Encapsulamiento: Los datos internos deben protegerse usando atributos privados y métodos públicos.
- Generalización: No debe ser diseñado solo para un caso específico.

#### Paquete
- Contenedor de clases relacionadas que permite organizar las distintas partes de un programa.
- Generalmente, agrupa clases que comparten una misma funcionalidad o propósito.
- Siguen una estructura jerárquica, que facilita la organización y mantenimiento del sistema.


<img width="828" height="413" alt="image" src="https://github.com/user-attachments/assets/4fcef102-828c-443a-8422-4bde09b9d9f9" />


Paquete matematicas
<pre>
package matematicas;

public class Operacion {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

}
</pre>


Paquete principales
<pre>
package principales;

import matematicas.*;

public class Principal {

    public static void main(String[] args) {

        Operacion op = new Operacion();

        int x = op.sumar(10, 90);
        int y = op.restar(10, 90);

        System.out.println(x);
        System.out.println(y);

    }

}
</pre>

***Se compila empezando por las clases menos dependientes***


<pre>
C:\LP2> javac matematicas/*.java
C:\LP2> javac principales/*.java
C:\LP2> java principales/Principal
</pre>


#### Librerias
- Conjunto de código reutilizable (clases, funciones, etc) que puede ser utilizado por otros programas.
- Permite reutilizar funcionalidades sin necesidad de volver a implementarlas.
- La forma de crear y utilizar una libreria depende del lenguaje de programación o del sistema operativo.

### Librerías en Java
- Es una archivo ***.jar*** que contiene un conjunto de clases compiladas **(.class)** reutilizables.
- Permite agrupar y distribuir funcionalidades que pueden ser utilizadas por diferentes aplicaciones.
- Para utilizar una librería, se debe incluir en el **CLASSPATH**, que es donde la **JVM** busca las clases necesarias.

**Creación**

1. Generar los archivos CLASS que conformarán la librería.
2. Empaquetar los archivos CLASS mediante el siguiente comando:   
 <pre>jar cvf "nombre del paquete" [clases]</pre>
  Ejm:
  <pre>jar cvf Paq1.jar Foo.class Bar.class</pre>

**Archivos JAR**
- Comprimen uno o más paquetes conservado la información acerca de los directorios (paquetes) donde se encuentran cada archivo .CLASS.
- Pueden ser utilizados en CLASSPATH como lugares de búsqueda de archivos .CLASS.
- Constituyen una mejor forma de distribuir un conjunto de archivos .CLASS, como los que forman un aplicación, dado que se tiene la opción de comprimir estos.

**Ejemplo:**
- Generación de una librería del paquete "matemáticas".
<pre>
C:\LP2>jar cvf paquete1.jar matematicas/*.class
</pre>

- Compilando utilizando la librería "matemáticas".
- Ejecutando el programa principal utilizando la librería "matematicas".

<pre>
C:\LP2>javac -cp paquete1.jar principales/*.java
C:\LP2>java -cp paquete1.jar; principales/Principal
</pre>

***Librerías en Java - JAR Ejecutable**
- Es necesario modificar el Manifiesto e indicar en este archivo las librerías que usa el programa en la variable CLASSPATH y la clase principal.

<pre>
Manifest-Version: 1.0
Created-By: 1.8.0_92 (Oracle Corporation)
Class-Path: paquete1.jar
Main-Class: principales/Principal
</pre>

- Creamos el paquete ejecutable.

<pre>C:\LP2>jar cvfm -mipaqueteejecutable.jar MANIFEST.MF principales/*.class</pre>

- Ejecutamos el paquete.
<pre>
C:\LP2>java -jar mipaqueteejecutable.jar
</pre>

  






