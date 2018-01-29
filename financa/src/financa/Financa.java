/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.sql.SQLException;

/**
 * Função principal de validação.
 * @author GabrielMMelo
 */
public class Financa {
    
    /**
     * @param args Os argumentos da linha de comando
     * @throws SQLException Exceções SQL
     */
    public static void main(String[] args) throws SQLException {
        Interface Menu = new Interface();
    }
    
    /**
     *  Método POLIMÓRFICO que informa o saldo (Entrada - Saida), em R$, de um dia, mês ou ano informado.
     * @param dia Dia, mês ou ano a ser consultado
     * @return Valor referente ao saldo total do ano
     */
    public static String getSaldo(Dia dia){
        float entrada = dia.getEntrada();
        float saida = dia.getSaida();
        float total = entrada - saida;
        String str;
        if (total <0) {
            total *= -1; 
            str = "-R$"+total;
        }
        else
            str = "R$"+total;
        return str;
    }
    
    
}
