import excecoes.*;
import java.util.Scanner;

public class Aplicacao2{

   public static void main(String[] args){
   
       int kmRodados = 0; 
       boolean haComoAbastecer = true;

       int distancia = 0;
       String combustivel = null;

       BombaCombustivel bombaGasolina = new BombaCombustivel("Gasolina", 500);
       BombaCombustivel bombaAlcool = new BombaCombustivel("Álcool", 100);

       BombaCombustivel bomba = bombaGasolina;
       Veiculo veiculo = new Veiculo(45, 8.75);
       
       Scanner scanner = new Scanner(System.in);
       
       /* Tratar exceção NumberFormatException! */
       do{
          System.out.println("Digite uma distância a ser percorrida:");
          try {
              distancia = Integer.parseInt(scanner.next());
          }catch (NumberFormatException e){
              System.out.println("Valor inválido!");
              System.out.println("Digite uma distância a ser percorrida:");
              distancia = Integer.parseInt(scanner.next());
          }
          if (distancia <= 0)
             System.out.println("Valor inválido!");
       }while(distancia <= 0);
       
       do{
          System.out.println("Digite um combustível:");
          combustivel = scanner.next();
          if (!combustivel.equals("Álcool") && !combustivel.equals("Gasolina"))
             System.out.println("Valor inválido!");
       }while(!combustivel.equals("Álcool") && !combustivel.equals("Gasolina"));

       if (combustivel.equals("Álcool"))
          bomba = bombaAlcool;
       else
          bomba = bombaGasolina;

       scanner.close();
                            
       while(kmRodados < distancia && haComoAbastecer){
          /* Tratar exceção NivelMuitoBaixoCombustivelException! */
           try {
               veiculo.dirigir();
           }catch (NivelMuitoBaixoCombustivelException e) {
               /* Tratar exceções CombustivelIncompativelException, NivelMuitoAltoCombustivelException e FaltaCombustivelBombaException! */
               while (true) { // Usar 'while(true)' não é uma boa prática, mas esse comportamento modela bem nosso 'modus operandi' na hora de "encher" o tanque do veículo!
                   try {
                       veiculo.abastecer(bomba);
                   }catch (NivelMuitoAltoCombustivelException e1){
                       System.out.println("Tanque cheio!");
                       break;
                   }catch (CombustivelIncompativelException e2){
                       if(bomba.equals(bombaAlcool)){
                           bomba = bombaGasolina;
                       }else{
                           bomba = bombaAlcool;
                       }
                       System.out.println("Bomba trocada!");
                       break;
                   }catch (FaltaCombustivelBombaException e3){
                       System.out.println("Cabou tudo meu chapa");
                       System.out.println(e3.getMessage());
                       haComoAbastecer = false;
                       break;
                   }
               }
           }
           kmRodados += 1;
       }
       
       System.out.println(veiculo);
       
   }

}
