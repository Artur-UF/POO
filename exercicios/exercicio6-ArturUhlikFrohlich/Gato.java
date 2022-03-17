public class Gato extends Animal{
    /* 
       Implementar o construtor de Gato 
    */
    public Gato(String nome, String raca, double peso){
        super(nome, raca, peso);
    }

    /* 
       Sobrescrever o método toString() de Animal.
       Retornar, ao invés do valor padrão em Animal, a indicação, dentro dos parênteses,
       não somente da raça do Gato mas também que o Animal é um Gato. 
       O nome do Gato também deve aparecer como em Animal.
    */
    public String toString(){
        return nome+" ( Gato "+raca+")";
    }

    /* 
       Sobrescrever o método getAlimentacaoDiaria() de Animal.
       Retornar 1.25% do peso do Gato.
    */

    public double getAlimentacaoDiaria() {
        return peso * .0125;
    }
}
