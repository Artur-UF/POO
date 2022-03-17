/*
Programa: Criar a classe Produto
Objetivo: Ser vendido por Venda no Ecommerce
Entrada: N/A
Saída: N/A
Autor: Artur Uhlik Frohlich
Data: 03/03/2022
 */
package classes;

public class Produto {

    // Atributos:
    private String descricao;
    private double valor;
    private int quantidadeEstoque;

    // Construtores:
    public Produto(String descricao, double valor, int quantidadeEstoque){
          this.descricao = descricao;
          this.valor = valor;
          this.quantidadeEstoque = quantidadeEstoque;
    }

    // Métodos:
    public double getValor() {
        return valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
