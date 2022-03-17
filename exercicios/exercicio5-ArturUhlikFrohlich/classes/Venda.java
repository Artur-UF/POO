/*
Programa: Cria a classe Venda
Objetivo: Vender Produto(s) e ser paga com Pagamento(s) no Ecommerce
Entrada: N/A
Saída: N/A
Autor: Artur Uhlik Frohlich
Data: 03/03/2022
 */
package classes;

public class Venda {

    // Atributos:
    private static int numeroNFe = 1;
    private Cliente cliente;
    private String data;
    private Pagamento[] parcelas;
    private int[] quantidades = new int[15];
    private int maxProdutos;
    private int maxParcelas;
    private static int contadorProdutos = 0;
    private static int contadorParcelas = 0;
    private Produto[] produtos = new Produto[15];


    // Construtor:
    public Venda(Cliente cliente, String data){
        this.cliente = cliente;
        this.data = data;
        this.maxParcelas = 10;
        this.maxProdutos = 15;
    }

    // Métodos:
    public boolean registraProduto(Produto p1, int quantidade){
        if (quantidade <= p1.getQuantidadeEstoque() && quantidade > 0){
            produtos[contadorProdutos] = new Produto(p1.getDescricao(), p1.getValor(), p1.getQuantidadeEstoque());
            p1.setQuantidadeEstoque(p1.getQuantidadeEstoque()-quantidade);
            quantidades[contadorProdutos] = quantidade;
            contadorProdutos++;
            return true;
        }else{
            System.out.print("Não foi possível adicinar.");
            return false;
        }
    }

    private double calculaValorTotal(){
        double valortotal = 0;
        for (int contador = 0;  contador < contadorProdutos; ++contador){
            valortotal += produtos[contador].getValor()*quantidades[contador];
        }
        return valortotal;
    }

    public void finalizaVenda(int numeroParcelas){
        if(numeroParcelas > 0 && numeroParcelas <= maxParcelas){
            parcelas = new Pagamento[numeroParcelas];
        }else{
            parcelas = new Pagamento[10];
        }
    }

    public boolean registraPagamento(String data){
        if(parcelas.length > 0 && parcelas.length <= maxParcelas){
            Pagamento p1 = new Pagamento(data, calculaValorTotal()/parcelas.length);
            parcelas[contadorParcelas] = p1;
            contadorParcelas++;
            return true;
        }else{return false;}
    }

    public void imprimeRecibo(){
        System.out.println("Dados da venda:");
        System.out.println("NFe: "+numeroNFe);
        cliente.imprimeDados();
        if(cliente instanceof ClientePF){
            ((ClientePF)cliente).imprimeDadosPF();
        }
        else if(cliente instanceof ClientePJ){
            ((ClientePJ)cliente).imprimeDadosPJ();
        }
        System.out.print("Data da venda: "+data+"\n");
        int totalProdutos = 0;
        for(int quantidade : quantidades){
            totalProdutos += quantidade;
        }
        System.out.println("Total de produtos: "+totalProdutos);
        System.out.println("    Descrição | quantidade | Valor toal");
        for(int contador = 0; contador < contadorProdutos; ++contador){
            System.out.println("    "+produtos[contador].getDescricao()+" | "+quantidades[contador]+" | R$"+produtos[contador].getValor()*quantidades[contador]);
        }
        System.out.println("Valor total da compra: R$"+calculaValorTotal());
        System.out.println("Total de parcelas: "+parcelas.length);
        for(int contador = 0; contador < contadorParcelas; contador++){
            System.out.print("  "+(contador+1)+". "+parcelas[contador].getData()+" R$ "+parcelas[contador].getValor()+"\n");
        }
        if(parcelas.length <= maxParcelas){
            for(int contador = contadorParcelas; contador < parcelas.length; contador++){
                System.out.print("  "+(contador+1)+". dd/mm/aaaa "+"R$ "+(calculaValorTotal()/parcelas.length)+"\n");
        }
        }
    }

}
