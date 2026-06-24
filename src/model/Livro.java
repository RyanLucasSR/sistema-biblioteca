package biblioteca;

public class Livro {

    private String titulo;
    private String autor;

    public Livro(String titulo, String autor){
        setTitulo(titulo);
        setAutor(autor);
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        if (titulo.length() >= 1) {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    private void setAutor(String autor) {
        if (autor.length() >= 1) {
            this.autor = autor;
        }
    }

    @Override
    public String toString() {
        return "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\n";
    }
}
