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
public class Mes extends Dia {

    //private Dia dia[];
    ArrayList<Dia> dias = new ArrayList();
    //protected float entrada1;
    //protected float saida1;
    public Mes(){
        
    }
    public Mes(int mes) {
        switch(mes){
            case 2: 
                for (int i = 0; i < 28; i++) {
                    Dia dia = new Dia();
                    dias.add(dia);
                }
                
            break;

            case 4: case 6: case 9: case 11:
                for (int i = 0; i < 30; i++) {
                    Dia dia = new Dia();
                    dias.add(dia);
                }
            break;
            
            default:
                for (int i = 0; i < 31; i++) {
                    Dia dia = new Dia();
                    dias.add(dia);
                }
            break;
        }
    } 

    @Override
    public float getEntrada() {
        int entradaTotal = 0;
        for (int i = 0; i < dias.size(); i++) {
            entradaTotal +=  dias.get(i).entrada;
        }
        
        return entradaTotal;
    }
   
    @Override
    public float getSaida() {
        int saidaTotal = 0;
        for (int i = 0; i < dias.size(); i++) {
            saidaTotal +=  dias.get(i).saida;
        }
        return saidaTotal;
    }
    
    protected void setEntrada(int dia, float valor){
        dias.get(dia-1).setEntrada(valor);
    }
    
    protected void setSaida(int dia, float valor){
        dias.get(dia-1).setSaida(valor);
    }
}
