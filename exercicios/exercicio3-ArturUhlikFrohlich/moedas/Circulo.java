/*
Programa: Simular a situação de sobrebosição de moedas
Objetivo: Criar a classe Circulo com seus atributos e métodos
Autor: Artur Uhlik Frohlich
Data: 22/02/2022
 */
package moedas;

import java.util.Objects;

public class Circulo {
    // Atributos
    private double x;
    private double y;
    private double raio;
    private int identificador;
    private static int numCirculos = 0;

    // Construtor
    public Circulo(double x, double y, double raio){
        this.identificador = ++numCirculos;
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    // Métodos
    public void move(String direcao, double deslocamento){
        if(Objects.equals(direcao, "cima")){
            y = y + deslocamento;
        }
        if(Objects.equals(direcao, "baixo")){
            y = y - deslocamento;
        }
        if(Objects.equals(direcao, "esquerda")){
            x = x - deslocamento;
        }
        if(Objects.equals(direcao, "direita")) {
            y = y + deslocamento;
        }
    }

    public void imprime(){
        System.out.printf("C%d={(%.1f, %.1f), %.1f}\n", identificador, x, y, raio);
    }

    public int getIdentificador(){
        return identificador;
    }

    // Método de Classe
    public static boolean sobreposicao(Circulo C1, Circulo C2){
        double esquerda;
        double direita;
        esquerda = Math.pow(C1.x-C2.x, 2) + Math.pow(C1.y-C2.y, 2);
        direita = Math.pow(C1.raio+C2.raio, 2);
        return esquerda <= direita;
    }

}
