package git;

import java.util.ArrayList;
import java.util.List;

// Clase ListaDeReproduccion
public class ListaDeReproduccion {
    // Nombre de la lista de reproducción
    private String nombre;
    // Lista de canciones en la lista de reproducción
    private List<Cancion> canciones;

    // Constructor que inicializa el nombre y crea una nueva lista de canciones
    public ListaDeReproduccion(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    // Getter para el nombre de la lista de reproducción
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre de la lista de reproducción
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener la lista de canciones
    public List<Cancion> getCanciones() {
        return canciones;
    }

    // Setter para establecer la lista de canciones
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    // Método para agregar una canción a la lista de reproducción
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    // Método para eliminar una canción de la lista de reproducción
    public void eliminarCancion(Cancion cancion) {
        canciones.remove(cancion);
    }

    // Método toString para devolver una representación en cadena de la lista de reproducción
    @Override
    public String toString() {
        return "ListaDeReproduccion{" +
                "nombre='" + nombre + '\'' +
                ", canciones=" + canciones +
                '}';
    }
}
