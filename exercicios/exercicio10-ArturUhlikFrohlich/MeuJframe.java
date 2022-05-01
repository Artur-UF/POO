/*
Programa: Classe e main de uma interface gráfica
Objetivo: Gerar a interface gráfica de um conversor de moedas
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frohlich
Data: 16/04/2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MeuJframe extends JFrame {

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
        JTextField campotxt1 = new JTextField();
        campotxt1.setPreferredSize(new Dimension(170, 20));
        pnorte.add(label1);
        pnorte.add(campotxt1);
        add(pnorte, BorderLayout.NORTH);

        // SUL
        JButton botao1 = new JButton("Converter!");
        JButton botao2 = new JButton("Resetar");
        JLabel label3 = new JLabel("Valor convertido: ");
        JTextField campotxt2 = new JTextField();
        campotxt2.setPreferredSize(new Dimension(170, 20));
        psul.add(botao1);
        psul.add(botao2);
        psul.add(label3);
        psul.add(campotxt2);
        add(psul, BorderLayout.SOUTH);

        // LESTE
        JRadioButton rbotao1 = new JRadioButton("Real");
        JRadioButton rbotao2 = new JRadioButton("Dólar");
        JRadioButton rbotao3 = new JRadioButton("Euro");
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
        JComboBox cmbbx = new JComboBox(correncias);
        poeste.add(cmbbx, BorderLayout.WEST);
        add(poeste, BorderLayout.WEST);

        // CENTRO
        try{
            BufferedImage minhaimagem = ImageIO.read(new File("D:\\Aplicações\\IntelliJ\\POO\\exercicio10-ArturUhlikFrohlich\\1F4B1_color.png"));
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

    public static void main (String[] args) {
        MeuJframe frame = new MeuJframe();
    }
}
