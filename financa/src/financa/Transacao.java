/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

/**
 * Classe onde ocorrem todas as manipulaçãoes de entradas e saídas do controle financeiro do usuário.
 * @author GabrielMMelo
 */
public class Transacao {
    /**
     * Palavra que identifica a natureza desta transação
     */
    private String tag;
    /**
     * Valor desta transação
     */
    private float valor;
    /**
     * (não usado) Hora em que esta transação ocorreu
     */
    private String hora;
    /**
     * Tipo desta transação
     */
    private String tipo;
    
    /**
     * 
     * @param valor Quantia (em R$) referente à transação
     * @param tag Tag que identifica a natureza da transação
     * @param tipo Tipo da transação (true = "Saida", false = "Entrada")
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
     * Informa a Tag desta transação
     * @return A Tag da transação
     */
    public String getTag(){
        return tag;
    }
    
    /**
     * Informa o valor desta transação
     * @return O valor (em R$) da transação
     */
    public float getValor(){
        return valor;
    }
    
    /**
     * Informa o tipo desta transação
     * @return O tipo da transação (true = "Saida", false = "Entrada")
     */
    public String getTipo(){
        return tipo;
    }
    
    /**
     * Informa a hora desta transação
     * @return (não usado) A hora de efetuação da transação
     */
    public String getHora(){
        return hora;
    }
}
