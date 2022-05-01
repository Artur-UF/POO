/*
Programa: Classe abstrata da qual derivam tipos de veiculos
Objetivo: cria a classe abstrata Veiculo com seus atributos e métodos abstratos
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frohlich
Data: 29/03/2022
*/
package classes;

public abstract class Veiculo {

    /* Atributos */
    protected String marca;
    protected String modelo;
    protected String placa;
    protected int ano;
    protected double valor;
    protected boolean multasRecentes;

    /* Construtor */
    public Veiculo(String marca, String modelo, String placa, int ano, double valor){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.valor = valor;
    }

    /* Métodos abstratos */
    public abstract void registraMulta();

    public abstract double calculaImposto();

    /* Sobrescrita do método toString */
    public String toString(){
        return marca+" "+modelo+" ("+placa+")";
    }




}
