package model;

import exception.DevolucaoException;
import exception.EmprestadoException;
import exception.PesquisaException;
import exception.VazioException;

import java.util.ArrayList;
import java.util.List;

public class RegrasBiblioteca{
    List<Emprestimo> lista = new ArrayList<>();
    List<Emprestimo> emprestimo = new ArrayList<>();


   public void cadastroLivros(String titulo, String autor) {
       lista.add(new Emprestimo(titulo, autor));
       System.out.println("Livro cadastrado com sucesso!");
   }

   public void listarLivros() {
       if (!lista.isEmpty()) {
           lista.stream().forEach(System.out::println);
       }else {
           throw new VazioException();
       }
   }

   public void pesquisarLivro(String titulo) {
       if (!lista.isEmpty()) {
           lista.stream().filter(l -> l.getTitulo().equals(titulo)).forEach(System.out::println);
       } else {
           throw new PesquisaException();
       }
   }

   public void removerLivro(String titulo) {
       if(!lista.isEmpty()) {
           lista.removeIf(t -> t.getTitulo().trim().equalsIgnoreCase(titulo));
       }else {
           throw new VazioException();
       }
   }

   public void emprestarLivro(String titulo){
       boolean existeLivro = lista.stream().anyMatch(l -> l.getTitulo().equals(titulo));

       boolean jaEmprestado = emprestimo.stream().anyMatch(l -> l.getTitulo().equals(titulo));

       if(!existeLivro){
           throw new VazioException();
       }

       if(jaEmprestado){
           throw new EmprestadoException();
       }


       lista.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
               .forEach(l -> emprestimo.add(new  Emprestimo(l.getTitulo(),l.getAutor())));

       emprestimo.stream().forEach(System.out::println);
   }

   public void devolucaoLivro(String titulo) {
       boolean existeLivro = emprestimo.stream().anyMatch(l -> l.getTitulo().equals(titulo));

       boolean jaEmprestado = emprestimo.stream().anyMatch(l -> l.getTitulo().equals(titulo));

       if(!existeLivro){
           throw new VazioException();
       }

       if(!jaEmprestado){
           throw new DevolucaoException();
       }

       emprestimo.removeIf(l -> l.getTitulo().trim().equalsIgnoreCase(titulo));
   }
}
