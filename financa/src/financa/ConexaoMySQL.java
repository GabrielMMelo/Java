/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;
import java.sql.Connection;
 
import java.sql.DriverManager;
 
import java.sql.SQLException;

import java.sql.Statement;

 
/**
 *
 * @author melo
 */
 
public class ConexaoMySQL {
 
             public static String status = "Não conectou...";
 
//Método Construtor da Classe//
 
        public ConexaoMySQL() {
 
    }
 
  
 
//Método de Conexão//
 
public static java.sql.Connection getConexaoMySQL() {
 
        Connection connection = null;          //atributo do tipo Connection
 
  
 
try {
 
// Carregando o JDBC Driver padrão
 
String driverName = "com.mysql.jdbc.Driver";                        
 
Class.forName(driverName);
 
  
 
// Configurando a nossa conexão com um banco de dados//
 
            String serverName = "localhost";    //caminho do servidor do BD
 
            String mydatabase ="financa";        //nome do seu banco de dados
 
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
 
            String username = "root";        //nome de um usuário de seu BD      
 
            String password = "vasco2202";      //sua senha de acesso
 
            connection = DriverManager.getConnection(url, username, password);
 
  
 
            //Testa sua conexão//  
 
            if (connection != null) {
 
                status = ("STATUS--->Conectado com sucesso!");
 
            } else {
 
                status = ("STATUS--->Não foi possivel realizar conexão");
 
            }
 
  
 
            return connection;
 
  
 
        } catch (ClassNotFoundException e) {  //Driver não encontrado
 
  
 
            System.out.println("O driver expecificado nao foi encontrado.");
 
            return null;
 
        } catch (SQLException e) {
 
//Não conseguindo se conectar ao banco
 
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
 
            return null;
 
        }
 
  
 
    }
 
  
 
    //Método que retorna o status da sua conexão//
 
    public static String statusConection() {
 
        return status;
 
    }
 
   
 
   //Método que fecha sua conexão//
 
    public static boolean FecharConexao() {
 
        try {
 
            ConexaoMySQL.getConexaoMySQL().close();
 
            return true;
 
        } catch (SQLException e) {
 
            return false;
 
        }
 
  
 
    }
 
   
 
   //Método que reinicia sua conexão//
 
    public static java.sql.Connection ReiniciarConexao() {
 
        FecharConexao();
 
  
 
        return ConexaoMySQL.getConexaoMySQL();
 
    }
    
    public void insert(String table, String dia, String entrada, String saida, String tagId) throws SQLException{
        Connection conexao = this.getConexaoMySQL(); 
        Statement comando = conexao.createStatement();
        comando.executeUpdate("INSERT INTO " + table + " (dia, saida, entrada, tagId) VALUES (" + dia + ", "+ saida + ", " + entrada + ", " + tagId + ");");    
        comando.close();
        conexao.close();
    }
    
    public void insert(String table, String idTag, String descricao) throws SQLException{
        Connection conexao = this.getConexaoMySQL(); 
        Statement comando = conexao.createStatement();
        comando.executeUpdate("INSERT INTO " + table + " (tagId, descricao) VALUES (" + idTag + ", " + descricao + ");");
        comando.close();
        conexao.close();
    }
 
}
