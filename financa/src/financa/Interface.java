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
     * Construtor da classe. Cria todos campos de texto, janelas e lê os dados persistentes no Banco de Dados
     * @throws SQLException Exceções SQL
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
    
    /**
     * Metódo que torna visível uma janela identificada por seu ID
     * @param id Número de identificação da janela
     */
    public void exibir(int id) {
        janelas.get(id-1).setVisible(true);
    }
    
    /**
     * Metódo que torna invisível uma janela identificada por seu ID
     * @param id Número de identificação da janela
     */
    public void esconder(int id) {
        janelas.get(id-1).setVisible(false);
    }
    
    /**
     * Método que cria um novo campo de texto
     * @param name Conteúdo a ser exibido inicialmente no campo de texto
     */
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
    
    /**
     * Metódo que cria uma nova janela, construindo-a de acordo com seu id
     * @param id Número de identificação da janela
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
    /**
     * Metódo que cria um novo botão que terá uma Action Listener e um comando associado
     * @param label String que identifica o botão e seu comando gerado
     */
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
                this.exibir(7);
                this.esconder(6);
            }

            else if ("Buscar por mês".equals(e.getActionCommand())){
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
                String str = ta.get(3).getText();
                String Data[] =  str.split("/");       
                float saida = ano.getSaida(Integer.parseInt(Data[1]),Integer.parseInt(Data[0]));
                float entrada = ano.getEntrada(Integer.parseInt(Data[1]),Integer.parseInt(Data[0]));
                texts.add("Saída: R$" + saida);
                texts.add("Entrada: R$" + entrada);
                float total2 = entrada - saida;
                if (total2 <0) {
                    total2 *= -1;
                    texts.add("Saldo total: R$" + total2);
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
}
