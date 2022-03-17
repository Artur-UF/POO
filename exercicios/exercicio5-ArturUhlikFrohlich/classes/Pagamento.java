/*
Programa: Constrói a classe pagamento para
Objetivo: pagar Produto(s) em Venda no Ecommerce
Entrada: N/A
Saída: N/A
Autor: Artur Uhlik Frohlich
Data: 03/03/2022
 */
package classes;

public class Pagamento {

    // Atributos:
    private String data;
    private double valor;

    // Construtor:
    public Pagamento(String data, double valor){
        this.data = data;
        this.valor = valor;
    }

    public String getData(){
        return data;
    }

    public double getValor() {
        return valor;
    }
}

