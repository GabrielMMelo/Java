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
        System.out.print(1);
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
            entradaTotal +=  meses.get(i).entrada;
        }
        return entradaTotal;
    }

    @Override
    public float getSaida() {
        int saidaTotal = 0;
        for (int i = 0; i < 12; i++) {
            saidaTotal +=  meses.get(i).saida;
        }
        return saidaTotal;
    }
    
    public void setEntrada(int mes, int dia, float valor){
        this.meses.get(mes).setEntrada(dia, valor);
    }
}
