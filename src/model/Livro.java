package model;

import java.util.Objects;

public class Livro {

    private String titulo;
    private String autor;
    private int id;
    private boolean statusLivro = false;

    public Livro(int id, String titulo, String autor, boolean statusLivro) {
        setTitulo(titulo);
        setAutor(autor);
        setId(id);
        setStatusLivro(statusLivro);
    }

    public Livro(String titulo, String autor, boolean statusLivro) {
        setTitulo(titulo);
        setAutor(autor);
        setStatusLivro(statusLivro);
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

    public void setStatusLivro(boolean statusLivro) {
        this.statusLivro = statusLivro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmprestimo() {
        statusLivro = true;
    }

    public void setDevolucao() {
        statusLivro = false;
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
