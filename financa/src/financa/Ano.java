/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.util.ArrayList;

/**
 *
 * @author melo
 */
public class Ano extends Mes {
    //private Mes mes[];
    ArrayList<Mes> meses = new ArrayList();
    //protected float entrada2;
    //protected float saida2;
    public String ano;

    public Ano(){
        for (int i = 1; i <= 12; i++) {
            Mes mes = new Mes(i);
            meses.add(mes);
        }
         //this.ano = ano;
    }
    
    @Override
    public float getEntrada() {
        int entradaTotal = 0;
        for (int i = 0; i < 12; i++) {
            entradaTotal +=  meses.get(i).getEntrada();
        }
        return entradaTotal;
    }
    
    public float getEntrada(int mes) {
        return  meses.get(mes-1).getEntrada();
    }
    
    public float getEntrada(int mes, int dia) {
        return  meses.get(mes-1).dias.get(dia-1).getEntrada();
    }
    
    @Override
    public float getSaida() {
        int saidaTotal = 0;
        for (int i = 0; i < 12; i++) {
            saidaTotal +=  meses.get(i).getSaida();
        }
        return saidaTotal;
    }
    
     public float getSaida(int mes) {
        return  meses.get(mes-1).getSaida();
    }
    
    public float getSaida(int mes, int dia) {
        return  meses.get(mes-1).dias.get(dia-1).getSaida();
    }
    
    public void setEntrada(int mes, int dia, float valor){
        meses.get(mes-1).setEntrada(dia, valor);
    }
    
    public void setSaida(int mes, int dia, float valor){
        meses.get(mes-1).setSaida(dia, valor);
    }
}
