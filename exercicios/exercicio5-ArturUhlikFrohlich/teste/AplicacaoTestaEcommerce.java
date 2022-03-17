/*
Programa: Testa a aplicação do Ecommerce
Objetivo: Usa as classes Pagamento, Produto e Venda para realizar uma venda
Entrada: N/A
Saída: N/A
Autor: Artur Uhli Frohlich
Data: 03/03/2022
 */
package teste;

import classes.ClientePF;
import classes.ClientePJ;
import classes.Produto;
import classes.Venda;
import classes.Cliente;

public class AplicacaoTestaEcommerce {
    public static void main(String[] args){
        boolean teste;
        Cliente cliente = new ClientePF("08/03/2022", "Roberval Fonseca", "756.132.741-50");

        Produto p1 = new Produto("vela", 1.5, 50);
        Produto p2 = new Produto("Maçã", 2.5, 50);
        Produto p3 = new Produto("Caixa de fósforos", 3.0, 100);
        Produto p4 = new Produto("Coca-Cola", 5.34, 75);
        Produto p5 = new Produto("Régua", 3.5, 30);

        Venda v1 = new Venda(cliente, "3/04/2022");

        v1.registraProduto(p1, 10);
        v1.registraProduto(p2, 5);
        v1.registraProduto(p3, 3);
        v1.registraProduto(p4, 2);
        v1.registraProduto(p5, 1);

        v1.finalizaVenda(3);
        v1.registraPagamento("01/03/2022");

        v1.imprimeRecibo();
    }
}
