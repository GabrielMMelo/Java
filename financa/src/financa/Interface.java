/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.util.Scanner;

/**
 *
 * @author melo
 */
public class Interface {
    Scanner sc =new Scanner(System.in); 
    Ano ano;
    /**
     *
     * @param chave
     */
    
    public Interface(Ano ano){
        this.ano = ano;
    }
    public void menu(){
        System.out.println("          CONTROLE PESSOAL DE FINANÇAS");
        System.out.println("1) Nova Transação");
        System.out.println("2) Alterar Transação");
        System.out.println("3) Buscar Transação");
        System.out.println("4) Listar Transações");
        System.out.println("0) Sair");
        int chave = sc.nextInt();
        while(chave!=0){
            switch(chave){
                case 1:
                    subMenu(1);
                break;
                
                case 2:
                    
                break;
                
                case 3:
                    
                break;
                
                case 4:
                    ano.listAno();
                break;
                
                case 0:
                break;
            }
        System.out.println("          CONTROLE PESSOAL DE FINANÇAS");
        System.out.println("1) Nova Transação");
        System.out.println("2) Alterar Transação");
        System.out.println("3) Buscar Transação");
        System.out.println("4) Listar Transações");
        System.out.println("0) Sair");
        chave = sc.nextInt();
        
       }
    }
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    private void subMenu(int operacao){
        switch(operacao){
            case 1:
                
                System.out.println("          NOVA TRANSAÇÃO");
                System.out.println("1) Nova Transação de hoje");
                System.out.println("2) Nova Transação Futura/Passada");
                System.out.println("0) Voltar");
                int chave = sc.nextInt();
                while(chave != 0) {                                                                
                    switch(chave) {
                        case 1:
                            System.out.println("        Insira o tipo da sua transação:");
                            System.out.println("1) Saída ");
                            System.out.println("2) Entrada ");
                            System.out.println("0) Voltar");
                            int chave2 = sc.nextInt();
                            boolean tipo = false;
                            while(chave2!=0){
                                switch(chave2){
                                    case 1:
                                        tipo = true;
                                        chave2 = 0;
                                    break;

                                    case 2:
                                        tipo = false;
                                        chave2 = 0;
                                    break; 
                                }
                            }
                            clearScreen();
                            System.out.println("        Insira o valor da sua transação:");
                            float valor = sc.nextFloat();
                            clearScreen();
                            System.out.println("        Insira uma TAG para sua transação:");
                            String descricao = "";
                            descricao += sc.next();
                            
                            ano.novaTransacao(tipo,valor,descricao);
                        break;
                        
                        case 2:
                            System.out.println("        Insira a data da transação no formato dd/mm/aaaa:");
                            String str = sc.next();
                            String Data[] =  str.split("/");       
                            clearScreen();
                            System.out.println("        Insira o tipo da sua transação:");
                            System.out.println("1) Saída ");
                            System.out.println("2) Entrada ");
                            System.out.println("0) Voltar");
                            int chave3 = sc.nextInt();
                            boolean tipo2 = false;
                            while(chave3 != 0){
                                switch(chave3){
                                    case 1:
                                        tipo2 = true;
                                        chave3 = 0;
                                    break;

                                    case 2:
                                        tipo2 = false;
                                        chave3 = 0;
                                    break; 
                                }
                            }
                            clearScreen();
                            System.out.println("        Insira o valor da sua transação:");
                            float valor2 = sc.nextFloat();
                            clearScreen();
                            System.out.println("        Insira uma TAG para sua transação:");
                            String descricao2 = sc.next();
                            
                            ano.novaTransacao(Integer.parseInt(Data[1]),Integer.parseInt(Data[0]),tipo2,valor2,descricao2);
                        break;
                    }
                    System.out.println("          NOVA TRANSAÇÃO");
                    System.out.println("1) Nova Transação de hoje");
                    System.out.println("2) Nova Transação Futura/Passada");
                    System.out.println("0) Voltar");
                    chave = sc.nextInt();
                }
            break;
            
            case 2:
            break;
            
            case 3:
            break;
            
            case 4:
            break;
            
            case 0:
            break;
        }
        
    }
}
