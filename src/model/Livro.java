package model;

import java.util.Objects;

public class Livro {

    private String titulo;
    private String autor;
    private int idLivro;
    private boolean statusLivro = false;

    public Livro(String titulo, String autor, int idLivro) {
        setTitulo(titulo);
        setAutor(autor);
        setIdLivro(idLivro);
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

    public int getIdLivro() {
        return idLivro;
    }

    private void setIdLivro(int idLivro) {
        if(idLivro > 0){
            this.idLivro = idLivro;

        }
    }

    private void setEmprestimo(){
        this.statusLivro = true;
    }

    private void setDevolucao(){
        this.statusLivro = false;
    }

    public boolean isStatusLivro() {
        return statusLivro;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return idLivro == livro.idLivro && Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, idLivro);
    }

    @Override
    public String toString() {
        return "==============\n" +
                "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nStatus: " +
                (isStatusLivro() ? "Disponível" : "Indisponível") + "\n==============\n";
    }
}
