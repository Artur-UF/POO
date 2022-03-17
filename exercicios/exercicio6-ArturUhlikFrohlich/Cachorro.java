public class Cachorro extends Animal{
    /* 
       Implementar o construtor de Cachorro 
    */
    public Cachorro(String nome, String raca, double peso){
        super(nome, raca, peso);
      }

    /* 
       Sobrescrever o método toString() de Animal.
       Retornar, ao invés do valor padrão em Animal, a indicação, dentro dos parênteses,
       não somente da raça do Cachorro mas também que o Animal é um Cachorro.
       O nome do Cachorro também deve aparecer como em Animal.
    */

    public String toString(){
        return nome+" (Cachorro "+raca+")";
    }

    /* 
       Sobrescrever o método getAlimentacaoDiaria() de Animal.
       Retornar 1.5% do peso do Cachorro.
    */

    public double getAlimentacaoDiaria() {
        return peso * .015;
    }
}
