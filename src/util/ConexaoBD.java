package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {

    //Informação da conexão com o banco de dados
   

    Connection conexao = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public static Connection conectar() {
        Connection conexao = null;

        try {

            Properties prop = new Properties();
            prop.load(new FileInputStream("src/util/config.properties"));
            
              String URL = "jdbc:mysql://"+prop.getProperty("host")+":"+prop.getProperty("port")+"/"+prop.getProperty("dbname");
              String USUARIO = prop.getProperty("user");
              String SENHA = prop.getProperty("password");
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar com banco de dados: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver JDBC: " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexao;

    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão com o banco de dados fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }

    public static void fecharConexao(Connection conexao, PreparedStatement pstmt) {
        if (conexao != null && pstmt != null) {
            try {
                conexao.close();
                pstmt.close();
                System.out.println("Conexão com o banco de dados fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }

    public static void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs) {
        if (conexao != null && pstmt != null && rs != null) {
            try {
                conexao.close();
                pstmt.close();
                rs.close();
                System.out.println("Conexão com o banco de dados fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }

}
