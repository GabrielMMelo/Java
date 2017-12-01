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
public class Financa {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Hoje hoje = new Hoje();
        int data[] = hoje.getHoje();
        Ano ano = new Ano(String.valueOf(data[2]));
        /*ano.novaTransacao(2, 12, true, 200, "Compra de coxinha do Saulo");
        ano.novaTransacao(11, 20, true, 200, "Compra de Tênis");
        ano.novaTransacao(2, 20, false, 200, "Sorteio de dez real");
        ano.novaTransacao(3, 17, false, 200, "Mesada da Mãe");
        ano.novaTransacao(8, 25, true, 200, "Mais coxinha do Saulo");
        ano.novaTransacao(1, 6, true, 200, "Gasolina");
        ano.novaTransacao(1, 6, true, 200, "Gasolina2");
        ano.novaTransacao(true, 200, "Drogas");        
        ano.listAno();
        
        System.out.print("R$"+ano.getEntrada(1,6));*/
        Interface menu = new Interface(ano);
        menu.menu();
        
    }

}
