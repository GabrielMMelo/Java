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

    public Ano(String ano){
        for (int i = 1; i <= 12; i++) {
            Mes mes = new Mes(i);
            meses.add(mes);
        }
        this.ano = ano;
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
    
    
    public void novaTransacao(int mes, int dia,boolean tipo, float valor, String descricao) {
        this.meses.get(mes-1).novaTransacao(dia,tipo, valor, descricao);
    }
    
    /*
    *   Sobrescrita para nova transição usando dia de hoje
    *
    *  
    */
    
    @Override
    public void novaTransacao(boolean tipo, float valor, String descricao) {
        Hoje hoje  = new Hoje();
        int data[] = hoje.getHoje();
        this.meses.get(data[1]-1).novaTransacao(data[0],tipo, valor, descricao);
    }
     
     public void listAno() {
        System.out.println(ano+":");
      for (int i = 0; i < meses.size(); i++) {
          System.out.println(converteMes(i));
          meses.get(i).listMes(); 
      }
    }
     
    private String converteMes(int mes) {
        String conversao="";
        switch(mes) {
              case 0:
                  conversao = "  JANEIRO:"; 
                  break;
              case 1:
                  conversao = "  FEVEREIRO:";
                  break;
              case 2:
                  conversao = "  MARÇO:";
                  break;
              case 3:
                  conversao = "  ABRIL:";
                  break;    
              case 4:
                  conversao = "  MAIO:";
                  break;
              case 5:
                  conversao = "  JUNHO:";
                  break;
              case 6:
                  conversao = "  JULHO:";
                  break;
              case 7:
                  conversao = "  AGOSTO:";
                  break;
              case 8:
                  conversao = "  SETEMBRO:";
                  break;
              case 9:
                  conversao = "  OUTUBRO:";
                  break;
              case 10:
                  conversao = "  NOVEMBRO:";
                  break;
              case 11:
                  conversao = "  DEZEMBRO:";
                  break;
        }
        return conversao;
   }
}
