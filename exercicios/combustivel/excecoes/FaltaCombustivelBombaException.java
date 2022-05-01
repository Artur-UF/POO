package excecoes;

public class FaltaCombustivelBombaException extends CombustivelException{

    public FaltaCombustivelBombaException (String mensagem){
    
        super("Não há combustível na bomba!");
    
    }

}
