/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financa;

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Classe responsável pelo tratamento das entradas do usuário e a exibição das saídas que guiam a interação com o usuário.
 * @author GabrielMMelo
 */
public class Interface implements ActionListener {
    private ConexaoMySQL sql = new ConexaoMySQL();
    private Connection conexao;
    Hoje hoje = new Hoje();
    int data[] = hoje.getHoje();
    Ano ano  = new Ano(String.valueOf(data[2]));
    ArrayList <JButton> botao;
    private ArrayList <JFrame> janelas = new ArrayList();
    private ArrayList <String> texts = new ArrayList();
   // private ArrayList <JTextField> ta = new ArrayList();
    private ArrayList <JTextArea> ta = new ArrayList();
    private static final int janelas_size = 11;
    public static String newline = System.getProperty("line.separator");
    //private JTextArea ta = new JTextArea();
    
    /**
     * 
     * @param ano Ano em que as operações referem
     */
    public Interface() throws SQLException{
        ta.add(criaTextField("Data: (dd/mm)"));
        ta.add(criaTextField("Valor: (R$)"));
        ta.add(criaTextField("TAG"));
        ta.add(criaTextField("Data: (dd/mm)"));
        ta.add(criaTextField("Data: (mm)"));
        ta.add(criaTextField(""));
        ta.add(criaTextField(""));
        ta.add(criaTextField(""));
        
        
        for (int i = 1; i <= janelas_size; i++){
            janelas.add(criaJanela(i));
        }
        
        
        //sql.insert("FEVEREIRO", "22", "7000", "8000", "'3'");
        
        sql.select(ano,"JANEIRO");
        sql.select(ano,"FEVEREIRO");
        sql.select(ano,"MARCO");
        sql.select(ano,"ABRIL");
        sql.select(ano,"MAIO");
        sql.select(ano,"JUNHO");
        sql.select(ano,"JULHO");
        sql.select(ano,"AGOSTO");
        sql.select(ano,"SETEMBRO");
        sql.select(ano,"OUTUBRO");
        sql.select(ano,"NOVEMBRO");
        sql.select(ano,"DEZEMBRO");
       // Statement comando = conexao.createStatement();
      //  comando.executeUpdate("INSERT INTO TAG (tagId, descricao) VALUES (1, NULL);");
       // comando.executeUpdate("INSERT INTO JANEIRO (dia, saida, entrada,tagId) VALUES (1, 20.0, 10.0, 1);");
       // comando.close();
       // conexao.close();
       
        this.exibir(1);
    }
    
    public void exibir(int id) {
        janelas.get(id-1).setVisible(true);
    }
    
    public void esconder(int id) {
        janelas.get(id-1).setVisible(false);
    }
    
    private JTextArea criaTextField(String name){
        JTextArea t = new JTextArea(name); 
        return t;
    }
    /*
    
    private JTextField criaTextField(String name){
        JTextField t = new JTextField(name); 
        return t;
    }
    */
    
