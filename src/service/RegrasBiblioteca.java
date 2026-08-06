package service;

import dao.LivroDAO;
import exception.LivroException;
import exception.VazioException;
import model.Livro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegrasBiblioteca {

    LivroDAO livroDAO = new LivroDAO();

    public void cadastroLivros(String titulo, String autor, boolean statusLivro) throws SQLException {

        if(titulo == null || titulo.isBlank() || autor == null || autor.isBlank()) {
            throw new VazioException();
        }

        Livro livro = new Livro(titulo, autor, statusLivro);

        livroDAO.inserirLivro(livro);
    }

    public List<Livro> listarLivros() throws SQLException {
        return livroDAO.listarLivros();
    }

    public List<Livro> pesquisarLivro(String titulo) throws SQLException {

        if(titulo == null || titulo.isBlank()) {
            throw new VazioException();
        }

        return livroDAO.pesquisarLivros(titulo);
    }

    //TODO refaorar com usuario adicionando sim para atualizar
    public void atualizarLivro(int id, String titulo, String autor, boolean statusLivro) throws SQLException {

        if(titulo == null || titulo.isBlank() || autor == null || autor.isBlank() || id <= 0) {
            throw new VazioException();
        }

        Livro livro = livroDAO.consultarLivro(id);

        if(livro == null){
            throw new VazioException();
        }

        livroDAO.atualizarLivro(id, titulo, autor, statusLivro);
    }

    public void removerLivro(int id) throws SQLException {

        if(id <= 0){
            throw new VazioException();
        }

        Livro livro = livroDAO.consultarLivro(id);

        if(livro == null){
            throw new VazioException();
        }

        livroDAO.excluirLivro(id);
    }

    public Livro consultarLivro(int id) throws SQLException {

        if(id <= 0){
            throw new VazioException();
        }

        return livroDAO.consultarLivro(id);
    }

//    TODO implementar emprestimo e devolução
   public void emprestarLivro(int id) throws SQLException {

        Livro livro;

        if(id < 0) {
            throw new VazioException();
        }

        livro = livroDAO.consultarLivro(id);

        if(livro == null){
            throw new VazioException();
        }

        if(livro.isStatusLivro()){
           livroDAO.emprestarLivro(id);
       }else{
            throw new LivroException("Livro indisponivel!");
        }
   }
   public void devolverLivro(int id) throws SQLException {

        Livro livro;

        if(id < 0) {
            throw new VazioException();
        }

        livro = livroDAO.consultarLivro(id);

        if(livro == null){
            throw new VazioException();
        }

        if(!livro.isStatusLivro()){
           livroDAO.devolverLivro(id);
       }else{
            throw new LivroException("O livro já está disponível!");
        }
   }
}
