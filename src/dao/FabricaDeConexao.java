package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaDeConexao {

    public static Connection getConexao(){
        try{
            Properties prop = getProp();
            String url = prop.getProperty("banco.url");
            String usuario = prop.getProperty("banco.usuario");
            String senha = prop.getProperty("banco.senha");

            return DriverManager.getConnection(url,usuario,senha);
        }catch(IOException | SQLException e){
            throw new RuntimeException(e);
        }
    }

    private static Properties getProp() throws IOException {
        Properties prop = new Properties();
        String caminho = "/biblioteca.properties";
        prop.load(FabricaDeConexao.class.getResourceAsStream(caminho));
        return prop;
    }
}
