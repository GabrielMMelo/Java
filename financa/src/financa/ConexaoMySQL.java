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
 
    /**
     * Constante para mau retorno de status de conexão
     */
    public static String status = "Não conectou...";

    /**
     * Constante padrão para quebra de linha
     */
    public static String newline = System.getProperty("line.separator");
 
//Método Construtor da Classe//

    /**
     * Construtor vazio
     */
 
    public ConexaoMySQL() {
    }

    /**
     * Função que carrega o driver JBDC do mysql e inicia uma conexão
     * @return Um objeto Connection
     */
    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;          //atributo do tipo Connection
        try {
            String driverName = "com.mysql.jdbc.Driver";                        
            Class.forName(driverName);
            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase ="financa";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD      
            String password = "vasco2202";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) 
                status = ("STATUS--->Conectado com sucesso!");
            else 
                status = ("STATUS--->Não foi possivel realizar conexão");
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) { //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
    
    /**
     * Método que retorna o status da conexão atual
     * @return Uma mensagem referente ao status atual
     */
    public static String statusConection() {
        return status;
    }

    /**
     *  Método que encerra uma conexão
     * @return True, caso obtenha-se êxito ao fechar a conexão. False, caso contrário.
     */
    public static boolean FecharConexao() {
        try {
            ConexaoMySQL.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        } 
    }

    /**
     * Método que encerra e cria outra conexão
     * @return Um objeto Connection
     */ 
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoMySQL.getConexaoMySQL();
    }
    
    /**
     * Atualiza um dado em uma tabela do Banco de Dados atual
     * @param table Tabela a ser atualizada
     * @param dia Chave primária. Dia a ser atualizado
     * @param entrada Valor da atualização na coluna de entrada
     * @param saida Valor da atualização na coluna de saida
     * @param tag Valor da atualização na coluna de TAG
     * @throws SQLException Exceções SQL
     */
    public void insert(String table, int dia, float entrada, float saida, String tag) throws SQLException{
        Connection conexao = this.getConexaoMySQL(); 
        Statement comando = conexao.createStatement();
        //comando.executeUpdate("INSERT INTO " + table + " (dia, saida, entrada, tagId) VALUES (" + dia + ", "+ saida + ", " + entrada + ", " + tag + ");");    
        comando.executeUpdate("UPDATE " + table + " SET  saida = saida + " +saida + ", entrada = entrada + " + entrada + ", tag = CONCAT(tag,'- ', '" + tag + "') WHERE dia = "+ dia + ";");
        comando.close();
        conexao.close();
    }
    
    
    /**
     * Atualiza um dado em uma tabela do Banco de Dados atual
     * @deprecated Não mais existe a tabela TAG 
     * @param table Tabela a ser atualizada
     * @param idTag Valor da identificação da tag
     * @param descricao Descrição detalhada da TAG
     * @throws SQLException Exceções SQL
     */
    public void insert(String table, String idTag, String descricao) throws SQLException{
        Connection conexao = this.getConexaoMySQL(); 
        Statement comando = conexao.createStatement();
        comando.executeUpdate("INSERT INTO " + table + " (tagId, descricao) VALUES (" + idTag + ", " + descricao + ");");
        comando.close();
        conexao.close();
    }
    

    /**
     * Função que retorna uma String com os valores obtidos de um comando SELECT * FROM table
     * @param table Tabela desejada
     * @return String com o retorno do SELECT
     * @throws SQLException
     */ 
    public String select(String table) throws SQLException {
        Connection conexao = this.getConexaoMySQL(); 
        Statement comando = conexao.createStatement();
        ResultSet linhas = comando.executeQuery ("SELECT * FROM " + table + ";" );
        String str = "";
        while (linhas.next()) {
            String dia = linhas.getString("DIA");
            float saida = (float) linhas.getDouble("SAIDA");
            float entrada = (float) linhas.getDouble("ENTRADA");
            String tag = linhas.getString("tag");
            str += dia + ", " + saida + ", " + entrada + ", " + tag + newline;
        }
        comando.close();
        conexao.close();
        return str;
    }
            
    /**
     * Método que lê todos os dados existente em uma tabela e os inserem na estrutura do programa atual
     * @param ano Objeto da classe Ano referente ao ano em questão
     * @param table Tabela desejada
     * @throws SQLException
     */
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
        }              
        comando.close();
        conexao.close();
    }
}
