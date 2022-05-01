/*
Programa: Classe Aplicaçao com o main
Objetivo: Aplica as classes utilizando os objetos serializados
Entrada: O nome do jogador e os palpites
Saída: Tempo de duração do jogo e um ranking com as 3 melhores pontuações
Nome: Artur Uhlik Frohlich
Data: 12/04/2022
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args){


        Scanner scan = new Scanner(System.in);
        String nome;

        // Professor, não sei a razão mas só consegui fazer funcionar usando os caminhos absolutos
        ArrayList<String> dicionario = (ArrayList<String>) ManipuladorSerializaveis.desserializar("D:\\Aplicações\\IntelliJ\\POO\\exercicio9-ArturUhlikFrohlich\\dicionario.poo");

        ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ManipuladorSerializaveis.desserializar("D:\\Aplicações\\IntelliJ\\POO\\exercicio9-ArturUhlikFrohlich\\ranking.poo");

        // Inicio do Jogo
        System.out.print("Digite seu nome: ");
        nome = scan.next();
        Jogador jogador = new Jogador(nome);
        Wordler jogo = new Wordler(dicionario);

        double score = jogo.jogar();
        jogador.setScore(score);

        jogadores.add(jogador);

        // Para imprimir o ranking:
        jogadores.sort(new Ordenador());
        jogadores.remove(3);

        System.out.println("Ranking:");
        for(int i = 0 ; i < 3 ; i++){
            int posicao = i+1;
            System.out.println(posicao+"º- "+jogadores.get(i));
        }

        ManipuladorSerializaveis.serializa("D:\\Aplicações\\IntelliJ\\POO\\exercicio9-ArturUhlikFrohlich\\ranking.poo", jogadores);

            }
        }

