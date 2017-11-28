/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

/**
 *
 * @author melo
 */
public class Financa {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Hoje hoje = new Hoje();
        int data[] = hoje.getHoje();
        System.out.println(data[2]);
        int horario[] = hoje.getAgora();
        System.out.println(horario[0]);
        Ano ano = new Ano();
        //ano.setEntrada(mesAtual, diaAtual, 200);
        System.out.println("Antes do deposito: " + ano.getEntrada());
        Mes mes = new Mes(2);
        ano.setEntrada(2,12,200);
        ano.setEntrada(4,12,200);
        System.out.println("Depois do deposito: " + ano.getEntrada());
        System.out.println("Janeiro: " + ano.getEntrada(1));
        System.out.println("Fevereiro: " + ano.getEntrada(2));
        System.out.println("Março: " + ano.getEntrada(3));
        System.out.println("Abril: " + ano.getEntrada(4));
        System.out.println("Maio: " + ano.getEntrada(5));
        System.out.println("Junho: " + ano.getEntrada(6));
        System.out.println("Julho: " + ano.getEntrada(7));
        System.out.println("Agosto: " + ano.getEntrada(8));
        System.out.println("Setembro: " + ano.getEntrada(9));
        System.out.println("Outubro: " + ano.getEntrada(10));
        System.out.println("Novembro: " + ano.getEntrada(11));
        System.out.println("Dezembro: " + ano.getEntrada(12));
        //ano.meses(1).getEntrada();
        System.out.println("Dia 12 de Fevereiro: " + ano.getEntrada(2,12));
        System.out.println("Dia 22 de Fevereiro: " + ano.getEntrada(2,22));
       // float ent = ano.getEntrada();
        
    }

}