    private JFrame criaJanela(int id ) {
        botao = new ArrayList();
        JFrame janela;
        switch(id){
            case 1:
                janela = new JFrame("Controle Pessoal de Finanças");    //PAGINA PRINCIPAL
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLayout(new GridLayout(4,2));
                botao.add(criaBotao("Nova Transação"));
                botao.add(criaBotao("Buscar Transações"));
                botao.add(criaBotao("Listar Transações"));
                botao.add(criaBotao("Sobre"));
                janela.add(botao.get(0));
                janela.add(botao.get(1));
                janela.add(botao.get(2));
                janela.add(botao.get(3));
                return janela;
            case 2:
                janela = new JFrame("Nova Transação");                  // PAGINA 2
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLayout(new GridLayout(3,2));
                botao.add(criaBotao("Nova Transação de hoje"));
                botao.add(criaBotao("Nova Transação Passada/Futura"));
                botao.add(criaBotao("Voltar"));
                janela.add(botao.get(0));
                janela.add(botao.get(1));
                janela.add(botao.get(2));
                return janela;
            case 3:
                janela = new JFrame("Nova Transação de Hoje");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLayout(new GridLayout(3,2));
                botao.add(criaBotao("Saída"));
                botao.add(criaBotao("Entrada"));
                botao.add(criaBotao("Voltar"));
                janela.add(botao.get(0));
                janela.add(botao.get(1));
                janela.add(botao.get(2));
                return janela;
            case 4:
                janela = new JFrame("Nova Transação Passada/Futura");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLayout(new GridLayout(4,2));
                botao.add(criaBotao("Avançar"));              
                botao.add(criaBotao("Voltar"));
                janela.add(new JLabel("Data (dd/mm)", SwingConstants.LEFT));
                janela.add(ta.get(0));
                janela.add(botao.get(0));
                janela.add(botao.get(1));
                return janela;
            case 5:
                janela = new JFrame("Nova Transação");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLayout(new GridLayout(5,2));
                botao.add(criaBotao("Avançar"));              
                botao.add(criaBotao("Voltar"));
                janela.add(new JLabel("Valor:", SwingConstants.LEFT));
                janela.add(ta.get(1));
                janela.add(new JLabel("TAG", SwingConstants.LEFT));
                janela.add(ta.get(2));
                janela.add(botao.get(0));
                janela.add(botao.get(1));
                return janela;
            case 6:
                janela = new JFrame("Buscar Transação");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               janela.setSize(600, 400);
                janela.setLayout(new GridLayout(3,2));
                botao.add(criaBotao("Buscar por dia"));
                botao.add(criaBotao("Buscar por mês"));
                botao.add(criaBotao("Voltar"));
                janela.add(botao.get(0));
                janela.add(botao.get(1));
                janela.add(botao.get(2));
                return janela;
            case 7:
                janela = new JFrame("Buscar Transação por dia");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLayout(new GridLayout(4,2));
                botao.add(criaBotao("Avançar"));              
                botao.add(criaBotao("Voltar"));
                janela.add(new JLabel("Data (dd/mm)", SwingConstants.LEFT));
                janela.add(ta.get(3));
                janela.add(botao.get(0));
                janela.add(botao.get(1));
                return janela;
            case 8:
                janela = new JFrame("Buscar Transação por mês");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLayout(new GridLayout(4,2));
                botao.add(criaBotao("Avançar"));              
                botao.add(criaBotao("Voltar"));
                janela.add(new JLabel("Data (mm)", SwingConstants.LEFT));
                janela.add(ta.get(4));
                janela.add(botao.get(0));
                janela.add(botao.get(1));
                return janela;
            case 9:
                janela = new JFrame("Controle Pessoal de Finanças");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(600, 400);
                janela.setLayout(new GridLayout(3,2));                            
                botao.add(criaBotao("Ok"));
                janela.add(ta.get(5));
                janela.add(botao.get(0));
                return janela;
            case 10:
                janela = new JFrame("Lista de Transações");
                //janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(700, 1000);
                janela.setLayout(new BoxLayout(janela.getContentPane(), BoxLayout.Y_AXIS));
                ta.get(6).setBackground(Color.white);
                janela.add(ta.get(6));
                return janela;
            case 11:
                janela = new JFrame("Controle Pessoal de Finanças");
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(655, 400);
                janela.setLayout(new GridLayout(2,4));
                janela.add(ta.get(7));
                botao.add(criaBotao("Voltar"));
                ta.get(7).append("Este software foi desenvolvido por Gabriel Marques de Melo para a disciplina Praticas de Programacao Orientada a");
                ta.get(7).append(newline+"Objetos, disciplina obrigatoria da grade de Ciencia da Computacao-Bacharelado da Universidade Federal de Lavras");
                ta.get(7).append(newline+newline+"Codigo-fonte disponivel no repositorio:  github.com/GabrielMMelo/java");
                janela.add(botao.get(0));
                return janela;
                
            default:  
                janela = new JFrame("erro");
                return janela;
        }
        
    }
    
