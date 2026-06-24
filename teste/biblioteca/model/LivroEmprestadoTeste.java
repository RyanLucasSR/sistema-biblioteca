package biblioteca.model;

import model.LivroEmprestado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LivroEmprestadoTeste {

   LivroEmprestado emprestado = new LivroEmprestado("Hercules", "nois", 15);

   @Test
   public void livroEmprestadoTrue(){
      emprestado.setEmprestado();
      assertTrue(emprestado.isEmprestado());
   }

   @Test
   public void livroEmprestadoTrueDuplo(){
      emprestado.setEmprestado();
      emprestado.setEmprestado();
      assertTrue(emprestado.isEmprestado());
   }

   @Test
   public void livroEmprestadoFalse(){
      assertFalse(emprestado.isEmprestado());
   }

   @Test
   public void livroDevolvido(){
      emprestado.setEmprestado();
      emprestado.setDevolver();
      assertFalse(emprestado.isEmprestado());
   }

   @Test
   public void livroNaoDevolvido(){
      emprestado.setDevolver();
      assertFalse(emprestado.isEmprestado());
   }
}
