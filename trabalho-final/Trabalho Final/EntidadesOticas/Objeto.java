package EntidadesOticas;

public class Objeto {

    private double distancia;
    private double tamanho;
    private String caminhoFigura;

    public Objeto(String caminhoFigura){
        this.caminhoFigura = caminhoFigura;
    }

    public void setDistancia(double distancia){
        this.distancia = distancia;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getTamanho() {
        return tamanho;
    }

    public String getArquivoFigura() {
        return caminhoFigura;
    }
}
