package model;

import java.util.Objects;

public class Emprestimo extends Livro{

    public Emprestimo(String titulo, String autor) {
        super(titulo, autor);
    }

    private boolean statusLivro = false;

    public void setEmprestimo(){
        this.statusLivro = true;
    }

    public void setDevolucao(){
        this.statusLivro = false;
    }

    public boolean isStatusLivro() {
        return statusLivro;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return statusLivro == that.statusLivro;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(statusLivro);
    }

    @Override
    public String toString() {
        return "==============\n" +
                "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nStatus: " +
                (isStatusLivro() ? "Indisponível" : "Disponível") + "\n==============\n";
    }
}
