package controller;

import exception.DevolucaoException;
import exception.EmprestadoException;
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
            e.getMessage();
        }
    }

    public void remover(String titulo){
        try {
            regrasBiblioteca.removerLivro(titulo);
            System.out.println("Livro removido com sucesso!");

        }catch (VazioException | PesquisaException e){
            e.getMessage();
        }
    }

    public void EmprestarLivro(String titulo){
        try {
            regrasBiblioteca.emprestarLivro(titulo);
            System.out.println("Livro emprestado com sucesso!");
        }catch (EmprestadoException | VazioException e){
            e.getMessage();
        }
    }

    public void devolverLivro(String titulo){
        try{
            regrasBiblioteca.devolucaoLivro(titulo);
            System.out.println("Livro devolvido com sucesso!");
        }catch (VazioException | DevolucaoException e){
            e.getMessage();
        }
    }
}
