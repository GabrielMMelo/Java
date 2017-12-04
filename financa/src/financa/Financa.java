/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.util.ArrayList;

/**
 * Função principal de validação.
 * @author GabrielMMelo
 */
public class Financa {
    
    /**
     * @param args Os argumentos da linha de comando
     */
    public static void main(String[] args) {
        ArrayList <Ano> ano = new ArrayList();
        Hoje hoje = new Hoje();
        int data[] = hoje.getHoje();
        Ano anoAux = new Ano(String.valueOf(data[2]));
        ano.add(anoAux);
        Interface Menu = new Interface(anoAux);
        Menu.menu(); 
    }
    
    /**
     *  Método POLIMÓRFICO que informa o saldo (Entrada - Saida), em R$, de um dia, mês ou ano informado.
     * @param dia Dia, mês ou ano a ser consultado
     */
    public static void getSaldo(Dia dia){
        float entrada = dia.getEntrada();
        float saida = dia.getSaida();
        float total = entrada - saida;
        if (total <0) {
            total *= -1;
            System.out.print("-R$"+total);      
        }
        else
            System.out.print("R$"+total);  
    }
}
