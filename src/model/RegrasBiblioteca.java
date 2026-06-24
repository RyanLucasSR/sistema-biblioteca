package model;

import exception.PesquisaException;
import exception.VazioException;

import java.util.ArrayList;
import java.util.List;

public class RegrasBiblioteca{
    List<LivroEmprestado> lista = new ArrayList<>();
    List<Integer> listaId = new ArrayList<>();
    List<Boolean> emprestimo = new ArrayList<>();


   public void cadastroLivros(String titulo, String autor) {
       lista.add(new LivroEmprestado(titulo, autor, seuID()));
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
       if (!lista.isEmpty() && lista.contains(titulo)) {
           lista.stream().filter(t -> t.getTitulo().equals(titulo)).forEach(System.out::println);

       } else {
           throw new PesquisaException();
       }
   }

   public void removerLivro(String titulo) {
       if(!lista.isEmpty()) {
           lista.removeIf(t -> t.getTitulo().equals(titulo));

       }else {
           throw new VazioException();
       }
   }

   public int gerarId(){
       int id = (int) (Math.random() * 9900) + 100;
       return id;
   }

   public int seuID(){
       int id = gerarId();
       boolean continuar = true;

      while(continuar){
          if(!listaId.contains(id)){
              listaId.add(id);
              continuar = false;

          }else {
              id = gerarId();
          }
      }
       return id;
   }

}
