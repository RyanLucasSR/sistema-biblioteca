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
    public String toString() {
        return "==============\n" +
                "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nStatus: " +
                (isStatusLivro() ? "Disponível" : "Indisponível") + "\n==============\n";
    }
}
