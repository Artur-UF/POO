/*
Programa: Sublasse derivada de Veiculo
Objetivo: Subclasse que se diferencia de Veiculo por ter um atributo novo e aplica os metódos proprios e abstratos
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frohlich
Data: 29/03/2022
*/
package classes;

public class CarroPasseio extends Veiculo{

    /* Atributo extra */
    protected String combustivel;

    /* Construtor */
    public CarroPasseio(String marca, String modelo, String placa, int ano, double valor, String combustivel){
        super(marca, modelo, placa, ano, valor);
        this.combustivel = combustivel;
    }

    /* Métodos */

    public String toString(){
        return "Carro de passeio: "+marca+" "+modelo+" ("+placa+")";
    }

    public double calculaImposto(){
        double imposto;
        if(2022-ano >= 20){
            imposto = 0;
            return imposto;
        }else{
            if(combustivel.equals("GNV")){
                imposto = 0.015*valor;
                if(!multasRecentes){
                    imposto = imposto*0.95;
                }
                return imposto;
            }else{
                imposto = 0.04*valor;
                if(!multasRecentes){
                    imposto = imposto*0.95;
                }
                return imposto;}
        }
    }

    public void registraMulta(){
        multasRecentes = true;
    }
}
