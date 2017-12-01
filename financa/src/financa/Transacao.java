/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

/**
 *
 * @author GabrielMMelo
 */
public class Transacao {
    private String tag;
    private float valor;
    private String hora;
    private String tipo;
    
    /**
     * 
     * @param valor Quantia (em R$) referente à transação
     * @param tag Tag <> que identifica a natureza da transação
     * @param tipo Tipo da transação ("Saida" ou "Entrada")
     */
    public Transacao(float valor, String tag, boolean tipo){
        if (tipo)
            this.tipo = "Saída";
        else
            this.tipo = "Entrada";
        Hoje hoje = new Hoje();
        this.hora = hoje.getStrAgora();
        this.valor = valor;
        this.tag = tag;
    }
    
    /**
     * 
     * @return A Tag da transação
     */
    public String getTag(){
        return tag;
    }
    
    /**
     * 
     * @return O valor (em R$) da transação
     */
    public float getValor(){
        return valor;
    }
    
    /**
     * 
     * @return O tipo da transação ("Saida" ou "Entrada")
     */
    public String getTipo(){
        return tipo;
    }
    
    /**
     * 
     * @return (not used) A hora de efetuação da transação
     */
    public String getHora(){
        return hora;
    }
}
