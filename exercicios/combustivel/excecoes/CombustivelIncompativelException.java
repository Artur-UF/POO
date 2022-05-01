package excecoes;

public class CombustivelIncompativelException extends CombustivelException{

    public CombustivelIncompativelException (String combustivel1, String combustivel2){
    
        super(combustivel1 + " não é compatível com " + combustivel2);
    
    }

}
