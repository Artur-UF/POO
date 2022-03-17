/*
Programa: Subclasse de Cliente
Objetivo: Adiciona os atributos "razaoSocial" e "cnpj"
Entrada: N/A
Saída: N/A
Autor: Artur Uhli Frohlich
Data: 08/03/2022
 */
package classes;

public class ClientePJ extends classes.Cliente{

    // Atributos
    private String razaoSocial;
    private String cnpj;

    // Construtor
    public ClientePJ(String dataCadastro, String razaoSocial, String cnpj){
        super(dataCadastro);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    // Métodos
    public void imprimeDadosPJ(){
        System.out.print("Razão Social: "+razaoSocial+"\nCNPJ: "+cnpj+"\n");
    }

}
