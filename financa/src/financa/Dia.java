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
public class Dia  {
    
    protected float entrada;
    protected float saida;
    ArrayList<Transacao> transacoes = new ArrayList();
    
    /**
     * 
     * @return 
     */
    public float getEntrada() {
        atualizaEntrada();
        return entrada;
    }
    
    /**
     * 
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
     * 
     * @param tipo
     * @param valor
     * @param tag 
     */
    public void novaTransacao(boolean tipo, float valor, String tag){
        Transacao transacao = new Transacao(valor, tag, tipo);
        transacoes.add(transacao);
    }
    
    /**
     * 
     * @return 
     */
    public float getSaida() {
        atualizaSaida();
        return saida;
    }
    
    /**
     * 
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
     * 
     * @param dia 
     */
    public void listDia(int dia) {
        if(this.transacoes.size()!=0)
            System.out.print("      Dia "+ dia + ": ");
        for (int i = 0; i < transacoes.size(); i++) {
            if(i==0)
                System.out.print(transacoes.get(i).getTipo() + " de ");  
            else
                System.out.print("             " + transacoes.get(i).getTipo() + " de ");  
            System.out.print("R$"+transacoes.get(i).getValor()+ " ");
            System.out.println("<"+transacoes.get(i).getTag()+">");
        }  
    }
    
    /**
     * @param valor the value that has been received
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
     * @param valor the value that has been paid
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
     * 
     */
    public Dia() {
        entrada = 0;
        saida = 0;
    }
 
}
