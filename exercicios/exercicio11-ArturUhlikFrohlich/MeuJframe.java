/*
Programa: Interface Gráfica interativa
Objetivo: Gerar um conversor de moedas
Entrada: Valor a ser convertido
Saída: Vaslor convertido ou uma mensagem de erro (caso o valor a ser convertido é inválido)
Nome: Artur Uhlik Frohlich
Data: 16/04/2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class MeuJframe extends JFrame implements ActionListener {

    /*
    Tive que trazer alguns atributos para fora do construtor para poder usá-los
    nos métodos adicionais.
     */
    JTextField campotxt1;
    JTextField campotxt2;
    JComboBox cmbbx;
    JRadioButton rbotao1;
    JRadioButton rbotao2;
    JRadioButton rbotao3;

    public MeuJframe (){
        super("Conversor de Câmbio");

        JPanel pnorte, psul, pleste, poeste, pcentro;
        pnorte = new JPanel();
        pnorte.setBorder(BorderFactory.createEtchedBorder());
        psul = new JPanel();
        psul.setBorder(BorderFactory.createEtchedBorder());
        pleste = new JPanel();
        pleste.setLayout(new BoxLayout(pleste, BoxLayout.Y_AXIS));
        pleste.setBorder(BorderFactory.createTitledBorder("Para:"));
        poeste = new JPanel();
        poeste.setBorder(BorderFactory.createTitledBorder("De:"));
        pcentro = new JPanel();

        // NORTE
        JLabel label1 = new JLabel("Valor: ");
        campotxt1 = new JTextField("");
        campotxt1.setPreferredSize(new Dimension(170, 20));
        pnorte.add(label1);
        pnorte.add(campotxt1);
        add(pnorte, BorderLayout.NORTH);

        // SUL
        JButton botao1 = new JButton("Converter!");
        JButton botao2 = new JButton("Resetar");
        JLabel label3 = new JLabel("Valor convertido: ");
        campotxt2 = new JTextField("");
        campotxt2.setPreferredSize(new Dimension(170, 20));

        // Nomeando e colocando os listeners para cada botão
        botao1.setActionCommand("converte");
        botao2.setActionCommand("reseta");
        botao1.addActionListener(this);
        botao2.addActionListener(this);

        psul.add(botao1);
        psul.add(botao2);
        psul.add(label3);
        psul.add(campotxt2);
        add(psul, BorderLayout.SOUTH);

        // LESTE
        rbotao1 = new JRadioButton("Real");
        rbotao2 = new JRadioButton("Dólar");
        rbotao3 = new JRadioButton("Euro");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbotao1);
        grupo.add(rbotao2);
        grupo.add(rbotao3);
        pleste.add(rbotao1);
        pleste.add(rbotao2);
        pleste.add(rbotao3);
        add(pleste, BorderLayout.EAST);

        // OESTE
        String[] correncias = new String[3];
        correncias[0] = "Real";
        correncias[1] = "Dólar";
        correncias[2] = "Euro";
        cmbbx = new JComboBox(correncias);
        poeste.add(cmbbx, BorderLayout.WEST);
        add(poeste, BorderLayout.WEST);

        // CENTRO
        try{
            BufferedImage minhaimagem = ImageIO.read(new File("D:\\Aplicações\\IntelliJ\\POO\\exercicio11-ArturUhlikFrohlich\\1F4B1_color.png"));
            /* Solução que achei para reduzir o tamanho da imagem */
            Image dminhaimagem = minhaimagem.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            JLabel label2 = new JLabel(new ImageIcon(dminhaimagem));
            label2.setPreferredSize(new Dimension(300, 300));

            pcentro.add(label2);
            add(pcentro, BorderLayout.CENTER);
        }catch (IOException e){
            JLabel labelerro = new JLabel("Imagem Inacessível");
            pcentro.add(labelerro);
            add(pcentro, BorderLayout.CENTER);
        }

        this.setPreferredSize(new Dimension(500, 500));
        this.pack();
        this.setVisible(true);
    }

    // Realiza as ações dos boões 'Converter' e 'Resetar'
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("converte")) {
            trataConversao();
        }
        if (ae.getActionCommand().equals("reseta")){
            campotxt1.setText("");
            campotxt2.setText("");
            campotxt2.setForeground(Color.BLACK);
        }
    }

    // Função para fazer a conversão
    private void trataConversao (){
        double valori;
        try {
            valori = Double.parseDouble(campotxt1.getText());

            /* Casos se cada Jbutton for pressionado
            Dentro de cada 'if' eu uso a condição de ser igual ou não ao
            selecionado na Combobox
            */

            // Jbutton do Real
            if(rbotao1.isSelected()){
                if(cmbbx.getSelectedItem().toString().equals("Real")){
                    campotxt2.setText("Mesma moeda");
                    campotxt2.setForeground(Color.red);
                }else if(cmbbx.getSelectedItem().toString().equals("Dólar")){
                    valori = valori * 0.2142980012;
                    campotxt2.setText(String.format("%.2f", valori));
                    campotxt2.setForeground(Color.BLACK);
                }else if(cmbbx.getSelectedItem().toString().equals("Euro")){
                    valori = valori * 0.1985711638;
                    campotxt2.setText(String.format("%.2f", valori));
                    campotxt2.setForeground(Color.BLACK);
                }
            }
            // Jbutton do Dólar
            if(rbotao2.isSelected()){
                if(cmbbx.getSelectedItem().toString().equals("Dólar")){
                    campotxt2.setText("Mesma moeda");
                    campotxt2.setForeground(Color.red);
                }else if(cmbbx.getSelectedItem().toString().equals("Real")){
                    valori = valori * 4.6663991;
                    campotxt2.setText(String.format("%.2f", valori));
                    campotxt2.setForeground(Color.BLACK);
                }else if(cmbbx.getSelectedItem().toString().equals("Euro")){
                    valori = valori * 0.9266123;
                    campotxt2.setText(String.format("%.2f", valori));
                    campotxt2.setForeground(Color.BLACK);
                }
            }
            // Jbutton do Euro
            if(rbotao3.isSelected()){
                if(cmbbx.getSelectedItem().toString().equals("Euro")){
                    campotxt2.setText("Mesma moeda");
                    campotxt2.setForeground(Color.red);
                }else if(cmbbx.getSelectedItem().toString().equals("Real")){
                    valori = valori * 5.035977938;
                    campotxt2.setText(String.format("%.2f", valori));
                    campotxt2.setForeground(Color.BLACK);
                }else if(cmbbx.getSelectedItem().toString().equals("Dólar")){
                    valori = valori * 1.079200006;
                    campotxt2.setText(String.format("%.2f", valori));
                    campotxt2.setForeground(Color.BLACK);
                }
            }
        }catch (NumberFormatException e){
            if(campotxt1.getText().equals("")){
                campotxt2.setText("");
            }else{
                campotxt2.setText("Valor Inválido");
                campotxt2.setForeground(Color.red);
            }
        }
    }

    public static void main (String[] args) {
        MeuJframe frame = new MeuJframe();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
