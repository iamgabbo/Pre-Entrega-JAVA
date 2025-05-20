# Pre-Entrega JAVA

Alumno BUSTAMANTE, GABRIEL
DNI 35.077.617


Este proyecto es una aplicación de consola desarrollada en Java para la gestión de artículos. Permite al usuario crear, listar, modificar y eliminar artículos mediante un menú interactivo.

## Funcionalidades

- ✅ Crear artículos con ID único, nombre y precio.
- ✅ Validaciones para evitar
  - IDs repetidos.
  - Ingreso de datos no numéricos en ID y precio.
  - Validar la existencia de artículos antes de pedir el ID para modificar o eliminar.
- ✅ Permite reintentos sin volver al menú principal si hay errores.
- ✅ Listado de artículos en pantalla.
- ✅ Salida controlada del programa.

## Archivos

- Main.java Contiene la lógica principal del menú y el manejo de la lista de artículos.
- Articulo.java Clase que representa un artículo con encapsulamiento (atributos privados y métodos públicos).