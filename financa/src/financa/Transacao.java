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
public class Transacao {
    private String descricao;
    private float valor;
    private String hora;
    private String tipo;
    
    
    public Transacao(float valor, String descricao, boolean tipo){
        if (tipo)
            this.tipo = "Saída";
        else
            this.tipo = "Entrada";
        Hoje hoje = new Hoje();
        this.hora = hoje.getStrAgora();
        this.valor = valor;
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public float getValor(){
        return valor;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getHora(){
        return hora;
    }
}
