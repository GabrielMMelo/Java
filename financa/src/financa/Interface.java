/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.util.Scanner;

/**
 *
 * @author GabrielMMelo
 */
public class Interface {
    Scanner sc = new Scanner(System.in); 
    Ano ano;
    /**
     *
     * @param ano
     */
    
    /**
     * 
     * @param ano 
     */
    public Interface(Ano ano){
        this.ano = ano;
    }
    
    /**
     * 
     */
    public void menu(){
        System.out.println("          ****************************************");
        System.out.println("          $$$$$ CONTROLE PESSOAL DE FINANÇAS $$$$$");
        System.out.println("          ****************************************");
        System.out.println("1) Nova Transação");
        System.out.println("2) Buscar Transação");
        System.out.println("3) Listar Transações");
        System.out.println("4) Sobre");
        System.out.println("0) Sair");
        int chave = sc.nextInt();
        while(chave!=0){
            switch(chave){
                case 1:
                    subMenu(1);
                break;
                
                case 2:
                    subMenu(2);
                break;
                
                case 3:
                    ano.listAno();
                    Financa financa = new Financa();
                    System.out.println("");
                    System.out.print("Saldo anual: ");
                    financa.getSaldo(ano);
                    System.out.println("");
                    System.out.println("");
                    
                break;
                
                case 4:
                    sobre();
                break;
                
                case 0:
                break;
            }
        System.out.println("          ****************************************");
        System.out.println("          $$$$$ CONTROLE PESSOAL DE FINANÇAS $$$$$");
        System.out.println("          ****************************************");
        System.out.println("1) Nova Transação");
        System.out.println("2) Buscar Transação");
        System.out.println("3) Listar Transações");
        System.out.println("4) Sobre");
        System.out.println("0) Sair");
        chave = sc.nextInt();
        
       }
    }
    
    
    /**
     * 
     * @param operacao 
     */
    private void subMenu(int operacao){
        switch(operacao){
            case 1:
                
                System.out.println("          $$$$$ NOVA TRANSAÇÃO $$$$$");
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
                            System.out.println("        Insira o valor da sua transação (R$):");
                            float valor = sc.nextFloat();
                            clearScreen();
                            System.out.println("        Insira uma <TAG> para sua transação:");
                            String tag = "";
                            tag += sc.next();
                            
                            ano.novaTransacao(tipo,valor,tag);
                        break;
                        
                        case 2:
                            System.out.println("        Insira a data da transação no formato dd/mm:");
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
                            System.out.println("        Insira o valor da sua transação (R$):");
                            float valor2 = sc.nextFloat();
                            clearScreen();
                            System.out.println("        Insira uma <TAG> para sua transação:");
                            String tag2 = sc.next();
                            
                            ano.novaTransacao(Integer.parseInt(Data[1]),Integer.parseInt(Data[0]),tipo2,valor2,tag2);
                        break;
                    }
                    System.out.println("          $$$$$ NOVA TRANSAÇÃO $$$$$");
                    System.out.println("1) Nova Transação de hoje");
                    System.out.println("2) Nova Transação Futura/Passada");
                    System.out.println("0) Voltar");
                    chave = sc.nextInt();
                }
            break;
            
            case 2: // por mês ou por dia
                System.out.println("        $$$$$ BUSCAR TRANSAÇÃO $$$$$");
                System.out.println("1) Buscar transações de um MÊS");
                System.out.println("2) Buscar transações de um DIA");
                System.out.println("0) Voltar");
                
                int chave2 = sc.nextInt();
                while(chave2 != 0) {
                    switch(chave2){
                        case 1:
                            System.out.println("        Insira o mês a ser buscado:");
                            int mes = sc.nextInt();
                            clearScreen();
                            float saida2 = ano.getSaida(mes);
                            float entrada2 = ano.getEntrada(mes);
                            System.out.println("Saída: R$"+saida2);
                            System.out.println("Entrada: R$"+entrada2);
                            float total = entrada2 - saida2;
                            System.out.println("Saldo total: R$" + total);
                            chave2 = 0;
                        break;
                        
                        case 2:
                            System.out.println("        Insira a data da transação no formato dd/mm:");
                            String str = sc.next();
                            String Data[] =  str.split("/");       
                            clearScreen();
                            float saida = ano.getSaida(Integer.parseInt(Data[1]),Integer.parseInt(Data[0]));
                            float entrada = ano.getEntrada(Integer.parseInt(Data[1]),Integer.parseInt(Data[0]));
                            System.out.println("Saída: R$"+ saida);
                            System.out.println("Entrada: R$"+entrada);
                            float total2 = entrada - saida;
                            System.out.println("Saldo total: R$" + total2);
                            chave2 = 0;
                        break;
                    }
                }
            break;

        }
        
    }
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    /**
     * 
     */
    public void sobre(){
        clearScreen();
        System.out.println("        $$$$$ SOBRE $$$$$");
        System.out.println("        Este software foi desenvolvido por Gabriel Marques de Melo para a disciplina Praticas de Programação Orientada a");
        System.out.println("        Objetos, disciplina obrigatoria da grade de Ciencia da Computaçao-Bacharelado da Universidade Federal de Lavras");
        System.out.println("");
        System.out.println("Codigo-fonte disponivel no repositorio:  github.com/GabrielMMelo/java");
        System.out.println("");
        
    }
}
