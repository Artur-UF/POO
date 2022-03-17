/*
Programa: Simulção de um imóvel e suas propriedades imoboliárias
Objetivo: Criar uma classe Imovel com seus atributos e métodos
Entrada:
Saída:
Autor: Artur Uhlik Frohlich
Data: 06/02/2022
*/
package exercicio1;


public class Imovel {

    // Declaração dos atributos do imovel
    int nQuartos;
    int nBanheiros;
    boolean temgaragem;
    String endereco;
    boolean aluguel;
    double valorvenda;

    // Declaração dos métodos do imovel
    public void imprimeDados(){
        System.out.printf("Quartos: %d\nBanheiros: %d\nValor de venda: R$%.2f\n", nQuartos, nBanheiros, valorvenda);
        if (temgaragem){
            System.out.print("Garagem: Tem\n");
        }else{
            System.out.print("Garagem: Não tem\n");
        }
        System.out.print("Endereço: "+endereco+"\n-*-*-*-*-*-*-*-*-\n");
    }

    public void valoriza(double perc){
        valorvenda = valorvenda*(1+perc/100);
    }

    public double calculaImposto(){
        double Imposto;
        double valaluguel = valorvenda*0.05;
        if(aluguel){
            Imposto = valaluguel*0.12;
        }else{
            Imposto = valorvenda*0.18;
        }
        return Imposto;
    }


}
