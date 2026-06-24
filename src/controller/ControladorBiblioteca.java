package controller;

import exception.PesquisaException;
import exception.VazioException;
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
        try {
            regrasBiblioteca.pesquisarLivro(titulo);
            System.out.println("Livro encontrado com sucesso!");

        }catch (VazioException | PesquisaException e){
            System.out.println("Livro não encontrado!");
        }
    }

    public void remover(String titulo){
        try {
            regrasBiblioteca.removerLivro(titulo);
            System.out.println("Livro removido com sucesso!");

        }catch (VazioException | PesquisaException e){
            System.out.println("Não foi removido!");
        }
    }
}
