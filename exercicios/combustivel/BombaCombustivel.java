import excecoes.*;

public class BombaCombustivel{

    private double quantidade;
    private String combustivel;

    public BombaCombustivel(String combustivel, double quantidade){
        this.quantidade = quantidade;
        this.combustivel = combustivel;
    }
    
    public String getCombustivel(){
        return this.combustivel;
    }
    
    /* Anunciar e lançar exceção FaltaCombustivelBombaException! */
    /* Tratar caso em que não há mais combustível na bomba */
    public double get1LitroCombustivel() throws FaltaCombustivelBombaException{
        if(this.quantidade > 0) {
            this.quantidade -= 1;
            return 1;
        }else{
            throw new FaltaCombustivelBombaException("Combustível insuficiente!");
        }
    }
}
