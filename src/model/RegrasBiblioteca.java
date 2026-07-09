package model;

import exception.PesquisaException;
import exception.VazioException;

import java.util.ArrayList;
import java.util.List;

public class RegrasBiblioteca{
    List<Livro> lista = new ArrayList<>();

   public void cadastroLivros(String titulo, String autor) {
       lista.add(new Livro(titulo, autor));
   }

   public void listarLivros() {
       if (!lista.isEmpty()) {
           lista.forEach(System.out::println);
       }else {
           throw new VazioException();
       }
   }

   public void pesquisarLivro(String titulo) {
       if (!lista.isEmpty() && titulo != null) {
           lista.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                   .forEach(System.out::println);
       } else {
           throw new PesquisaException();
       }
   }

   public void removerLivro(String titulo) {
       if(!lista.isEmpty() && titulo != null) {
           lista.removeIf(t -> t.getTitulo().trim().equalsIgnoreCase(titulo));
       }else {
           throw new VazioException();
       }
   }

   public void emprestarLivro(String titulo){
       boolean existeLivro = lista.stream().anyMatch(l -> l.getTitulo().equalsIgnoreCase(titulo));

       if(!lista.isEmpty() && !existeLivro) {
           throw new VazioException();
       }

       lista.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
               .forEach(l -> l.setEmprestimo());
   }

   public void devolucaoLivro(String titulo) {
       boolean existeLivro = lista.stream().anyMatch(l -> l.getTitulo().equalsIgnoreCase(titulo));

       if(!lista.isEmpty() && !existeLivro) {
           throw new VazioException();
       }

       lista.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
               .forEach(l -> l.setDevolucao());
   }
}
