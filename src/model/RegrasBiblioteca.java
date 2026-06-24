package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class RegrasBiblioteca{
    List<Livro> lista = new ArrayList<>();

    //add livros no list e no contrutor livros
   public void cadastroLivros(String titulo, String autor) {
       lista.add(new Livro(titulo, autor));
       System.out.println("Livro cadastrado com sucesso!");
   }

   public void listarLivros() {
       lista.forEach(System.out::println);
       System.out.println("Fim lista!");
   }

   public void pesquisarLivro(String titulo) {
       boolean encontrado = false;
       for(Livro livro : lista){
           if(livro.getTitulo().equalsIgnoreCase(titulo)){
               System.out.println(livro);
               encontrado = true;
           }
       }
       if(encontrado == true){
           System.out.println("Pesquisa encontrada com sucesso!!");

       }
       else{
           System.out.println("Pesquisa não encontrada!");
       }
   }

   public void removerLivro(String titulo) {
       Livro livroRemover = null;
       for(Livro livro : lista){
           if(livro.getTitulo().equalsIgnoreCase(titulo) && livro.getTitulo() != null){
               livroRemover = livro;
           }
       }
       if(livroRemover != null){
           lista.remove(livroRemover);
           System.out.println("Removido com sucesso!");

       }
       else{
           System.out.println("Erro ao remover livro!");
       }
   }

}