    private JButton criaBotao(String label){
        JButton b = new JButton(label);
        b.addActionListener(this);
        b.setActionCommand(label);
        return b;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Component component = (Component) e.getSource();
        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
        
        if (frame == janelas.get(0)) {      //  Pagina principal
        
            if ("Nova Transação".equals(e.getActionCommand())){
                //JOptionPane.showMessageDialog(frame, "Botão 1!!!");
                this.exibir(2);
                this.esconder(1);

            }

            else if ("Buscar Transações".equals(e.getActionCommand())){
                //JOptionPane.showMessageDialog(frame, "Botão 2!!!");
                this.exibir(6);
                this.esconder(1);
            }
            
            else if ("Listar Transações".equals(e.getActionCommand())){
                //JOptionPane.showMessageDialog(frame, "Botão 2!!!");
                ta.get(6).setText("Saldo anual: ");
                ta.get(6).append(ano.listAno());
                Financa financa = new Financa();
                ta.get(6).append(newline);
                ta.get(6).append(financa.getSaldo(ano));
                this.exibir(10);
               
            }
            
            else {
                this.exibir(11);
                this.esconder(1);
            } 
        }
        
        else if (frame == janelas.get(1)) {      //  PAGINA 2
        
            if ("Nova Transação de hoje".equals(e.getActionCommand())){
                this.exibir(3);
                this.esconder(2);

            }

            else if ("Nova Transação Passada/Futura".equals(e.getActionCommand())){
                this.exibir(4);
                this.esconder(2);
            }

            else {
                this.exibir(1);
                this.esconder(2);
                
            } 
        }
        
        else if (frame == janelas.get(2)) {      // PÁGINA 3
        
            if ("Saída".equals(e.getActionCommand())){
                texts.add("true");
                this.exibir(5);
                this.esconder(3);

            }

            else if ("Entrada".equals(e.getActionCommand())){
                texts.add("false");
                this.exibir(5);
                this.esconder(3);
            }

            else {
                texts.clear();
                this.exibir(2);
                this.esconder(3);
                
            } 
        }
        
        else if (frame == janelas.get(3)) {      //  PÁGINA 4
        
            if ("Avançar".equals(e.getActionCommand())){
                //JOptionPane.showMessageDialog(frame, "Botão 1!!!");
                String str = ta.get(0).getText();
                String Data[] =  str.split("/");
                texts.add(Data[1]);
                texts.add(Data[0]);
                this.exibir(3);
                this.esconder(4);

            }

            else {
                this.exibir(2);
                this.esconder(4);
                
            } 
        }
        
        else if (frame == janelas.get(4)) {      //  PÁGINA 5  
        
            if ("Avançar".equals(e.getActionCommand())){
                
                float valor = Float.parseFloat(ta.get(1).getText());
                String tag = ta.get(2).getText();
                
                if (texts.size() == 3){
                    boolean tipo = Boolean.parseBoolean(texts.get(2));
                    ano.novaTransacao(Integer.parseInt(texts.get(0)),Integer.parseInt(texts.get(1)),tipo,valor,tag);
                    String table = ano.converteMes(Integer.parseInt(texts.get(0))-1);
                    
                    if (tipo) {
                        try {
                            sql.insert(table, Integer.parseInt(texts.get(1)), 0, valor, tag);
                        } catch (SQLException ex) {
                            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else {
                        try {
                            sql.insert(table, Integer.parseInt(texts.get(1)), valor, 0, tag);
                        } catch (SQLException ex) {
                            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
                else{     
                    
                    boolean tipo = Boolean.parseBoolean(texts.get(0));
                    ano.novaTransacao(tipo,valor,tag);
                    String table = ano.converteMes(data[1]-1);
                    //System.out.println(table);
                    
                    if (tipo) {
                     try {
                            sql.insert(table, data[0], 0, valor, tag);
                        } catch (SQLException ex) {
                            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     }
                    else {
                        try {
                            sql.insert(table, data[1], valor, 0, tag);
                        } catch (SQLException ex) {
                            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                JOptionPane.showMessageDialog(frame, "Transação concluída com sucesso!!!");
                texts.clear();
                this.exibir(1);
                this.esconder(5);

            }           

            else {
                if (texts.size() == 3)
                    texts.remove(2);
                else
                    texts.remove(0);
                
                this.exibir(3);
                this.esconder(5);
                
            } 
        }
        
        else if (frame == janelas.get(5)) {      //  PÁGINA 6
        
            if ("Buscar por dia".equals(e.getActionCommand())){
                //JOptionPane.showMessageDialog(frame, "Transação concluída com sucesso!!!");
                this.exibir(7);
                this.esconder(6);

            }

            else if ("Buscar por mês".equals(e.getActionCommand())){
                //JOptionPane.showMessageDialog(frame, "Botão 2!!!");
                this.exibir(8);
                this.esconder(6);
            }

            else {
                this.exibir(1);
                this.esconder(6);
                
            } 
        }
        
        else if (frame == janelas.get(6)) {      //  PÁGINA 7
        
            if ("Avançar".equals(e.getActionCommand())){
               // JOptionPane.showMessageDialog(frame, "Transação concluída com sucesso!!!");
               
                String str = ta.get(3).getText();
                String Data[] =  str.split("/");       
                float saida = ano.getSaida(Integer.parseInt(Data[1]),Integer.parseInt(Data[0]));
                float entrada = ano.getEntrada(Integer.parseInt(Data[1]),Integer.parseInt(Data[0]));
                texts.add("Saída: R$" + saida);
                texts.add("Entrada: R$" + entrada);
                //System.out.println("Saída: R$"+ saida);
                //System.out.println("Entrada: R$"+entrada);
                float total2 = entrada - saida;
                if (total2 <0) {
                    total2 *= -1;
                    texts.add("Saldo total: R$" + total2);
                    //System.out.println("Saldo total: -R$" + total2);
                }
                else
                    texts.add("Saldo total: R$" + total2);
                
                str = texts.get(0)+newline+texts.get(1)+newline+texts.get(2);
                texts.clear();
                ta.get(5).setText(str);
                //janelas.get(8)
                this.exibir(9);
                this.esconder(7);

            }

            else {
                this.exibir(6);
                this.esconder(7);
                
            } 
        }
        
        else if (frame == janelas.get(7)) {      //  PÁGINA 8
        
            if ("Avançar".equals(e.getActionCommand())){
                
                int mes = Integer.parseInt(ta.get(4).getText());
                float saida = ano.getSaida(mes);
                float entrada = ano.getEntrada(mes);
                texts.add("Saída: R$" + saida);
                texts.add("Entrada: R$" + entrada);
                float total = entrada - saida;
                if (total <0) {
                    total *= -1;
                    texts.add("Saldo total: -R$" + total);
                }
                else
                    texts.add("Saldo total: R$" + total);
                            
                String str = texts.get(0)+newline+texts.get(1)+newline+texts.get(2);
                texts.clear();
                ta.get(5).setText(str);         
                this.exibir(9);
                this.esconder(8);

            }

            else {
                this.exibir(6);
                this.esconder(8);
                
            } 
        }
        
        else if (frame == janelas.get(8)) {      //  PÁGINA 9
            texts.clear();
            this.exibir(1);
            this.esconder(9);

        }
        
        else if (frame == janelas.get(9)) {      //  PÁGINA 10
            texts.clear();
            this.exibir(1);
            this.esconder(9);

        }
        
        else if (frame == janelas.get(10)) {      //  PÁGINA 11
            
            this.exibir(1);
            this.esconder(11);

        }
        
    }
    /**
     * Método que realiza todas as interações com o usuário
     */
/*    public void menu(){
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
    
  */  
    /**
     * Método que auxilia método menu() para manipular as entradas e saídas para usuário usuário. Foi criado visando modularização do código.
     * @param operacao Uma das operações disponibilizadas no método menu()
     * * @see menu() 
     */
    /*private void subMenu(int operacao){
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
                            if (total <0) {
                                total *= -1;
                                System.out.println("Saldo total: -R$" + total);
                            }
                            else
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
                            if (total2 <0) {
                                total2 *= -1;
                                System.out.println("Saldo total: -R$" + total2);
                            }
                            else
                                System.out.println("Saldo total: R$" + total2);
                            chave2 = 0;
                        break;
                    }
                }
            break;

        }
        
    }
    */
    /**
     * Função que "limpa" a tela do console
     */
    /*public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    */
    /**
     * Tela de informações sobre o projeto e o autor
     */
    /*
    public void sobre(){
        clearScreen();
        System.out.println("        $$$$$ SOBRE $$$$$");
        System.out.println("        Este software foi desenvolvido por Gabriel Marques de Melo para a disciplina Praticas de Programacao Orientada a");
        System.out.println("        Objetos, disciplina obrigatoria da grade de Ciencia da Computacao-Bacharelado da Universidade Federal de Lavras");
        System.out.println("");
        System.out.println("Codigo-fonte disponivel no repositorio:  github.com/GabrielMMelo/java");
        System.out.println("");
        
    }*/
}
