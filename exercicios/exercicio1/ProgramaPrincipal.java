/*
Programa: O programa principal que implementa a classe Imovel
Objetivo: Manipular a classe Imovel
Entrada: Atributos e valores
Saída: Valorização e imposto
Autor: Artur Uhlik Frohlich
Data: 06/02/2022
*/
package exercicio1;

public class ProgramaPrincipal {

    public static void main (String[] args){
        // Declaração e intanciação do objeto Imovel
        Imovel im1, im2;
        im1 = new Imovel();
        im2 = new Imovel();

        // Atribuição de valores aos atributos de im1
        im1.nBanheiros = 3;
        im1.nQuartos = 4;
        im1.temgaragem = true;
        im1.endereco = "Rua Tchurosbango Tchurosbago, n. 69";
        im1.aluguel = true;
        im1.valorvenda = 300000;

        // Aplicação dos métodos
        im1.imprimeDados();
        im1.valoriza(2.5);
        im1.imprimeDados();
        double imposto = im1.calculaImposto();
        System.out.printf("Imposto: R$%.2f\n", imposto);

        // Atribuição de valores aos atributos de im2
        im2.nBanheiros = 3;
        im2.nQuartos = 4;
        im2.temgaragem = true;
        im2.endereco = "Rua Tchurosbango Tchurosbago, n. 69";
        im2.aluguel = true;
        im2.valorvenda = 307500;

        // Parte 5#
        // Comparação dos imóveis
        if(im1 == im2){
            System.out.print("Os imóveis são iguais.\n");
        }else{
            System.out.print("Os imóveis são dierentes.\n");
        }
        // Aparentemente os imóveis são entendidos como diferentes aqui

        // Parte 6#
        // Declarando outro imóvel
        Imovel im3 = im1;
        im3.valorvenda = 0;
        im3.imprimeDados();
        im1.imprimeDados();

        // Ao modificar o valor de venda de im3 modificamos im1 também

    }

}
