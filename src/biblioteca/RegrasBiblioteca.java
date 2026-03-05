package biblioteca;

import java.util.ArrayList;

public class RegrasBiblioteca {
    ArrayList<Livros> lista = new ArrayList<>();

   public void cadastroLivros(String titulo, String autor) {
       lista.add(new Livros(titulo, autor));
   }

   public void  listarLivros() {
       for(Livros livros : lista){
           System.out.println(livros);
       }
   }

   public String obterLivro(String titulo) {
       for(Livros livro : lista){
           if(livro.titulo.equalsIgnoreCase(titulo)){
               return livro.titulo;
           }
       }
       return null;
   }

}
