/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.util.ArrayList;

/**
 *
 * @author GabrielMMelo
 */
public class Mes extends Dia {

    //private Dia dia[];
    ArrayList<Dia> dias = new ArrayList();
    //protected float entrada1;
    //protected float saida1;
    public Mes(){
        
    }
    /**
     * 
     * @param mes 
     */
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
    
    /**
     * 
     * @return 
     */
    @Override
    public float getEntrada() {
        int entradaTotal = 0;
        for (int i = 0; i < dias.size(); i++) {
            entradaTotal +=  dias.get(i).getEntrada();
        }
        
        return entradaTotal;
    }
   
    /**
     * 
     * @return 
     */
    @Override
    public float getSaida() {
        int saidaTotal = 0;
        for (int i = 0; i < dias.size(); i++) {
            saidaTotal +=  dias.get(i).getSaida();
        }
        return saidaTotal;
    }
    
    /**
     * 
     * @param dia
     * @param tipo
     * @param valor
     * @param tag 
     */
    public void novaTransacao(int dia,boolean tipo, float valor, String tag) {
         this.dias.get(dia-1).novaTransacao(tipo, valor, tag);
    }
    
    /**
     * 
     */
     public void listMes() {
      for (int i = 0; i < dias.size(); i++) {
          dias.get(i).listDia(i+1);
        }  
    }
    
}
