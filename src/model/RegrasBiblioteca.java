package model;

import exception.PesquisaException;
import exception.VazioException;

import java.util.ArrayList;
import java.util.List;

public class RegrasBiblioteca{
    List<Livro> lista = new ArrayList<>();
    List<Integer> listaId = new ArrayList<>();
    List<Boolean> emprestimo = new ArrayList<>();


   public void cadastroLivros(String titulo, String autor) {
       lista.add(new Livro(titulo, autor));
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
}
