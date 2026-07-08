package model;

import java.util.Objects;

public class Livro {

    private String titulo;
    private String autor;
    private boolean statusLivro = false;

    public Livro(String titulo, String autor) {
        setTitulo(titulo);
        setAutor(autor);
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        if (titulo.length() > 1) {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    private void setAutor(String autor) {
        if (autor.length() > 1) {
            this.autor = autor;
        }
    }

    public boolean isStatusLivro() {
        return statusLivro;
    }

    public void setEmprestimo(String titulo) {
        if(this.getTitulo().equalsIgnoreCase(titulo)) {
            statusLivro = true;
        }
    }

    public void setDevolucao(String titulo) {
        if(this.getTitulo().equalsIgnoreCase(titulo)) {
            statusLivro = false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return statusLivro == livro.statusLivro && Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, statusLivro);
    }

    @Override
    public String toString() {
        return "==============\n" +
                "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nStatus: " +
                (isStatusLivro() ? "Indisponível" : "Disponível") + "\n==============\n";
    }
}
