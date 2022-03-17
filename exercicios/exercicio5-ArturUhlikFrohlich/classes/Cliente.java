/*
Programa: Superclasse das classes ClientePF e ClientePJ
Objetivo: Unifica os atributos "dataCadastro" e "identificador" das duas subclasses
Entrada: N/A
Saída: N/A
Autor: Artur Uhli Frohlich
Data: 08/03/2022
 */
package classes;

public class Cliente {

    // Atributos
    private int identificador;
    private String dataCadastro;
    private static int contador = 1;

    // Construtor
    Cliente(String dataCadastro){
        this.dataCadastro = dataCadastro;
        identificador = contador;
        ++contador;
    }

    // Mátodos
    public void imprimeDados(){
        System.out.print("Clinete: "+identificador+"\nData de cadastro: "+dataCadastro+"\n");
    }
}
