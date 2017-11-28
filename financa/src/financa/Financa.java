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
        Date dataAtual= new Date();
        String dataStr;
        dataStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(dataAtual);
        String Data[] =  dataStr.split("/");
        int diaAtual = Integer.parseInt(Data[0]);
        int mesAtual = Integer.parseInt(Data[1]);
        int anoAtual = Integer.parseInt(Data[2]);
        Ano ano = new Ano(Data[2]);
        System.out.println(anoAtual);
        //System.out.println(ano.getEntrada());
        Mes mes = new Mes();
        
        mes.getEntrada();
        
    }
    
}
