/*
Programa: Classe que representa a posição de um drone em um mapa
Objetivo: Definir atributos e métodos referentes a posição do objeto
Entrada:
Saída:
Autor: Artur Uhlik Frohlich
Data: 13/02/2022
*/
package exercicio2.posicoes;

public class PosicaoMapa4x4 {

    // Atributos da clsse
    private int x;
    private int y;

    // Métodos da classe
    public boolean setX(int x){
        if(0 <= x && x < 4){
            this.x = x;
            return true;
        }else{
            reset();
            return false;
        }
    }

    public boolean setY(int y){
        if(0 <= y && y < 4){
            this.y = y;
            return true;
        }else{
            reset();
            return false;
        }
     }

    private void reset(){
        this.x = 0;
        this.y = 0;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void imprime(){
        System.out.printf("(%d, %d)\n", x, y);
    }

    public int distancia(PosicaoMapa4x4 p){
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }

}
