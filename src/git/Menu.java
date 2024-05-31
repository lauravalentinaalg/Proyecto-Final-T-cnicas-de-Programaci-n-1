package git;

import java.util.Scanner;

// Clase principal que representa el menú de la aplicación
public class Menu {
    // Se crea un objeto Scanner para la entrada de usuario
    public static Scanner sc = new Scanner(System.in);
    // Se instancia un objeto de la clase Biblioteca para gestionar las canciones
    public static Biblioteca biblio = new Biblioteca(); // ver si aca es necesario llamar esto o lo quito
    // Se instancia un objeto de la clase Reproductor para reproducir y gestionar canciones
    public static Reproductor reproductor = new Reproductor();

    // Método principal de la aplicación
    public static void main(String[] args) {
        int opc;
        // Bucle principal que muestra el menú y gestiona las opciones del usuario
        do {
            mostrarMenu(); // Mostrar el menú
            opc = Integer.parseInt(sc.nextLine()); // Leer la opción seleccionada por el usuario
            // Evaluar la opción seleccionada por el usuario y ejecutar la acción correspondiente
            switch (opc) {
                case 1:
                    reproductor.crearCancion();
                    break;
                case 2:
                    reproductor.listarCanciones();
                    break;
                case 3:
                    reproductor.reproducirCanciones();
                    break;
                case 4:
                    reproductor.pausarYReanudar();
                    break;
                case 5:
                    reproductor.avanzarYRetroceder();
                    break;
                case 6:
                    reproductor.controlarVolumen();
                    break;
                case 7:
                    reproductor.buscarCanciones();
                    break;
                case 8:
                    reproductor.crearListaDeReproduccion();
                    break;
                case 9:
                    reproductor.agregarCancionALista();
                    break;
                case 10:
                    reproductor.eliminarCancion();
                    break;
                case 11:
                    reproductor.ordenarCanciones();
                    break;
                case 12:
                    reproductor.listarListasDeReproduccion();
                    break;
                case 13:
                    reproductor.salirDeAplicacion();
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción del menú.");
            }
        } while (opc != 12); // El bucle se ejecuta hasta que el usuario selecciona la opción 12 (Salir de la aplicación)
    }

    // Método para mostrar el menú en la consola
    public static void mostrarMenu() {
        // Imprimir el encabezado del menú
        System.out.println("----------------------------------------------");  
        System.out.println("¡Bienvenido/a!");
        System.out.println("----------------------------------------------");
        // Imprimir las opciones principales del menú
        System.out.println("1. Crear canción.");
        System.out.println("2. Listar canciones.");
        System.out.println("3. Reproducir canción.");
        System.out.println("4. Pausar/Reanudar reproducción.");
        System.out.println("5. Avanzar/Retroceder en la canción.");
        System.out.println("6. Controlar volumen.");
        System.out.println("----------------------------------------------");
        // Imprimir las opciones secundarias del menú
        System.out.println("7. Buscar canciones.");
        System.out.println("8. Crear lista de reproducción.");
        System.out.println("9. Agregar canción a lista de reproducción.");
        System.out.println("10. Eliminar canción.");
        System.out.println("11. Ordenar canciones.");
        System.out.println("12. Listar listas de reproducción.");
        System.out.println("----------------------------------------------");
        // Imprimir la opción para salir de la aplicación
        System.out.println("13. Salir de la aplicación.");
        System.out.println("----------------------------------------------");
        // Solicitar al usuario que seleccione una opción
        System.out.println("Seleccione una opción: ");
        System.out.println("----------------------------------------------");
    }
}
