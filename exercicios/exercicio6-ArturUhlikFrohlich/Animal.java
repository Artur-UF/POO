/*
  Classe Animal (genérica)
*/
public class Animal{

    protected String nome; /* Nome do Animal */
    protected String raca; /* Raça do Animal */
    protected double peso; /* Peso (massa) em quilogramas do Animal */
    
    private int identificador; /* Identificador (único) do Animal */
    private static int numAnimais = 0; /* Atributo de classe que permite implementar 'identificador' */
    
    /* Construtor: recebe e manipula atributos de instância e seta identificador */
    public Animal(String nome, String raca, double peso){
        Animal.numAnimais += 1;
        this.raca = raca;
        this.nome = nome;
        this.peso = peso;
        this.identificador = Animal.numAnimais;
    }
    
    /* Sobrescrevendo o método toString() de Object */
    /* Comente o método to String e veja o que acontece. */    
    public String toString(){
        return nome+" ("+raca+")"; 
    }
    
    /* Método que retorna o quanto (em quilogramas) o Animal precisa comer em um dia */
    public double getAlimentacaoDiaria(){
        return peso * .01; /* 1% de seu peso (massa) */
    }
    
    /* Retorna o identificador do Animal */
    public int getIdentificador(){
        return identificador;
    }

}
