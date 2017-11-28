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
public class Ano extends Mes {
    private Mes mes[];
    protected float entrada;
    protected float saida;
    public String ano;

    public Ano(String ano){
         mes = new Mes[12];
         this.ano = ano;
    }
    
    @Override
    public float getEntrada() {
        entrada = 0;
        for (int i = 0; i < 31; i++) {
            entrada +=  mes[i].entrada;
        }
        return entrada;
    }

    @Override
    public float getSaida() {
        saida = 0;
        for (int i = 0; i < 31; i++) {
            saida +=  mes[i].entrada;
        }
        return saida;
    }
    
    public void setEntrada(int mes, int dia, float valor){
        this.mes[mes].setEntrada(dia, valor);
    }
    
}
