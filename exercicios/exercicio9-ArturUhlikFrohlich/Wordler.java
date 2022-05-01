/*
Programa: Classe Wordler
Objetivo: Cria as funcionalidades do jogo
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frolhich
Data: 12/04/2022
 */
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Wordler {

    /* Atributos */
    private ArrayList<String> dicionario;
    private String sorteada;

    /* Construtor */
    public Wordler(ArrayList<String> dicionario){
        this.dicionario = dicionario;
    }

    /* Métodos */
    public double jogar(){
        long inicio = System.nanoTime();
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        String palavra;

        int indice = rand.nextInt(11);
        String sorteada = dicionario.get(indice);

        for(int cont=0 ; cont < 4 ; cont++) {
            do {
                System.out.printf("Jogada %d: ", cont+1);
                palavra = scanner.next();
            }while(!dicionario.contains(palavra));

            if(verifica(palavra, sorteada).equals("***")){
                System.out.print(verifica(palavra, sorteada)+"\n");
                long fim = System.nanoTime() - inicio;
                System.out.printf("Tempo: %.2f segundos\n", fim*Math.pow(10, -9));
                return fim*Math.pow(10, -9);
            }else{
                System.out.print(verifica(palavra, sorteada)+"\n");
            }
        }
        System.out.print("Perdeu :(\nA palavra certa era "+sorteada+"\n");
        return Double.MAX_VALUE;
    }

    /* O método verifica gera a String que é imprimida depois do palpite do jogador */
    private String verifica(String chute, String certa){
        ArrayList<String> letras = new ArrayList<>();
        for(int i=0 ; i < 3 ; i++){
            if(Objects.equals(chute.charAt(i), certa.charAt(i))){
                letras.add("*");
            }else if(certa.contains("" + chute.charAt(i))){
                letras.add("+");
            }else{
                letras.add("-");
            }
        }
        return letras.get(0)+letras.get(1)+letras.get(2);
    }





}
