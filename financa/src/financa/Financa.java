/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author melo
 */
public class Financa {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int data[] = getData();
        System.out.println(data[2]);
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
        System.out.println("Dezemrbo: " + ano.getEntrada(12));
        
       // float ent = ano.getEntrada();
        
    }
    public static int[] getData(){
        Date dataAtual= new Date();
        String dataStr;
        dataStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(dataAtual);
        String Data[] =  dataStr.split("/");       
        return new int[] {Integer.parseInt(Data[0]), Integer.parseInt(Data[1]), Integer.parseInt(Data[2])};
    }
}
