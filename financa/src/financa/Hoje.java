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
public class Hoje {
    public int[] getHoje(){
        Date dataAtual= new Date();
        String dataStr;
        dataStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(dataAtual);
        String Data[] =  dataStr.split("/");       
        return new int[] {Integer.parseInt(Data[0]), Integer.parseInt(Data[1]), Integer.parseInt(Data[2])};
    }
    
    public int[] getAgora(){
        Date dataAtual= new Date();
        String dataStr;
        dataStr = java.text.DateFormat.getTimeInstance(DateFormat.MEDIUM).format(dataAtual);
        String Data[] =  dataStr.split(":");       
        return new int[] {Integer.parseInt(Data[0]), Integer.parseInt(Data[1]), Integer.parseInt(Data[2])};
    }
    
    public String getStrAgora(){
        Date dataAtual= new Date();
        String dataStr;
        dataStr = java.text.DateFormat.getTimeInstance(DateFormat.MEDIUM).format(dataAtual);
        return dataStr;
    }
}
