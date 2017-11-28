/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

/**
 *
 * @author melo
 */
public class Dia  {
    
    protected float entrada;

    protected float saida;
    
    public float getEntrada() {
        return entrada;
    }

    public float getSaida() {
        return saida;
    }
    
    public void setEntrada(float valor) {
        entrada += valor;
    }

    public void setSaida(float valor) {
        saida += valor;
    }
    
    public Dia() {
        entrada = 0;
        saida = 0;
    }
 
}
