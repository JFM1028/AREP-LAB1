# Mi Servidor Web en Java

Este proyecto es un servidor web básico implementado en Java que puede manejar solicitudes HTTP GET y POST. El servidor puede servir archivos estáticos como HTML, CSS, JavaScript e imágenes desde una estructura de directorios específica.

## Tabla de Contenidos

- [Características](#características)
- [Instalación](#instalación)
- [Ejecución](#ejecución)
- [Arquitectura del Proyecto](#arquitectura-del-proyecto)
- [Evaluación](#evaluación)

## Características

- Soporte para solicitudes HTTP GET y POST.
- Capacidad para servir archivos estáticos (HTML, CSS, JavaScript, imágenes).
- Respuestas adecuadas para solicitudes exitosas y errores 404.
- Implementación sencilla sin el uso de frameworks.

## Instalación

1. **Requisitos Previos**: Asegúrate de tener Java JDK instalado en tu máquina. Puedes verificarlo ejecutando el siguiente comando en la terminal:

   ```bash
   java -version

Si no tienes Java instalado, puedes descargarlo desde la página oficial de Oracle.

Clonar el Repositorio: Clona este repositorio en tu máquina local:

```bash
git clone <URL_DEL_REPOSITORIO>

cd mi-servidor-web

Ejecución
Compilar el Código: Abre una terminal en la carpeta raíz del proyecto y compila el código Java:
javac -d out src/main/java/*.java

Iniciar el Servidor: Ejecuta el servidor desde la carpeta out:
java -cp out Server

Probar la Aplicación Web: Abre tu navegador y navega a:

http://localhost:8080

Desde allí, puedes probar las funcionalidades de GET y POST.

Arquitectura del Proyecto
La estructura del proyecto es la siguiente:

/LAB_AREP1
|-- /src
|   |-- /main
|   |   |-- /java
|   |   |   |-- Server.java
|   |   |   |-- RequestHandler.java
|   |   |-- /resources
|   |   |   |-- index.html
|   |   |   |-- style.css
|   |   |   |-- script.js
|-- README.md
Server.java: Contiene la lógica principal del servidor, que escucha las solicitudes entrantes.
RequestHandler.java: Maneja las solicitudes HTTP y envía las respuestas adecuadas.
index.html: Página principal de la aplicación web.
style.css: Estilos para la aplicación web.
script.js: Lógica de JavaScript para manejar las interacciones del usuario.
Evaluación
Se realizaron las siguientes pruebas para evaluar el funcionamiento del servidor:

Pruebas de Solicitudes GET: Se verificó que el servidor pueda servir correctamente el archivo index.html y otros archivos estáticos.
Pruebas de Solicitudes POST: Se comprobó que el servidor pueda recibir y procesar datos enviados a través de solicitudes POST.
Manejo de Errores: Se probó el manejo de errores al solicitar archivos que no existen, asegurando que se devuelva un código de estado 404.