import excecoes.*;

public class Veiculo{

    private String combustivel;
    private double nivelCombustivel;
    private double capacidadeTanque;
    private double distanciaPorLitroGasolina;
    
    public Veiculo(double capacidadeTanque, double distanciaPorLitroGasolina){
        this.combustivel = null;
        this.nivelCombustivel = 0;
        this.capacidadeTanque = capacidadeTanque;
        this.distanciaPorLitroGasolina = distanciaPorLitroGasolina;
    }
    
    /* Anunciar e lançar exceção NivelMuitoBaixoCombustivelException! */
    /* Tratar caso em que não se pode consumir o combustível */
    public void dirigir() throws NivelMuitoBaixoCombustivelException{
        double quantCombustivelPorKm;
        if(this.combustivel == null){
            throw new NivelMuitoBaixoCombustivelException();
        }else{
            if (this.combustivel.equals("Gasolina"))
                quantCombustivelPorKm = 1.0 / distanciaPorLitroGasolina;
            else // "Álcool" rende 25% a menos
                quantCombustivelPorKm = (1.0 / distanciaPorLitroGasolina) * 1.25;
        }
        if(this.nivelCombustivel >= quantCombustivelPorKm) {
            this.nivelCombustivel -= quantCombustivelPorKm;
        }else{
            throw new NivelMuitoBaixoCombustivelException();
        }
    }
    
     /* Anunciar e lançar exceções CombustivelIncompativelException, NivelMuitoAltoCombustivelException e FaltaCombustivelBombaException! */
    /* Tratar caso em que não se pode colocar mais combustível */
    /* Tratar caso em que não se pode colocar combustível por incompatibilidade */
     public void abastecer(BombaCombustivel bomba) throws NivelMuitoAltoCombustivelException, CombustivelIncompativelException, FaltaCombustivelBombaException{
        String combustivel = bomba.getCombustivel();
        double quantidade = bomba.get1LitroCombustivel();
        if (this.combustivel == null)
           this.combustivel = combustivel;
         if(!combustivel.equals(this.combustivel)){
             throw new CombustivelIncompativelException(combustivel, this.combustivel);
         }
        if(capacidadeTanque >= nivelCombustivel+quantidade) {
            this.nivelCombustivel += quantidade;
        }else{
            throw new NivelMuitoAltoCombustivelException();
        }
    }

    
    public String toString(){
        return "Nível de " + this.combustivel + ": " + String.format("%.2f", 100*this.nivelCombustivel/this.capacidadeTanque) + "%";
    }

}
