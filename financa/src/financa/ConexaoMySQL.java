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

import java.sql.ResultSet;

 
/**
 *
 * @author melo
 */
 
public class ConexaoMySQL {
 
            public static String status = "Não conectou...";
            public static String newline = System.getProperty("line.separator");
 
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
    
    public void insert(String table, int dia, float entrada, float saida, String tag) throws SQLException{
        Connection conexao = this.getConexaoMySQL(); 
        Statement comando = conexao.createStatement();
        //comando.executeUpdate("INSERT INTO " + table + " (dia, saida, entrada, tagId) VALUES (" + dia + ", "+ saida + ", " + entrada + ", " + tag + ");");    
        comando.executeUpdate("UPDATE " + table + " SET  saida = saida + " +saida + ", entrada = entrada + " + entrada + ", tag = CONCAT(tag,'- ', '" + tag + "') WHERE dia = "+ dia + ";");     
        
        comando.close();
        conexao.close();
    }
    
   /* public void insert(String table, String idTag, String descricao) throws SQLException{
        Connection conexao = this.getConexaoMySQL(); 
        Statement comando = conexao.createStatement();
        comando.executeUpdate("INSERT INTO " + table + " (tagId, descricao) VALUES (" + idTag + ", " + descricao + ");");
        comando.close();
        conexao.close();
    }
    */
    
    public String select(String table) throws SQLException {
        Connection conexao = this.getConexaoMySQL(); 
        Statement comando = conexao.createStatement();
        ResultSet linhas = comando.executeQuery ("SELECT * FROM " + table + ";" );
        String str = "";
      /*  if ("TAG".equals(table)){
            while (linhas.next()) {
                String tag = linhas.getString("tagId");
                String descricao = linhas.getString("descricao"); 
                str += tag + ", " + descricao + newline;
              }   
        }
        
        else{
      */
        while (linhas.next()) {
            String dia = linhas.getString("DIA");
            float saida = (float) linhas.getDouble("SAIDA");
            float entrada = (float) linhas.getDouble("ENTRADA");
            String tag = linhas.getString("tag");
            str += dia + ", " + saida + ", " + entrada + ", " + tag + newline;

        }
      //  }
        
        comando.close();
        conexao.close();
        System.out.println(str);
        return str;
    }
            
    
    public void select(Ano ano, String table) throws SQLException {
        Connection conexao = this.getConexaoMySQL(); 
        Statement comando = conexao.createStatement();
        ResultSet linhas = comando.executeQuery ("SELECT * FROM " + table + ";" );
        String str = "";
        
        while (linhas.next()) {
            String dia = linhas.getString("DIA");
            float saida = (float) linhas.getDouble("SAIDA");
            float entrada = (float) linhas.getDouble("ENTRADA");
            String tag = linhas.getString("tag");
            if ("JANEIRO".equals(table)){
                ano.novaTransacao(1, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(1, Integer.parseInt(dia), false, entrada, tag);
            }
            else if ("FEVEREIRO".equals(table)){
                ano.novaTransacao(2, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(2, Integer.parseInt(dia), false, entrada, tag);
            }
            else if ("MARCO".equals(table)){
                ano.novaTransacao(3, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(3, Integer.parseInt(dia), false, entrada, tag);
            }
            else if ("ABRIL".equals(table)){
                ano.novaTransacao(4, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(4, Integer.parseInt(dia), false, entrada, tag);
            }
            else if ("MAIO".equals(table)){
                ano.novaTransacao(5, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(5, Integer.parseInt(dia), false, entrada, tag);
            }
            else if ("JUNHO".equals(table)){
                ano.novaTransacao(6, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(6, Integer.parseInt(dia), false, entrada, tag);
            }
            else if ("JULHO".equals(table)){
                ano.novaTransacao(7, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(7, Integer.parseInt(dia), false, entrada, tag);
            }
            else if ("AGOSTO".equals(table)){
                ano.novaTransacao(8, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(8, Integer.parseInt(dia), false, entrada, tag);
            }
            else if ("SETEMBRO".equals(table)){
                ano.novaTransacao(9, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(9, Integer.parseInt(dia), false, entrada, tag);
            }
            else if ("OUTUBRO".equals(table)){
                ano.novaTransacao(10, Integer.parseInt(dia),  true, saida, tag);
                ano.novaTransacao(10, Integer.parseInt(dia),  false, entrada, tag);
            }
            else if ("NOVEMBRO".equals(table)){
                ano.novaTransacao(11, Integer.parseInt(dia),  true, saida, tag);
                ano.novaTransacao(11, Integer.parseInt(dia),  false, entrada, tag);
            }
            else if ("DEZEMBRO".equals(table)){
                ano.novaTransacao(12, Integer.parseInt(dia), true, saida, tag);
                ano.novaTransacao(12, Integer.parseInt(dia),  false, entrada, tag);
            }

            str += dia + ", " + saida + ", " + entrada + ", " + tag + newline;

        //Animal animal = new Animal(nome, especie, idade, peso);
        }
        
        
        comando.close();
        conexao.close();
    }
 
}
