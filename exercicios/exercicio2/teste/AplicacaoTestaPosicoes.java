/*
Programa: Programa principal onde é aplicada a classe PosicaoMapa4x4
Objetivo: Escanear as coordenadas de diferentes objetos e localizá-los em um mapa 4x4
Entrada: (x, y) de dois objetos da classe PosicaoMapa4x4
Saída: A distância entre os objetos e sua representação em um mapa
Autor: Artur Uhlik Frohlich
Data: 13/02/2022
 */
package exercicio2.teste;
import java.util.Scanner;
import exercicio2.posicoes.PosicaoMapa4x4;

public class AplicacaoTestaPosicoes {
    public static void main(String[] args){
        PosicaoMapa4x4 p1, p2;
        p1 = new PosicaoMapa4x4();
        p2 = new PosicaoMapa4x4();
        Scanner num = new Scanner(System.in);

        // Atribuindo valores de p1
        boolean rx, ry;
        do{
            System.out.print("Para p1, digite valores válidos para x e y:\n");
            rx = p1.setX(num.nextInt());
            ry = p1.setY(num.nextInt());
        }while(!rx || !ry);
        p1.imprime();

        // Atribuindo valores de p2
        do{
            System.out.print("Para p2, digite valores válidos para x e y:\n");
            rx = p2.setX(num.nextInt());
            ry = p2.setY(num.nextInt());
        }while(!rx || !ry);
        p2.imprime();

        // Calculando a distância
        int dist = p1.distancia(p2);
        System.out.printf("A distância entre p1 e p2 é: %d\n", dist);

        // Gerando o Mapa
        int MAXY = 4, MAXX = 4;
        for(int y = 0; y < MAXY; y++){
            for(int x = 0; x < MAXX; x++){
                if(x == p1.getX() && y == p1.getY()){
                    System.out.print(" x ");
                }else if(x == p2.getX() && y == p2.getY()){
                    System.out.print(" o ");
                }else{
                    System.out.print(" - ");
                }
            }
            System.out.print("\n");
        }

    }
}
