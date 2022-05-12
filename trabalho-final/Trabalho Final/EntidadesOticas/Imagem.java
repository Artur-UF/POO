package EntidadesOticas;

public class Imagem {

    private double distancia;
    private double tamanho;
    private double ampliacao;
    private String caminhoFigura;
    private String caminhoFiguraInvertida;

    public Imagem(String caminhoFigura, String caminhoFiguraInvertida){
        this.caminhoFigura = caminhoFigura;
        this.caminhoFiguraInvertida = caminhoFiguraInvertida;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public void setAmpliacao(double ampliacao) {
        this.ampliacao = ampliacao;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getTamanho() {
        return tamanho;
    }

    public double getAmpliacao() {
        return ampliacao;
    }

    public String getArquivoFigura() {
        return caminhoFigura;
    }

    public String getArquivoFiguraInvertida() {
        return caminhoFiguraInvertida;
    }
}
