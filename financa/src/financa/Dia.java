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
public class Dia  {
    
    protected float entrada;
    protected float saida;
    ArrayList<Transacao> transacoes = new ArrayList();
    
    public float getEntrada() {
        atualizaEntrada();
        return entrada;
    }
    
    private void atualizaEntrada(){
        for (int i = 0; i < transacoes.size(); i++) {
            if("Saída".equals(transacoes.get(i).getTipo())){
                setEntrada(transacoes.get(i).getValor());
            }
        }
    }

    public void novaTransacao(boolean tipo, float valor, String descricao){
        Transacao transacao = new Transacao(valor, descricao, tipo);
        transacoes.add(transacao);
    }
    
    public float getSaida() {
        atualizaSaida();
        return saida;
    }
    
    private void atualizaSaida(){
        for (int i = 0; i < transacoes.size(); i++) {
            if("Saída".equals(transacoes.get(i).getTipo())){
                setSaida(transacoes.get(i).getValor());
            }
        }
    }
    
    public void listDia(int dia) {
        if(this.transacoes.size()!=0)
            System.out.print("      Dia "+ dia + ": ");
        for (int i = 0; i < transacoes.size(); i++) {
            if(i==0)
                System.out.print(transacoes.get(i).getTipo() + " de ");  
            else
                System.out.print("             " + transacoes.get(i).getTipo() + " de ");  
            System.out.print("R$"+transacoes.get(i).getValor()+ " ");
            System.out.println(transacoes.get(i).getDescricao());
        }  
    }
    
    /**
     * @param valor the value that has been received
     */
    public void setEntrada(float valor) {
        entrada += valor;
    }

    /**
     * @param valor the value that has been paid
     */
    public void setSaida(float valor) {
        saida += valor;
    }
    
    public Dia() {
        entrada = 0;
        saida = 0;
    }
 
}
