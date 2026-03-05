package biblioteca;

public class Livros {

    public String titulo;
    public String autor;

    public Livros(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\nAutor: " + autor + "\n";
    }
}
