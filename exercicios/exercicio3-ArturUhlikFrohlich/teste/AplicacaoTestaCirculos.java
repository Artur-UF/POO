/*
Programa: programa principal da aplicação
Objetivo: testar e manipular objetos da classe Circulo
Autor: Artur Uhlik Frohlich
Data: 22/02/2022
 */
package teste;

import moedas.Circulo;

public class AplicacaoTestaCirculos {
    public static void main(String[] args) {
        Circulo cA, cB, cC, cD;
        cA = new Circulo(1, 1, 2);
        cB = new Circulo(3, 0, 3);
        cC = new Circulo(2, 2, 2);
        cD = new Circulo(-5, 4, 5);

        // Parte 4#:
        // Imprime as informaçoes dos objetos
        cA.imprime();
        cB.imprime();
        cC.imprime();
        cD.imprime();

        // imprime a relação entre os objetos
        imprimeRelacoaCirulos(cA, cB);
        imprimeRelacoaCirulos(cA, cC);
        imprimeRelacoaCirulos(cA, cD);
        imprimeRelacoaCirulos(cC, cB);
        imprimeRelacoaCirulos(cD, cB);
        imprimeRelacoaCirulos(cC, cD);

        // Parte 5#:
        // move os objetos
        cA.move("baixo", 1);
        cA.move("esquerda", 1);
        cB.move("direita", 6);
        cB.move("cima", 5);
        cC.move("cima", 2);
        cD.move("cima", 2);
        cD.move("esquerda", 3);
        cD.move("baixo", 1);
        cD.move("esquerda", 1);

        // imprime as informações dos objetos de movidos
        cA.imprime();
        cB.imprime();
        cC.imprime();
        cD.imprime();

        // imprime as relações dos objetos depois de movidos
        imprimeRelacoaCirulos(cA, cB);
        imprimeRelacoaCirulos(cA, cC);
        imprimeRelacoaCirulos(cA, cD);
        imprimeRelacoaCirulos(cC, cB);
        imprimeRelacoaCirulos(cD, cB);
        imprimeRelacoaCirulos(cC, cD);

        }

        public static void imprimeRelacoaCirulos(Circulo c1, Circulo c2){
            if(Circulo.sobreposicao(c1, c2)){
                System.out.println("C"+c1.getIdentificador()+" e C"+c2.getIdentificador()+" se sobrepõem");
            }else{
                System.out.println("C"+c1.getIdentificador()+" e C"+c2.getIdentificador()+" não se sobrepõem");
            }
    }
}
