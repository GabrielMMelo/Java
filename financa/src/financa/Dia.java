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
        return entrada;
    }

    public float getSaida() {
        return saida;
    }
    
    public void listEntrada() {
        
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
