package git;

// Clase Cancion
public class Cancion {
    // Campos para almacenar la información de la canción
    private String nombre;
    private String album;
    private String artista;
    private String genero;
    private String rutaMP3; // Campo para almacenar la ruta del archivo MP3

    // Constructor
    public Cancion(String nombre, String album, String artista, String genero, String rutaMP3) {
        // Inicializa los campos con los valores proporcionados
        this.nombre = nombre;
        this.album = album;
        this.artista = artista;
        this.genero = genero;
        this.rutaMP3 = rutaMP3;
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRutaMP3() {
        return rutaMP3;
    }

    public void setRutaMP3(String rutaMP3) {
        this.rutaMP3 = rutaMP3;
    }

    // Método toString
    @Override
    public String toString() {
        // Devuelve una representación en cadena de la canción
        return "Canciones{" + "nombre=" + nombre + ", album=" + album + ", artista=" + artista + ", genero=" + genero + ", rutaMP3=" + rutaMP3 + '}';
    }
}
