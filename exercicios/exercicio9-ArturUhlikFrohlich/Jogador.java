/*
Programa: Classe Jogador serializável
Objetivo: Criar a Classe Jogador e seus respectivos métodos e atributos
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frohlich
Data: 12/04/2022
 */
import java.io.Serializable;

public class Jogador implements Serializable {

    /* Atributos */
    private String nome;
    private double score;
    private static final long serialVersionUID = 123L;

    /* Construtores */
    public Jogador(String nome){
        this.nome = nome;
    }

    public Jogador(String nome, double score){
        this.nome = nome;
        this.score = score;
    }

    /* Métodos */
    public void setScore(double score){this.score = score;}

    public double getScore(){return score;}

    public String toString(){
        if(score < Double.MAX_VALUE) {
            return String.format("%s(%.2f)", nome, score);
        }else{
            return String.format("%s(Infinito)", nome);
        }
        }

}
