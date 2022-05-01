/*
Programa: Aplicação principal do programa
Objetivo: Aplica as subclasses de Veiculo na classe SistemaIPVA e imprime os resultados
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frohlich
Data: 29/03/2022
*/
package teste;

import classes.CarroPasseio;
import classes.Motocicleta;
import classes.SistemaIPVA;
import classes.Veiculo;

public class Aplicacao {
    public static void main(String[] args) {
        SistemaIPVA sistema = new SistemaIPVA();

        Veiculo v1 = new CarroPasseio("Fort", "Ca", "ABC-1234", 2001, 12000.00, "Gasolina");
        Veiculo v2 = new CarroPasseio("VolxVagem", "Down", "DEF-1234", 2020, 50000.00, "GNV");
        Veiculo v3 = new CarroPasseio("GN", "Omix", "GHI-1234", 2022, 97000.00, "Flex");
        Veiculo v4 = new Motocicleta("Ronda", "CH", "JKL-1234", 2022, 10500.00, 160);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        v1.registraMulta();
        v2.registraMulta();
        v4.registraMulta();

        sistema.registraVeiculo(v1);
        sistema.registraVeiculo(v2);
        sistema.registraVeiculo(v3);
        sistema.registraVeiculo(v4);

        System.out.printf("Rendimento: R$%.2f", sistema.totalImpostosRecolhidos());

    }
}
