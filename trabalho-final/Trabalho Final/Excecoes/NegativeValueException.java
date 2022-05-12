package Excecoes;

public class NegativeValueException extends Exception{

    public NegativeValueException(){
        super("Valor negativo inserido");
    }
}
