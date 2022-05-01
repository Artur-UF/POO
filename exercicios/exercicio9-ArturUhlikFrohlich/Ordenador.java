/*
Programa: Classe Ordenador
Objetivo: Cria um comparador para o método .sort ser usado na Aplicacao
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frohlich
Data: 12/04/2022
 */
import java.util.Comparator;

public class Ordenador implements Comparator<Jogador> {
    public int compare(Jogador jogador1, Jogador jogador2){
        return Double.compare(jogador1.getScore(), jogador2.getScore());
    }
}
