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
