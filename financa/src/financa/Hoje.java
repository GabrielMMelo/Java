/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.text.DateFormat;
import java.util.Date;

/**
 * Classe responsável pela manipulação da data e hora atual 
 * @author GabrielMMelo
 */
public class Hoje {
    /**
     * Metodo que retorna a data atual em um vetor de inteiros
     * @return Vetor que contém a data atual no seguinte formato dd/mm/aa. A primeira posição do vetor recebe o dia, a segunda o mes e a terceira o ano.
     */
    public int[] getHoje(){
        Date dataAtual= new Date();
        String dataStr;
        dataStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(dataAtual);
        String Data[] =  dataStr.split("/");       
        return new int[] {Integer.parseInt(Data[0]), Integer.parseInt(Data[1]), Integer.parseInt(Data[2])};
    }
    
    /**
     * Metodo que retorna a hora atual em um vetor de inteiros
     * @return Vetor que contém a hora atual no seguinte formato hh:mm:ss. A primeira posição do vetor recebe aa horas, a segunda os minutos e a terceira os segundos.
     */
    public int[] getAgora(){
        Date dataAtual= new Date();
        String dataStr;
        dataStr = java.text.DateFormat.getTimeInstance(DateFormat.MEDIUM).format(dataAtual);
        String Data[] =  dataStr.split(":");       
        return new int[] {Integer.parseInt(Data[0]), Integer.parseInt(Data[1]), Integer.parseInt(Data[2])};
    }
    
    /**
     * Metodo que retorna a hora atual em uma string
     * @return String que contém a hora atual no seguinte formato hh:mm:ss.
     */
    public String getStrAgora(){
        Date dataAtual= new Date();
        String dataStr;
        dataStr = java.text.DateFormat.getTimeInstance(DateFormat.MEDIUM).format(dataAtual);
        return dataStr;
    }
}
