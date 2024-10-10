# Proyecto de Conversión de Monedas

Este proyecto es una aplicación Java que permite la conversión entre diferentes monedas. El usuario puede seleccionar entre varias opciones de conversión y proporcionar el monto que desea convertir. La aplicación utiliza un servicio de API para obtener las tasas de cambio actualizadas.

## Funcionalidades

- Conversión de USD a COP.
- Conversión de COP a USD.
- Conversión de USD a ARS.
- Conversión de ARS a USD.
- Conversión de USD a BRL.
- Conversión de BRL a USD.
- Validación de entrada: El programa solicita que se ingrese un número válido para el monto de la conversión.
- Opción para salir del programa.

## Estructura del Proyecto

El proyecto está dividido en tres clases principales:

1. **App**: Contiene el método principal (`main`) que es el punto de entrada del programa.
2. **Menu**: Muestra las opciones del menú al usuario, maneja la validación de la entrada y gestiona la interacción con el usuario.
3. **ExchangeService**: Gestiona la lógica de la conversión de monedas. 
4. **HttpService**: Hace uso de una API externa para obtener las tasas de cambio.

## Uso

### Requisitos previos

- Java 8 o superior.
- Una conexión a Internet para poder consultar las tasas de cambio mediante la API.

### Ejecución

1. Clona el repositorio o descarga el código fuente.
2. Compila el proyecto con tu IDE o desde la línea de comandos.
3. Ejecuta la clase `App` para iniciar el programa.
4. Sigue las instrucciones en el menú para realizar las conversiones de moneda.

### Ejemplo de uso

