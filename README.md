# Gestión de empleados, operaciones CRUD

Este proyecto de gestión de turnos proporciona una interfaz a través de una aplicación web para administrar los registros de turnos almacenados en una base de datos. Incluye todas las operaciones CRUD básicas.

## Estructura del Proyecto

### Clases Principales

#### Clase `TURNO`

- **Función**: Representación de un turno.
- **Responsabilidades**:
  - Representar el Turno 
  - Definir la estructura de los datos de un turno.
  - Proporcionar métodos para acceder y modificar los datos del turno.
  - Proporcionar métodos para mostrar los datos de un  turno en forma de String

#### Clase `Ciudadano`

- **Función**: Representación de un ciudadano.
- **Responsabilidades**:
  - Definir la estructura de los datos de un ciudadano.
  - Proporcionar métodos para acceder y modificar los datos del ciudadano.
- Proporcionar métodos para mostrar los datos de un ciudadano en forma de String

#### PAQUETE `Util`

- **Función**: Distintas clases con distintas herramientas 
- **Responsabilidades**:
  - Definición de enum para el estado del turno (EnumEstadoTurno.java)
  - Validación para el Turno. Tiene un método que valida que el id a editar o eliminar no sea <= 0
 - Generación de un numero de turno aleatorio conformado por CIIIIIC donde C es siempre un character e I, es casi siempre un int

#### Clase `Controladora`

- **Función**: Lógica de negocio y control de operaciones de base de datos.
- **Responsabilidades**:
  - Comunicarse con `ControladoraPersistencia` para ejecutar operaciones CRUD.
  - Gestionar la creación, edición, eliminación y búsqueda de turnos
 - Proporcionar métodos para el filtrado de turnos por estado y por fecha

#### Clase `ControladoraPersistencia`

- **Función**: Lógica de negocio y control de operaciones de base de datos.
- **Responsabilidades**:
  - Comunicarse con `los JPA Controllers de turno y ciudadano` para ejecutar operaciones CRUD.
  - Gestionar la creación, edición, eliminación y búsqueda de turnos
  - Proporcionar métodos para el filtrado de turnos por estado y por fecha
  
#### Servlets 

- **Función**: Gestión de solicitudes y respuestas
- **Responsabilidades**:
  - Manejar solicitudes HTTP recibidas
  - Generar respuestas a las solicitudes

## Lista Servlets

 -SvTurnos  permite crear un Turno recibido desde un formulario
- SvEliminarTurnos, permite la eliminación de un turno en base al id
- SvEditarTurnos, permite la edición de un turno en base al id
- SvFiltrarEstado, permite el filtrado de turnos en base al estado
- SvFiltrarFecha, permite el filtrado de turnos en base a la fecha

## Requisitos

- JDK (Java Development Kit)
- MySQL u otros motores compatibles con JPA
- Java 8 o superior
- Apache Tomcat 9 o un servidor compatible

## Uso

1. Configurar la base de datos y la fuente de datos en el archivo de configuración de JPA
2. Asegurarse de que el servidor Tomcat esté correctamente configurado.
3. Ejecutar la aplicación.

## Mapa de características

Al ejecutar, estaremos en una página con distintas opciones. 
1. Rellenar un formulario de vario campos para crear un turno en base a los mismos
2. Botón para ir a una página que lista los registros de turnos y permite filtrarlos
3. Un input que permite eliminar el turno con el id que introduzcamos
3. Un input que nos permite editar el turno con el id que introduzcamos, llevándonos a un   formulario de edición en otra págona

## Autores

- Martín Díaz Cantero
  
