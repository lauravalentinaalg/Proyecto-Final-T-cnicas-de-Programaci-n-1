package git;

import jaco.mp3.player.MP3Player;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Reproductor {
    // Escáner para entrada de usuario
    public static Scanner sc = new Scanner(System.in);
    // Lista de listas de reproducción
    private List<ListaDeReproduccion> listasDeReproduccion;
    // Biblioteca de canciones
    public static Biblioteca biblio = new Biblioteca();
    // Reproductor MP3
    private MP3Player mp3Player;
    // Volumen del reproductor
    private int volumen;

    // Constructor de la clase Reproductor
    public Reproductor() {
        this.listasDeReproduccion = new ArrayList<>();
        this.mp3Player = new MP3Player();
        this.volumen = 50;
    }

    // Método para reproducir una canción
    public void reproducirCancion(Cancion cancion) {
        mp3Player.stop(); // Detener cualquier canción en reproducción
        mp3Player = new MP3Player(new File(cancion.getRutaMP3())); // Cargar la nueva canción
        mp3Player.play(); // Reproducir la canción
        System.out.println("Reproduciendo: " + cancion.getNombre()); // Mostrar el nombre de la canción
    }

    // Método para agregar una canción al reproductor
    public void agregarCancionAReproductor(Cancion cancion) {
        mp3Player.addToPlayList(new File(cancion.getRutaMP3())); // Agregar la canción a la lista de reproducción
    }

    // Método para reproducir la lista completa de canciones
    public void reproducirListaCompleta() {
        mp3Player.play(); // Reproducir la lista completa
        System.out.println("Reproduciendo lista completa.");
    }

    // Método para configurar repetición y aleatorización
    public void configurarRepeticionYAleatorizacion(boolean repetir, boolean aleatorio) {
        mp3Player.setRepeat(repetir); // Configurar repetición
        mp3Player.setShuffle(aleatorio); // Configurar aleatorización
        System.out.println("Configuración de reproducción: Repetir - " + repetir + ", Aleatorio - " + aleatorio);
    }

    // Método estático para crear una canción y agregarla a la biblioteca
    public static void crearCancion() {
        System.out.println("Ingrese el nombre de la canción: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el nombre del álbum: ");
        String album = sc.nextLine();
        System.out.println("Ingrese el nombre del artista: ");
        String artista = sc.nextLine();
        System.out.println("Ingrese el género: ");
        String genero = sc.nextLine();
        System.out.println("Ingrese la ruta del archivo MP3: ");
        String rutaMP3 = sc.nextLine();
        Cancion cancion = new Cancion(nombre, album, artista, genero, rutaMP3); // Crear la canción
        biblio.agregarCancion(cancion); // Agregar la canción a la biblioteca
        System.out.println("Canción agregada correctamente a la biblioteca.");
    }

    // Método para listar todas las canciones
    public void listarCanciones() {
        List<Cancion> canciones = biblio.obtenerTodasLasCanciones(); // Obtener todas las canciones
        if (canciones.isEmpty()) {
            System.out.println("No hay canciones en la biblioteca.");
        } else {
            for (int i = 0; i < canciones.size(); i++) {
                System.out.println(i + ". " + canciones.get(i).getNombre()); // Listar las canciones con su índice
            }
        }
    }

    // Método para reproducir canciones según la opción del usuario
    public void reproducirCanciones() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Reproducir una canción específica.");
        System.out.println("2. Reproducir todas las canciones de la biblioteca.");
        int opcion = Integer.parseInt(sc.nextLine());
        
        if (opcion == 1) {
            System.out.println("Seleccione una canción para reproducir:");
            listarCanciones(); // Listar las canciones
            int indice = Integer.parseInt(sc.nextLine());
            List<Cancion> canciones = biblio.obtenerTodasLasCanciones();
            if (indice >= 0 && indice < canciones.size()) {
                Cancion cancion = canciones.get(indice);
                reproducirCancion(cancion); // Reproducir la canción seleccionada
            } else {
                System.out.println("Índice de canción inválido.");
            }
        } else if (opcion == 2) {
            List<Cancion> canciones = biblio.obtenerTodasLasCanciones();
            for (Cancion cancion : canciones) {
                agregarCancionAReproductor(cancion); // Agregar todas las canciones al reproductor
            }
            System.out.println("¿Desea repetir la lista? (si/no)");
            boolean repetir = sc.nextLine().equalsIgnoreCase("si");
            System.out.println("¿Desea reproducir de forma aleatoria? (si/no)");
            boolean aleatorio = sc.nextLine().equalsIgnoreCase("si");

            configurarRepeticionYAleatorizacion(repetir, aleatorio); // Configurar la repetición y aleatorización
            reproducirListaCompleta(); // Reproducir la lista completa
        } else {
            System.out.println("Opción no válida.");
        }
    }



    // Método para buscar canciones en la biblioteca
    public void buscarCanciones() {
        System.out.print("Ingrese el nombre, artista, álbum o género que desea: ");
        String criterio = sc.nextLine();
        List<Cancion> cancionesEncontradas = biblio.buscarCanciones(criterio); // Buscar canciones por el criterio
        if (cancionesEncontradas.isEmpty()) {
            System.out.println("No se encontraron canciones.");
        } else {
            System.out.println("Resultados de la búsqueda:");
            for (Cancion cancion : cancionesEncontradas) {
                System.out.println("Encontrada: " + cancion);
            }
        }
    }
    
    /*QUERIAMOS HACERLO ASÍ PERO RESULTA QUE EN LA LIBRERIA NO FUNCIONA LOS METODOS skipForward Y skipBackward  */
    // Método para avanzar y retroceder en la canción
    public void avanzarYRetroceder() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Avanzar 10 segundos");
        System.out.println("2. Retroceder 10 segundos");
        int opcion;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            return;
        }

        if (opcion == 1) {
            mp3Player.skipForward(); // Avanzar 10 segundos
            System.out.println("Avanzando 10 segundos.");
        } else if (opcion == 2) {
            mp3Player.skipBackward(); // Retroceder 10 segundos
            System.out.println("Retrocediendo 10 segundos.");
        } else {
            System.out.println("Opción inválida.");
        }
    }
    
    /*    
    QUERIAMOS HACERLO ASÍ PERO RESULTA QUE EN LA LIBRERIA NO EXISTIA EL MÉTODO SETVOLUME O NO FUNCIONA
    public void controlarVolumen() {
        System.out.println("Ingrese el nivel de volumen (0-100):");
        int nivel;
        try {
            nivel = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            return;
        }

        if (nivel >= 0 && nivel <= 100) {
            this.volumen = nivel;
            mp3Player.setVolume(volumen); // Configurar el volumen
            System.out.println("Volumen configurado a " + volumen + ".");
        } else {
            System.out.println("Nivel de volumen inválido. Por favor, ingrese un valor entre 0 y 100.");
        }
    }*/
    // Método para controlar el volumen (simulado)
    public void controlarVolumen() {
        System.out.println("Ingrese el nuevo volumen:");
        int nuevoVolumen = Integer.parseInt(sc.nextLine());
        System.out.println("Volumen ajustado a " + nuevoVolumen + "% (simulado).");
    }

    // Variable para verificar si la reproducción está en pausa
    private boolean enPausa = false;
    // Método para pausar o reanudar la reproducción
    public void pausarYReanudar() {
        System.out.println("¿Desea pausar o reanudar la reproducción? (1: Pausar, 2: Reanudar)");
        String opcion = sc.nextLine();
        if (opcion.equals("1")) {
            if (!enPausa) {
                mp3Player.pause(); // Pausar la reproducción
                System.out.println("Reproducción pausada.");
                enPausa = true;
            } else {
                System.out.println("La reproducción ya está en pausa.");
            }
        } else if (opcion.equals("2")) {
            if (enPausa) {
                mp3Player.play(); // Reanudar la reproducción
                System.out.println("Reproducción reanudada.");
                enPausa = false;
            } else {
                System.out.println("La reproducción no está en pausa.");
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }

    // Método para crear una lista de reproducción
    public void crearListaDeReproduccion() {
        System.out.println("Ingrese el nombre de la lista de reproducción:");
        String nombre = sc.nextLine();
        ListaDeReproduccion lista = new ListaDeReproduccion(nombre); // Crear la lista de reproducción
        listasDeReproduccion.add(lista); // Agregar la lista al reproductor
        System.out.println("Lista de reproducción creada.");
    }

    // Método para agregar una canción a una lista de reproducción
    public void agregarCancionALista() {
        System.out.println("Seleccione la lista de reproducción:");
        listarListasDeReproduccion(); // Listar las listas de reproducción
        int indiceLista;
        try {
            indiceLista = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            return;
        }

        if (indiceLista >= 0 && indiceLista < listasDeReproduccion.size()) {
            ListaDeReproduccion lista = listasDeReproduccion.get(indiceLista);
            System.out.println("Seleccione la canción para agregar:");
            listarCanciones(); // Listar las canciones
            int indiceCancion;
            try {
                indiceCancion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                return;
            }

            List<Cancion> canciones = biblio.obtenerTodasLasCanciones();
            if (indiceCancion >= 0 && indiceCancion < canciones.size()) {
                Cancion cancion = canciones.get(indiceCancion);
                lista.agregarCancion(cancion); // Agregar la canción a la lista de reproducción
                System.out.println("Canción agregada correctamente a la lista de reproducción.");
            } else {
                System.out.println("Índice de canción inválido.");
            }
        } else {
            System.out.println("Índice de lista de reproducción inválido.");
        }
    }

    // Método para listar todas las listas de reproducción
    public void listarListasDeReproduccion() {
        if (listasDeReproduccion.isEmpty()) {
            System.out.println("No hay listas de reproducción.");
        } else {
            for (int i = 0; i < listasDeReproduccion.size(); i++) {
                System.out.println(i + ". " + listasDeReproduccion.get(i).getNombre()); // Listar las listas con su índice
            }
        }
    }

    // Método para eliminar una canción de la biblioteca
    public void eliminarCancion() {
        System.out.println("Seleccione una canción para eliminar:");
        List<Cancion> canciones = biblio.obtenerTodasLasCanciones();
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println(i + ". " + canciones.get(i).getNombre());
        }
        int indice = Integer.parseInt(sc.nextLine());
        if (indice >= 0 && indice < canciones.size()) {
            Cancion cancion = canciones.get(indice);
            biblio.eliminarCancion(cancion); // Eliminar la canción de la biblioteca
            System.out.println("Canción eliminada correctamente.");
        } else {
            System.out.println("Índice de canción inválido.");
        }
    }

    // Método para ordenar las canciones
    public void ordenarCanciones() {
        List<Cancion> canciones = biblio.obtenerTodasLasCanciones();
        if (canciones.isEmpty()) {
            System.out.println("No hay canciones en la biblioteca.");
            return;
        }

        System.out.println("Seleccione el criterio de ordenación:");
        System.out.println("1. Por nombre");
        System.out.println("2. Por álbum");
        System.out.println("3. Por artista");
        System.out.println("4. Por género");
        int opcion;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            return;
        }

        switch (opcion) {
            case 1:
                Collections.sort(canciones, Comparator.comparing(Cancion::getNombre)); // Ordenar por nombre
                break;
            case 2:
                Collections.sort(canciones, Comparator.comparing(Cancion::getAlbum)); // Ordenar por álbum
                break;
            case 3:
                Collections.sort(canciones, Comparator.comparing(Cancion::getArtista)); // Ordenar por artista
                break;
            case 4:
                Collections.sort(canciones, Comparator.comparing(Cancion::getGenero)); // Ordenar por género
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        System.out.println("Canciones ordenadas correctamente.");
        for (Cancion cancion : canciones) {
            System.out.println(cancion.getNombre() + " - " + cancion.getAlbum() + " - " + cancion.getArtista() + " - " + cancion.getGenero());
        }
    }
    
    // Método para salir de la aplicación
    public void salirDeAplicacion() {
        System.out.println("Saliendo de la aplicación...");
        System.exit(0);
    }    
}
