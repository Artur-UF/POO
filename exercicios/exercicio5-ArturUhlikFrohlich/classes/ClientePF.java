/*
Programa: Subclasse de Clinete
Objetivo: Adiciona os atributos "nome" e "cpf"
Entrada: N/A
Saída: N/A
Autor: Artur Uhli Frohlich
Data: 08/03/2022
 */
package classes;

public class ClientePF extends classes.Cliente {

    // Atributos
    private String nome;
    private String cpf;

    // Cpnstrutor
    public ClientePF(String dataCadastro, String nome, String cpf){
        super(dataCadastro);
        this.nome = nome;
        this.cpf = cpf;
    }

    // Métodos
    public void imprimeDadosPF(){
        System.out.print("Nome: "+nome+"\nCPF: "+cpf+"\n");
    }
}
