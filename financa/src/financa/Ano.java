/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.util.ArrayList;

/**
 *  Classe filha de Mes que referencia a um determinado ano de controle financeiro do usuário. É a classe usada na main() para a manipulação dos dados financeiros
 * @author GabrielMMelo
 * @see Mes
 */
public class Ano extends Mes {
    ArrayList<Mes> meses = new ArrayList();
    public static String newline = System.getProperty("line.separator");
    public String ano;
    
    /**
     * 
     * @param ano String que representa o ano (Ex:"2017")
     */
    public Ano(String ano){
        for (int i = 1; i <= 12; i++) {
            Mes mes = new Mes(i);
            meses.add(mes);
        }
        this.ano = ano;
    }
    
    /**
     * Método que informa a entrada total de um ano
     * @return Entrada Total
     */
    @Override
    public float getEntrada() {
        int entradaTotal = 0;
        for (int i = 0; i < 12; i++) {
            entradaTotal +=  meses.get(i).getEntrada();
        }
        return entradaTotal;
    }
    
    /**
     * Sobrecarga de método.
     * @param mes Mês da transação 
     * @return A entrada total de um determinado mês quisto
     * @see #getEntrada() 
     */
    public float getEntrada(int mes) {
        return  meses.get(mes-1).getEntrada();
    }
    
    /**
     * 
     * Sobrecarga de método.
     * @param mes Mês da transação 
     * @param dia Dia da transação
     * @return A entrada total de um determinado dia quisto
     * @see #getEntrada() 
     */
    public float getEntrada(int mes, int dia) {
        return  meses.get(mes-1).dias.get(dia-1).getEntrada();
    }
    
    /**
     * Método que informa a saída total de um ano 
     * @return Saída total
     */
    @Override
    public float getSaida() {
        int saidaTotal = 0;
        for (int i = 0; i < 12; i++) {
            saidaTotal +=  meses.get(i).getSaida();
        }
        return saidaTotal;
    }
    
    /**
     * Sobrecarga de método
     * @param mes Mês da transação 
     * @return A saída total de um determinado mês quisto
     */
     public float getSaida(int mes) {
        return  meses.get(mes-1).getSaida();
    }
    
    /**
     * Sobrecarga de método.
     * @param mes Mês da transação 
     * @param dia Dia da transação
     * @return A saída total de um determinado dia quisto
     */
    public float getSaida(int mes, int dia) {
        return  meses.get(mes-1).dias.get(dia-1).getSaida();
    }
    
    /**
     * Insere nova transação usando uma data fornecida
     * @param mes Mês da transação 
     * @param dia Dia da transação
     * @param tipo Tipo da transação ("Saida" ou "Entrada")
     * @param valor Quantia (em R$) referente à transação
     * @param tag Tag que identifica a natureza da transação
     */
    public void novaTransacao(int mes, int dia,boolean tipo, float valor, String tag) {
        this.meses.get(mes-1).novaTransacao(dia,tipo, valor, tag);
    }
    
    /**
     *  Insere nova transação usando dia de hoje como data
     * @param tipo Tipo da transação ("Saida" ou "Entrada")
     * @param valor Quantia (em R$) referente à transação
     * @param tag Tag que identifica a natureza da transação
     */
    @Override
    public void novaTransacao(boolean tipo, float valor, String tag) {
        Hoje hoje  = new Hoje();
        int data[] = hoje.getHoje();
        this.meses.get(data[1]-1).novaTransacao(data[0],tipo, valor, tag);
    }
     
    /**
     * Imprime todas transações do ano
     */
    public String listAno() {
        String str;
        //System.out.println(ano+":");
        str = ano+":";
      for (int i = 0; i < meses.size(); i++) {
          //System.out.println(converteMes(i));
          str+=newline;
          str+=newline;
          str+=converteMes(i);
          str+=newline;
          str+=(meses.get(i).listMes()); 
      }
      str+=("\r");
      return str;
    }
    
    /**
     * Converte um número a uma String com o nome do mês correspondente pela fórmula: mes = Número do mês - 1
     * @param mes Número referente ao mês - 1 (Ex: mes = 1 -> retorna "Fevereiro")
     * @return Nome do mês
     */
    protected String converteMes(int mes) {
        String conversao="";
        switch(mes) {
              case 0:
                  conversao = "JANEIRO"; 
                  break;
              case 1:
                  conversao = "FEVEREIRO";
                  break;
              case 2:
                  conversao = "MARCO";
                  break;
              case 3:
                  conversao = "ABRIL";
                  break;    
              case 4:
                  conversao = "MAIO";
                  break;
              case 5:
                  conversao = "JUNHO";
                  break;
              case 6:
                  conversao = "JULHO";
                  break;
              case 7:
                  conversao = "AGOSTO";
                  break;
              case 8:
                  conversao = "SETEMBRO";
                  break;
              case 9:
                  conversao = "OUTUBRO";
                  break;
              case 10:
                  conversao = "NOVEMBRO";
                  break;
              case 11:
                  conversao = "DEZEMBRO";
                  break;
        }
        return conversao;
   }
}
