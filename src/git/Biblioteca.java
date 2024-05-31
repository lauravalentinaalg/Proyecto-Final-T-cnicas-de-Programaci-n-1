package git;

import java.util.ArrayList;
import java.util.List;

// Clase Biblioteca
public class Biblioteca {
    // Lista de canciones en la biblioteca
    private List<Cancion> listaCanciones;

    // Constructor que acepta una lista de canciones
    public Biblioteca(List<Cancion> listaCanciones) {
       // Inicializa la lista de canciones con una copia de la lista proporcionada
       this.listaCanciones = new ArrayList<>(listaCanciones);
    }

    // Constructor sin parámetros
    public Biblioteca() {
        // Inicializa la lista como un nuevo ArrayList
        this.listaCanciones = new ArrayList<>();
    }
    
    // Método para agregar una canción a la biblioteca
    public void agregarCancion(Cancion cancion) {
        listaCanciones.add(cancion); // Agrega la canción a la lista
    }
    
    // Método para eliminar una canción de la biblioteca
    public void eliminarCancion(Cancion cancion) {
        listaCanciones.remove(cancion); // Elimina la canción de la lista
    }

    // Método para listar todas las canciones en la biblioteca
    public List<Cancion> obtenerTodasLasCanciones() {
        // Imprime cada canción en la lista
        for (Cancion cancion : listaCanciones) {
            System.out.println(cancion);
        }
        // Devuelve la lista de canciones
        return listaCanciones;
    }

    // Método para buscar canciones en la biblioteca según un criterio
    public List<Cancion> buscarCanciones(String criterio) {
        // Lista para almacenar las canciones encontradas
        List<Cancion> cancionesEncontradas = new ArrayList<>();
        // Recorre la lista de canciones
        for (Cancion cancion : listaCanciones) {
            // Si el nombre, artista, álbum o género de la canción coincide con el criterio, agregar a la lista de encontradas
            if (cancion.getNombre().equalsIgnoreCase(criterio) || 
                cancion.getArtista().equalsIgnoreCase(criterio) ||
                cancion.getAlbum().equalsIgnoreCase(criterio) ||
                cancion.getGenero().equalsIgnoreCase(criterio)) {
                cancionesEncontradas.add(cancion);
            }
        }
        // Devuelve la lista de canciones encontradas
        return cancionesEncontradas;
    }
}
