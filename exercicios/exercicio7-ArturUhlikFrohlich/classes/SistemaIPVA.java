/*
Programa: Classe que constroi o Sistema de IPVA
Objetivo: Classe que constroi um sistema com um atributo e métodos relacionados a veiculos
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frohlich
Data: 29/03/2022
*/
package classes;

import java.util.ArrayList;

public class SistemaIPVA {
    /* Atributo */
    protected ArrayList<Veiculo> veiculos;

    /* Construtor */
    public SistemaIPVA(){
        veiculos = new ArrayList<Veiculo>();
    }

    /* Métodos */
    public void registraVeiculo(Veiculo veiculo){
        if(!veiculos.contains(veiculo)){
            veiculos.add(veiculo);
        }
    }

    public double totalImpostosRecolhidos(){
        double total = 0;
        for(Veiculo auto : veiculos){
            total += auto.calculaImposto();
        }
        return total;
    }
}
