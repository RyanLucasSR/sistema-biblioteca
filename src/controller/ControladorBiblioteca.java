package controller;

import model.RegrasBiblioteca;

public class ControladorBiblioteca {

    RegrasBiblioteca regrasBiblioteca = new RegrasBiblioteca();

    public void adicionarLivros(String titulo, String autor ){
        regrasBiblioteca.cadastroLivros(titulo, autor);
    }

    public void listarLivros(){
        regrasBiblioteca.listarLivros();
    }

    public void buscarLivro(String titulo){
        regrasBiblioteca.pesquisarLivro(titulo);

    }

    public void remover(String titulo){
        regrasBiblioteca.removerLivro(titulo);
    }

    public void emprestarLivro(String titulo){
        regrasBiblioteca.emprestarLivro(titulo);
    }

    public void devolverLivro(String titulo){
        regrasBiblioteca.devolucaoLivro(titulo);
    }
}
