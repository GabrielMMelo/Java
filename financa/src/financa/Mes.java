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
public class Mes extends Dia {

    private Dia dia[];
    protected float entrada;
    protected float saida;
    
    public Mes() {
    //public Mes(String mes) {
    /*    switch(mes){
            case "Janeiro":
                dia = new Dia[31];
                break;
            case "Fevereiro":
                dia = new Dia[31];
                break;
            case "Marco":
                dia = new Dia[31];
                break;
            case "Abril":
                dia = new Dia[31];
                break;
            case "Maio":
                dia = new Dia[31];
                break;
            case "Junho":
                dia = new Dia[31];
                break;
            case "Julho":
                dia = new Dia[31];
                break;
            case "Agosto":
                dia = new Dia[31];
                break;
            case "Setembro":
                dia = new Dia[31];
                break;
            case "Outubro":
                dia = new Dia[31];
                break;
            case "Novembro":
                dia = new Dia[31];
                break;
            case "Dezembro":
                dia = new Dia[31];
                break;
        }
      */
    dia = new Dia[31];
    }

    @Override
    public float getEntrada() {
        entrada = 0;
        for (int i = 0; i < 31; i++) {
            entrada +=  dia[i].entrada;
            System.out.print(i);
        }
        
        return entrada;
    }

    @Override
    public float getSaida() {
        saida = 0;
        for (int i = 0; i < 31; i++) {
            saida +=  dia[i].saida;
        }
        return saida;
    }
    
    protected void setEntrada(int dia, float valor){
        this.dia[dia].setEntrada(valor);
    }
}
