# Proyecto Final Técnicas de Programación 1
# Documentación del Proyecto
Este proyecto consiste en un reproductor de música básico implementado en Java. Permite al usuario gestionar canciones, crear listas de reproducción, reproducir canciones individualmente o en listas, controlar la reproducción, buscar canciones en la biblioteca y realizar algunas operaciones básicas de administración de canciones y listas de reproducción.

Estructura del Proyecto
El proyecto está organizado en varias clases que cumplen funciones específicas:

Menu: Esta clase representa el menú de la aplicación y gestiona las opciones seleccionadas por el usuario.
Reproductor: Esta clase contiene la lógica principal del reproductor de música. Gestiona la reproducción de canciones, creación y gestión de listas de reproducción, control de volumen, búsqueda de canciones, entre otras funcionalidades.
Biblioteca: Esta clase es responsable de almacenar y gestionar la colección de canciones disponibles en la biblioteca del reproductor.
Cancion: Esta clase define la estructura de una canción, incluyendo su nombre, álbum, artista, género y ruta del archivo MP3.
ListaDeReproduccion: Esta clase representa una lista de reproducción, que contiene una colección de canciones.
Uso de la Aplicación
Al ejecutar la aplicación, se mostrará un menú con las siguientes opciones:

Crear canción.
Listar canciones.
Reproducir canción.
Pausar/Reanudar reproducción.
Avanzar/Retroceder en la canción.
Controlar volumen.
Buscar canciones.
Crear lista de reproducción.
Agregar canción a lista de reproducción.
Eliminar canción.
Ordenar canciones.
Listar listas de reproducción.
Salir de la aplicación.
El usuario puede seleccionar una opción ingresando el número correspondiente. Cada opción realiza una acción específica en el reproductor de música.

Limitaciones y Consideraciones
Algunas funcionalidades, como avanzar y retroceder en la canción y controlar el volumen, están comentadas o no implementadas debido a limitaciones en la biblioteca utilizada (jaco.mp3.player.MP3Player).
El proyecto no incluye una interfaz gráfica, por lo que todas las interacciones se realizan a través de la consola.
No se implementa persistencia de datos, por lo que la biblioteca de canciones y las listas de reproducción se reinician cada vez que se inicia la aplicación.
La búsqueda de canciones en la biblioteca se basa en criterios de coincidencia exacta, no se realizan búsquedas parciales o insensibles a mayúsculas y minúsculas.
Requisitos del Sistema
Para ejecutar la aplicación, se requiere tener instalado Java Development Kit (JDK) en el sistema.

Contribuciones
Este proyecto es de código abierto y las contribuciones son bienvenidas. Si desea contribuir, puede crear un fork del repositorio, realizar sus cambios y enviar una solicitud de extracción (pull request) con las mejoras propuestas.

Autor
Este proyecto fue creado por un desarrollador anónimo y está disponible públicamente en un repositorio de Git.Proyecto Final Técnicas de Programación 1
