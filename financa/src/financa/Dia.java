/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.util.ArrayList;

/**
 * Superclasse de Mes. Representa um dia de um mês
 * @author GabrielMMelo
 * @see Mes
 */
public class Dia  {
    /**
     * Entrada total deste dia
     */
    protected float entrada;
    /**
     * Saída total deste dia
     */
    protected float saida;
    ArrayList<Transacao> transacoes = new ArrayList();
    /**
     * Constante padrão para quebra de linha
     */
    public static String newline = System.getProperty("line.separator");
    
    /**
     *  Método que informa o total de entradas deste dia
     * @return Entrada total
     */
    public float getEntrada() {
        atualizaEntrada();
        return entrada;
    }
    
    /**
     * Método auxiliar para atualização do valor de entrada deste dia
     */
    private void atualizaEntrada(){
        setEntrada(-1);
        for (int i = 0; i < transacoes.size(); i++) {
            if("Entrada".equals(transacoes.get(i).getTipo())){
                setEntrada(transacoes.get(i).getValor());
            }
        }
    }
    
    /**
     * Realiza a criação de uma nova transação deste dia
     * @param tipo Tipo da transação
     * @param valor Valor da transação
     * @param tag Tag que identifica a natureza da transação
     */
    public void novaTransacao(boolean tipo, float valor, String tag){
        Transacao transacao = new Transacao(valor, tag, tipo);
        transacoes.add(transacao);
    }
    
    /**
     *  Método que informa o total de saídas deste dia
     * @return Saída total
     */
    public float getSaida() {
        atualizaSaida();
        return saida;
    }
    
    /**
     * Método auxiliar para atualização do valor de saída deste dia
     */
    private void atualizaSaida(){
        setSaida(-1);
        for (int i = 0; i < transacoes.size(); i++) {
            if("Saída".equals(transacoes.get(i).getTipo())){
                setSaida(transacoes.get(i).getValor());
            }
        }
    }
    
    /**
     * Método que imprime as transações deste dia. Serão mostrados o dia, tipo, valor e tag da transação
     * @param dia Inteiro que servirá como uma identificação do dia, pois nem todos os dias terão necessáriamente uma transação.
     * @return Todo o conteúdo referente às transações de um dia
     */
    public String listDia(int dia) {
        String str = "";
        int init = 0;
        if (transacoes.get(0).getValor() == 0.0 && transacoes.size() == 2)
            return str;
        if(!this.transacoes.isEmpty()){
            System.out.print(transacoes.size());
            str += "      Dia "+ dia + ": ";
        }
         if (transacoes.get(0).getValor() == 0.0  &&  transacoes.get(1).getValor() != 0.0) {
             init = 1;
             for (int i = init; i < transacoes.size(); i++) {
            
                //System.out.print("             " + transacoes.get(i).getTipo() + " de ");  
                str+=transacoes.get(i).getTipo() + " de ";
                // System.out.print("R$"+transacoes.get(i).getValor()+ " ");
                str+="R$"+transacoes.get(i).getValor()+ " ";
               // System.out.println("<"+transacoes.get(i).getTag()+">");
                str+="<"+transacoes.get(i).getTag()+">";
                str+=newline;
            }
           // System.out.println(str);
            str+= "\r";
            return str;
         }
         else if (transacoes.get(0).getValor() != 0.0  &&  transacoes.get(1).getValor() == 0.0) {
             init = 2;
            str+=transacoes.get(0).getTipo() + " de ";
           // System.out.print("R$"+transacoes.get(i).getValor()+ " ");
            str+="R$"+transacoes.get(0).getValor()+ " ";
           // System.out.println("<"+transacoes.get(i).getTag()+">");
            str+="<"+transacoes.get(0).getTag()+">";
            for (int i = init; i < transacoes.size(); i++) {
         
                //System.out.print("             " + transacoes.get(i).getTipo() + " de ");  
                str+=transacoes.get(i).getTipo() + " de ";
                // System.out.print("R$"+transacoes.get(i).getValor()+ " ");
                 str+="R$"+transacoes.get(i).getValor()+ " ";
                // System.out.println("<"+transacoes.get(i).getTag()+">");
                 str+="<"+transacoes.get(i).getTag()+">";
                 str+=newline;
            }
           // System.out.println(str);
            str+= "\r";
            return str;
         }
         
         else {
            init = 0;
            for (int i = init; i < transacoes.size(); i++) {
         
                //System.out.print("             " + transacoes.get(i).getTipo() + " de ");  
                str+=transacoes.get(i).getTipo() + " de ";
                // System.out.print("R$"+transacoes.get(i).getValor()+ " ");
                 str+="R$"+transacoes.get(i).getValor()+ " ";
                // System.out.println("<"+transacoes.get(i).getTag()+">");
                 str+="<"+transacoes.get(i).getTag()+">";
                 str+=newline;
            }
           // System.out.println(str);
            str+= "\r";
            return str;
                
         }
    }
    
    /**
     * @param valor O valor da entrada (total) deste dia
     * @deprecated Substituída por novaTransação()
     * @see #novaTransacao(boolean, float, java.lang.String)
     */
    public void setEntrada(float valor) {
        if(valor == -1){
            entrada = 0;
        }
        else{
            entrada += valor;
        }
    }

    /**
     * @param valor O valor da saída (total) deste dia
     * @deprecated Substituída por novaTransação()
     * @see #novaTransacao(boolean, float, java.lang.String)
     */
    public void setSaida(float valor) {
        if(valor == -1){
            saida = 0;
        }
        else{
            saida += valor;
        }
    }
    
    /**
     * Constrói este dia com entradas e saídas inicialmente nulas
     */
    public Dia() {
        entrada = 0;
        saida = 0;
    }
 
}
