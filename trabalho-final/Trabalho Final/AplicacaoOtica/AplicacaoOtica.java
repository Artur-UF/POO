/*
Descrição: Aplicação em Java para simular sistemas de lentes e espelhos simples
Autores: Artur Uhlik Frholich e Vitoria Tesser Henkes - UFRGS
Disciplina: Programacao Orientada a Objetos
Data: 09/05/2022
*/
package AplicacaoOtica;

import EntidadesOticas.*;
import Excecoes.NegativeValueException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AplicacaoOtica extends JFrame implements ActionListener{

    public static void main(String[] args) {
        AplicacaoOtica frame = new AplicacaoOtica();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Componentes Utilizadas em Eventos
    private JPanel painelSuperior;
    private JTextField entradaDistanciaObjeto, entradaDistanciaFocal, entradaTamanhoObjeto;
    private JRadioButton espelhoConcavo, espelhoConvexo, lenteDivergente, lenteConvergente;
    private JTextField resultadoDistancia, resultadoTamanho, resultadoAumento;
    private JRadioButton imagemDireita, imagemInvertida, imagemReal, imagemVirtual;
    private ButtonGroup instrumentos, tipos, orientacoes;

    //Atributos Utilizados na Simulação
    private Instrumentos instrumento;
    private Objeto objeto = new Objeto("D:\\Aplicações\\IntelliJ\\POO\\Trabalho Final\\ImagensOticas\\figuraObjeto.png");
    private Imagem imagem = new Imagem("D:\\Aplicações\\IntelliJ\\POO\\Trabalho Final\\ImagensOticas\\figuraObjeto.png", "D:\\Aplicações\\IntelliJ\\POO\\Trabalho Final\\ImagensOticas\\figuraObjetoInvertida.png");

    //Criação de Estilo Pontilhado
    private final static float dash1[] = {10.0f};
    private final static BasicStroke dashed =
            new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, dash1, 0.0f);

    public AplicacaoOtica(){

        //Criação de Título
        super("Simulador de Lentes e Espelhos");

        //Criação de Abas
        JTabbedPane abasTotal = new JTabbedPane();

        //Organização da Aba Principal
        JPanel painelFundo = new JPanel();
        Container container = getContentPane();
        painelFundo.setLayout(new GridLayout(2, 1));
        abasTotal.addTab("Simulação", painelFundo);

        //Organização do Painel Superior
        painelSuperior = new JPanel();
        painelSuperior.setBorder(BorderFactory.createEtchedBorder());
        painelFundo.add(painelSuperior);

        //Organização do Painel Inferior
        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new GridLayout(1, 2));
        painelFundo.add(painelInferior);

        //Organização do Painel Inferior Esquerdo
        JPanel painelEntradas = new JPanel();
        painelEntradas.setLayout(new GridLayout(6,1));
        painelEntradas.setBorder(BorderFactory.createTitledBorder("Parâmetros"));

        //Linha 1
        JPanel parametros1 = new JPanel();
        parametros1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel distanciaObjeto = new JLabel("Distância do Objeto:");
        this.entradaDistanciaObjeto = new JTextField(5);
        parametros1.add(distanciaObjeto);
        parametros1.add(entradaDistanciaObjeto);
        painelEntradas.add(parametros1);

        //Linha 2
        JPanel parametros2 = new JPanel();
        parametros2.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel distanciaFocal = new JLabel("Distância Focal:");
        this.entradaDistanciaFocal = new JTextField(5);
        parametros2.add(distanciaFocal);
        parametros2.add(entradaDistanciaFocal);
        painelEntradas.add(parametros2);

        //Linha 3
        JPanel parametros3 = new JPanel();
        parametros3.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel tamanhoObjeto = new JLabel("Tamanho do Objeto:");
        this.entradaTamanhoObjeto = new JTextField(5);
        parametros3.add(tamanhoObjeto);
        parametros3.add(entradaTamanhoObjeto);
        painelEntradas.add(parametros3);

        //Linhas 4 e 5
        JPanel parametros4 = new JPanel();
        JPanel parametros5 = new JPanel();
        parametros4.setLayout(new FlowLayout(FlowLayout.LEFT));
        parametros5.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel escolhaInstrumento = new JLabel("Instrumento:");
        this.espelhoConcavo = new JRadioButton("Espelho Côncavo");
        this.espelhoConvexo = new JRadioButton("Espelho Convexo");
        this.lenteDivergente = new JRadioButton("Lente Divergente");
        this.lenteConvergente = new JRadioButton("Lente Convergente");
        instrumentos = new ButtonGroup();
        instrumentos.add(espelhoConcavo);
        instrumentos.add(espelhoConvexo);
        instrumentos.add(lenteConvergente);
        instrumentos.add(lenteDivergente);
        parametros4.add(escolhaInstrumento);
        parametros4.add(espelhoConcavo);
        parametros4.add(espelhoConvexo);
        parametros5.add(lenteDivergente);
        parametros5.add(lenteConvergente);
        painelEntradas.add(parametros4);
        painelEntradas.add(parametros5);

        //Linha 6
        JPanel parametros6 = new JPanel();
        parametros6.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton simular = new JButton("Simular");
        JButton reiniciar = new JButton("Reiniciar");
        simular.setActionCommand("simula");
        reiniciar.setActionCommand("reinicia");
        simular.addActionListener(this);
        reiniciar.addActionListener(this);
        parametros6.add(simular);
        parametros6.add(reiniciar);
        painelEntradas.add(parametros6);

        painelInferior.add(painelEntradas);

        //Organização do Painel Inferior Direito
        JPanel painelResultados = new JPanel();
        painelResultados.setLayout(new GridLayout(5, 1));
        painelResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));

        //Linha 1
        JPanel resultados1 = new JPanel();
        resultados1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel distanciaImagem = new JLabel("Distância da Imagem:");
        this.resultadoDistancia = new JTextField(5);
        resultadoDistancia.setEditable(false);
        resultados1.add(distanciaImagem);
        resultados1.add(resultadoDistancia);

        //Linha 2
        JPanel resultados2 = new JPanel();
        resultados2.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel tamanhoImagem = new JLabel("Tamanho da Imagem:");
        this.resultadoTamanho = new JTextField(5);
        resultadoTamanho.setEditable(false);
        resultados2.add(tamanhoImagem);
        resultados2.add(resultadoTamanho);

        //Linha 3
        JPanel resultados3 = new JPanel();
        resultados3.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel fatorAumento = new JLabel("Fator de Aumento:");
        this.resultadoAumento = new JTextField(5);
        resultadoAumento.setEditable(false);
        resultados3.add(fatorAumento);
        resultados3.add(resultadoAumento);

        //Linha 4
        JPanel resultados4 = new JPanel();
        resultados4.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel orientacaoImagem = new JLabel("Orientação da Imagem:");
        this.imagemDireita = new JRadioButton("Direita");
        this.imagemInvertida = new JRadioButton("Invertida");
        imagemDireita.setEnabled(false);
        imagemInvertida.setEnabled(false);
        orientacoes = new ButtonGroup();
        orientacoes.add(imagemDireita);
        orientacoes.add(imagemInvertida);
        resultados4.add(orientacaoImagem);
        resultados4.add(imagemDireita);
        resultados4.add(imagemInvertida);

        //Linha 5
        JPanel resultados5 = new JPanel();
        resultados5.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel tipoImagem = new JLabel("Tipo de Imagem:");
        this.imagemReal = new JRadioButton("Real");
        this.imagemVirtual = new JRadioButton("Virtual");
        imagemReal.setEnabled(false);
        imagemVirtual.setEnabled(false);
        tipos = new ButtonGroup();
        tipos.add(imagemReal);
        tipos.add(imagemVirtual);
        resultados5.add(tipoImagem);
        resultados5.add(imagemReal);
        resultados5.add(imagemVirtual);
        painelResultados.add(resultados1);
        painelResultados.add(resultados2);
        painelResultados.add(resultados3);
        painelResultados.add(resultados4);
        painelResultados.add(resultados5);
        painelInferior.add(painelResultados);

        //Organização da Aba Secundária
        JPanel informacoes = new JPanel();

        //Titulo 1
        JPanel posicaoTitulo1 = new JPanel();
        posicaoTitulo1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo1 = new JLabel("Apresentação");
        posicaoTitulo1.add(titulo1);
        informacoes.add(posicaoTitulo1);

        //Texto 1
        JPanel posicaoTexto1 = new JPanel();
        JTextArea areaTexto1 = new JTextArea(8, 65);
        areaTexto1.append("Este programa tem como objetivo calcular e representar graficamente as características da imagem formada por uma\n");
        areaTexto1.append("lente ou por um espelho esférico. As características do objeto e do instrumento relevantes ao problema são informadas\n");
        areaTexto1.append("pelo usuário no canto inferior esquerdo da interface, e os resultados numéricos são apresentados no canto inferior\n");
        areaTexto1.append("direito. Na parte superior, a representação gráfica da situação é mostrada.\n");
        areaTexto1.append("\nA simulação tem fins didáticos e para isso simplica diversas características da realidade. A modelagem do sistema físico\n");
        areaTexto1.append("em questão é feita através da Ótica Geométrica.");
        areaTexto1.setEditable(false);
        areaTexto1.setSelectionColor(Color.GRAY);
        posicaoTexto1.add(areaTexto1);
        informacoes.add(posicaoTexto1);

        //Titulo 2
        JPanel posicaoTitulo2 = new JPanel();
        posicaoTitulo2.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo2 = new JLabel("Embasamento Teórico");
        posicaoTitulo2.add(titulo2);
        informacoes.add(posicaoTitulo2);

        //Texto 2
        JPanel posicaoTexto2 = new JPanel();
        JTextArea areaTexto2 = new JTextArea(10, 50);
        areaTexto2.append("O modelo teórico utilizado para a realização dos cálculos e para a apresentação\n");
        areaTexto2.append("gráfica é baseado na Equação de Gauss para lentes e espelhos. O programa usa \n");
        areaTexto2.append("essa equação para encontrar a distância da imagem (di) gerada em relação ao vértice\n");
        areaTexto2.append("(representado por um ponto preto sobre o instrumento ótico). Nos casos da distância\n");
        areaTexto2.append("da imagem ser negativa a imagem será virtual (formada pelos prolongamentos dos raios\n");
        areaTexto2.append("reais). Para o cálculo do fator de ampliação (m) é utilizada a equação do aumento, que\n");
        areaTexto2.append("representa a razão entre o tamanho da imagem gerada e o tamanho do objeto original. Caso\n");
        areaTexto2.append("o sinal de m for negativo, a imagem será invertida.");
        areaTexto2.setEditable(false);
        posicaoTexto2.add(areaTexto2);

        //Equações
        try{
            BufferedImage equacoes = ImageIO.read(new File("D:\\Aplicações\\IntelliJ\\POO\\Trabalho Final\\ImagensOticas\\equacoes.png"));
            Image equacoesDimensionadas = equacoes.getScaledInstance(140, 140, Image.SCALE_DEFAULT);
            JLabel imagemEquacoes = new JLabel(new ImageIcon(equacoesDimensionadas));
            posicaoTexto2.add(imagemEquacoes);
        }catch(IOException e) {
            System.out.println("Imagem inacessível");
        }
        informacoes.add(posicaoTexto2);

        abasTotal.addTab("Informações", informacoes);

        //Empacotamento dos Painéis
        container.add(abasTotal);
        this.setPreferredSize(new Dimension(750, 450));
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    //Tratamento de Eventos
    public void actionPerformed(ActionEvent acao){
        if(acao.getActionCommand().equals("simula")){
            boolean entradaInvalida = obtencaoParametros();
            if(!entradaInvalida) {
                simulacaoNumerica();
                simulacaoVisual();
            }
        }else{
            reinicio();
        }
    }

    private boolean obtencaoParametros(){

        boolean error = false; //Variável Controle da Validade das Entradas

        //Instanciação do Instrumento Conforme a Escolha do Usuário
        if (lenteConvergente.isSelected()) {
            instrumento = new LenteConvergente("D:\\Aplicações\\IntelliJ\\POO\\Trabalho Final\\ImagensOticas\\lenConvergente.png");
        } else if (lenteDivergente.isSelected()) {
            instrumento = new LenteDivergente("D:\\Aplicações\\IntelliJ\\POO\\Trabalho Final\\ImagensOticas\\lenDivergente.png");
        } else if (espelhoConcavo.isSelected()) {
            instrumento = new EspelhoConcavo("D:\\Aplicações\\IntelliJ\\POO\\Trabalho Final\\ImagensOticas\\espConcavo.png");
        } else if (espelhoConvexo.isSelected()) {
            instrumento = new EspelhoConvexo("D:\\Aplicações\\IntelliJ\\POO\\Trabalho Final\\ImagensOticas\\espConvexo.png");
        }

        //Atribuição de Valor à Distância Focal se Entrada for Válida
        try{
            instrumento.setDistanciaFocal(Double.parseDouble(entradaDistanciaFocal.getText()));
            verificaSinal(instrumento.getDistanciaFocal());
        }catch(NumberFormatException | NegativeValueException e){
            entradaDistanciaFocal.setText("Inválido!");
            entradaDistanciaFocal.setForeground(Color.red);
            error = true;
        }

        //Atribuição de Valor à Distância do Objeto se Entrada for Válida
        try{
            objeto.setDistancia(Double.parseDouble(entradaDistanciaObjeto.getText()));
            verificaSinal(objeto.getDistancia());
        }catch(NumberFormatException | NegativeValueException e){
            entradaDistanciaObjeto.setText("Inválido!");
            entradaDistanciaObjeto.setForeground(Color.red);
            error = true;
        }

        //Atribuição de Valor ao Tamanho do Objeto se Entrada for Válida
        try{
            objeto.setTamanho(Double.parseDouble(entradaTamanhoObjeto.getText()));
            verificaSinal(objeto.getTamanho());
        }catch(NumberFormatException | NegativeValueException e){
            entradaTamanhoObjeto.setText("Inválido!");
            entradaTamanhoObjeto.setForeground(Color.red);
            error = true;
        }

        return error;
    }
    
    private void simulacaoNumerica(){

        //Cálculos das Variáveis de Saída
        imagem.setDistancia(instrumento.equacaoGauss(objeto.getDistancia(), instrumento.getDistanciaFocal()));
        imagem.setAmpliacao(instrumento.ampliacao(imagem.getDistancia(), objeto.getDistancia()));
        imagem.setTamanho(Math.abs(objeto.getTamanho() * imagem.getAmpliacao()));

        //Apresentação dos Dados de Saída
        resultadoDistancia.setText(String.format("%.2f", imagem.getDistancia()));
        resultadoAumento.setText(String.format("%.2f", imagem.getAmpliacao()));
        resultadoTamanho.setText(String.format("%.2f", imagem.getTamanho()));
        if (imagem.getAmpliacao() < 0) {
            imagemInvertida.setEnabled(true);
            imagemInvertida.doClick();
        } else {
            imagemDireita.setEnabled(true);
            imagemDireita.doClick();
        }
        if (imagem.getDistancia() < 0) {
            imagemVirtual.setEnabled(true);
            imagemVirtual.doClick();
        } else {
            imagemReal.setEnabled(true);
            imagemReal.doClick();
        }
    }

    private void simulacaoVisual(){

        Graphics2D g = (Graphics2D)painelSuperior.getGraphics();

        //Desenho do Eixo Central
        g.setColor(Color.gray);
        g.drawLine(30, 110, 700, 110);
        for(int i = 30; i < 701; i++) {
            if (i % 10 == 0) {
                g.drawLine(i, 105, i, 115);
            }

        }

        //Repesentação dos Focos
        g.setColor(Color.BLUE);
        g.fillOval(350 + Math.toIntExact(Math.round(instrumento.getDistanciaFocal() * 10)) - 3, 110 - 3, 6, 6);
        g.fillOval(350 - Math.toIntExact(Math.round(instrumento.getDistanciaFocal() * 10)) - 3, 110 - 3, 6, 6);
        g.setColor(Color.gray);

        //Imagem do Objeto
        try{
            BufferedImage figuraObjeto = ImageIO.read(new File(objeto.getArquivoFigura()));
            int alturaObjeto = Math.toIntExact(Math.round(objeto.getTamanho()*10));
            int larguraObjeto = Math.toIntExact(Math.round(alturaObjeto*2/3));
            Image objetoDimensionado = figuraObjeto.getScaledInstance(larguraObjeto, alturaObjeto, Image.SCALE_DEFAULT);
            g.drawImage(objetoDimensionado, 350 - Math.toIntExact(Math.round(objeto.getDistancia() * 10)) - larguraObjeto/2, 110 - alturaObjeto, null);
            if(imagem.getDistancia() != Double.POSITIVE_INFINITY && imagem.getDistancia() != Double.NEGATIVE_INFINITY) {
                g.setColor(Color.ORANGE);
                g.drawLine(350 - Math.toIntExact(Math.round(objeto.getDistancia() * 10)), 110 - alturaObjeto, 350, 110 - alturaObjeto);
                g.drawLine(350 - Math.toIntExact(Math.round(objeto.getDistancia() * 10)), 110 - alturaObjeto, 350, 110);
                g.setColor(Color.BLACK);
            }
        } catch (IOException e){
            System.out.println("Imagem inacessível!");
        }

        //Imagem da Imagem
        if(imagem.getDistancia() != Double.POSITIVE_INFINITY && imagem.getDistancia() != Double.NEGATIVE_INFINITY) {
            try {
                double distanciaImagem; //Convenção de Sinais da Imagem é distinta para Espelhos
                if ((instrumento instanceof EspelhoConvexo) || (instrumento instanceof EspelhoConcavo)) {
                    distanciaImagem = -imagem.getDistancia();
                } else {
                    distanciaImagem = imagem.getDistancia();
                }
                BufferedImage figuraImagem;
                if (imagem.getAmpliacao() > 0) {
                    figuraImagem = ImageIO.read(new File(imagem.getArquivoFigura()));
                } else {
                    figuraImagem = ImageIO.read(new File(imagem.getArquivoFiguraInvertida()));
                }
                int alturaImagem = Math.toIntExact(Math.round(imagem.getTamanho() * 10));
                int larguraImagem = Math.toIntExact(Math.round(alturaImagem * 2 / 3));
                Image imagemDimensionada = figuraImagem.getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_DEFAULT);
                if (imagem.getAmpliacao() > 0) {
                    g.drawImage(imagemDimensionada, 350 + Math.toIntExact(Math.round(distanciaImagem * 10)) - larguraImagem / 2, 110 - alturaImagem, null);
                    if (imagemReal.isSelected()) {
                        g.setColor(Color.ORANGE);
                        g.drawLine(350, 110 - Math.toIntExact(Math.round(objeto.getTamanho() * 10)), 350 + Math.toIntExact(Math.round(distanciaImagem * 10)), 110 - alturaImagem);
                        g.drawLine(350, 110, 350 + Math.toIntExact(Math.round(distanciaImagem * 10)), 110 - alturaImagem);
                        g.setColor(Color.BLACK);
                    } else if (imagemVirtual.isSelected()) {
                        // Raios reais
                        g.setColor(Color.ORANGE);
                        g.drawLine(350, 110 - Math.toIntExact(Math.round(objeto.getTamanho() * 10)), 350 - (Math.toIntExact(Math.round(distanciaImagem * 10))), (110 - Math.toIntExact(Math.round(objeto.getTamanho() * 10))) - (Math.toIntExact(Math.round(objeto.getTamanho() * 10)) - alturaImagem));
                        g.drawLine(350, 110, 350 - (Math.toIntExact(Math.round(distanciaImagem * 10))), 110 + alturaImagem);
                        // Raios prolongados
                        g.setStroke(dashed);
                        g.drawLine(350, 110 - Math.toIntExact(Math.round(objeto.getTamanho() * 10)), 350 + Math.toIntExact(Math.round(distanciaImagem * 10)), 110 - alturaImagem);
                        g.drawLine(350, 110, 350 + Math.toIntExact(Math.round(distanciaImagem * 10)), 110 - alturaImagem);
                        g.setColor(Color.BLACK);

                    }
                } else {
                    if (imagemReal.isSelected()) {
                        g.drawImage(imagemDimensionada, 350 + Math.toIntExact(Math.round(distanciaImagem * 10)) - larguraImagem / 2, 110, null);
                        g.setColor(Color.ORANGE);
                        g.drawLine(350, 110 - Math.toIntExact(Math.round(objeto.getTamanho() * 10)), 350 + Math.toIntExact(Math.round(distanciaImagem * 10)), 110 + alturaImagem);
                        g.drawLine(350, 110, 350 + Math.toIntExact(Math.round(distanciaImagem * 10)), 110 + alturaImagem);
                        g.setColor(Color.BLACK);
                    } else if (imagemVirtual.isSelected()) {
                        // Raios reais
                        g.drawImage(imagemDimensionada, 350 + Math.toIntExact(Math.round(distanciaImagem * 10)) - larguraImagem / 2, 110, null);
                        g.setColor(Color.ORANGE);
                        g.drawLine(350, 110 - Math.toIntExact(Math.round(objeto.getTamanho() * 10)), 350 - (Math.toIntExact(Math.round(distanciaImagem * 10))), (110 - Math.toIntExact(Math.round(objeto.getTamanho() * 10))) - (Math.toIntExact(Math.round(objeto.getTamanho() * 10)) - alturaImagem));
                        g.drawLine(350, 110, 350 - (Math.toIntExact(Math.round(distanciaImagem * 10))), 110 + alturaImagem);
                        // Raios prolongados
                        g.setStroke(dashed);
                        g.drawLine(350, 110 - Math.toIntExact(Math.round(objeto.getTamanho() * 10)), 350 + Math.toIntExact(Math.round(distanciaImagem * 10)), 110 - alturaImagem);
                        g.drawLine(350, 110, 350 + Math.toIntExact(Math.round(distanciaImagem * 10)), 110 - alturaImagem);
                        g.setColor(Color.BLACK);
                    }
                }
            } catch (IOException e) {
                System.out.println("Imagem inacessível!");
            }
        }

        //Imagem do Instrumento
        try{
            BufferedImage figuraInstrumento = ImageIO.read(new File(instrumento.getArquivoFigura()));
            Image instrumentoDimensionado = figuraInstrumento.getScaledInstance(50, 130, Image.SCALE_DEFAULT);
            g.drawImage(instrumentoDimensionado, 350 - 50/2, 110 - 130/2, null);
        } catch (IOException e){
            System.out.println("Imagem inacessível!");
        }

        g.setColor(Color.BLACK);
        g.fillOval(350 - 2, 110 - 2, 4, 4);
    }

    private void reinicio(){
        entradaDistanciaObjeto.setText(null);
        entradaDistanciaObjeto.setForeground(Color.BLACK);
        entradaDistanciaFocal.setText(null);
        entradaDistanciaFocal.setForeground(Color.BLACK);
        entradaTamanhoObjeto.setText(null);
        entradaTamanhoObjeto.setForeground(Color.BLACK);
        resultadoDistancia.setText(null);
        resultadoTamanho.setText(null);
        resultadoAumento.setText(null);

        imagemInvertida.setSelected(false);
        imagemInvertida.setEnabled(false);
        imagemDireita.setSelected(false);
        imagemDireita.setEnabled(false);
        imagemReal.setSelected(false);
        imagemReal.setEnabled(false);
        imagemVirtual.setSelected(false);
        imagemVirtual.setEnabled(false);

        painelSuperior.repaint();
        instrumentos.clearSelection();
        orientacoes.clearSelection();
        tipos.clearSelection();
    }

    //Método para Impedir Entradas não Positivas
    private void verificaSinal(double valor) throws NegativeValueException{
        if (valor <= 0){
            throw new NegativeValueException();
        }
    }
}

