/*
Programa: Subclasse de Veiculo
Objetivo: Subclasse que se diferencia de Veiculo por ter um atributo novo e aplica os métodos proprios e abstratos
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frohlich
Data: 29/03/2022
*/
package classes;

public class Motocicleta extends Veiculo{

    /* Atributo extra */
    protected int cilindradas;

    /* Conatrutor */
    public Motocicleta(String marca, String modelo, String placa, int ano, double valor, int cilindradas){
        super(marca, modelo, placa, ano, valor);
        this.cilindradas = cilindradas;
    }

    /* Métodos */
    public String toString(){
        return "Motocicleta: "+marca+" "+modelo+" ("+placa+")";
    }

    public double calculaImposto(){
        double imposto;
        if(2022-ano >= 20 || cilindradas == 150){
            imposto = 0;
            return imposto;
        }else{
            imposto = 0.02*valor;
            if(!multasRecentes){
                imposto = imposto*0.95;
            }
            return imposto;
        }

    }

    public void registraMulta(){
        multasRecentes = true;
    }
}
