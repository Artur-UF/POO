package excecoes;

public class NivelMuitoBaixoCombustivelException extends CombustivelException{

    public NivelMuitoBaixoCombustivelException (){
    
        super("Nível de combustível muito baixo!");
    
    }

}
