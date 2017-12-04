/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.util.ArrayList;

/**
 * Classe filha de Dia e pai de Ano. Representa um mês de um ano.
 * @author GabrielMMelo
 * @see Dia
 * @see Ano
 */
public class Mes extends Dia {
    ArrayList<Dia> dias = new ArrayList();
    public Mes(){
        
    }
    /**
     * Construtor que cria uma lista com os n dias correspondentes de cada mês. (Ex: Janeiro possui 31 dias, Setembro possui 30 dias) 
     * @param mes Número referente a um mês de um ano. (Ex: 1 = Janeiro, 2 = Fevereiro, ..., 12 = Dezembro) 
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
     * Método que informa a entrada total deste mês
     * @return Entrada Total
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
     * Método que informa a saída total deste mês
     * @return Saída total
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
     * Cria uma nova transação em um determinado dia deste mês
     * @param dia Dia da transação
     * @param tipo Tipo da transação
     * @param valor Valor da transação
     * @param tag Tag que identifica a transação
     */
    public void novaTransacao(int dia,boolean tipo, float valor, String tag) {
         this.dias.get(dia-1).novaTransacao(tipo, valor, tag);
    }
    
    /**
     * Método que informa todas as transações de um mês
     */
     public void listMes() {
      for (int i = 0; i < dias.size(); i++) {
          dias.get(i).listDia(i+1);
        }  
    }
    
}
