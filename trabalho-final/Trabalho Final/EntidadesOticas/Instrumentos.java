package EntidadesOticas;

public abstract class Instrumentos {

    private double distanciaFocal;
    private String caminhoFigura;

    public Instrumentos(String caminhoFigura){
        this.caminhoFigura = caminhoFigura;
    }

    public String getArquivoFigura() {
        return caminhoFigura;
    }

    public double getDistanciaFocal(){
        return distanciaFocal;
    }

    public void setDistanciaFocal(double dFocal){
        this.distanciaFocal = dFocal;
    }

    public abstract double equacaoGauss(double dObj, double dIm);

    public double ampliacao(double dIm, double dObj){
        return -dIm/dObj;
    }
}
