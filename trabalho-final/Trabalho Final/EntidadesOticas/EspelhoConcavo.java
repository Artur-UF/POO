package EntidadesOticas;

public class EspelhoConcavo extends Instrumentos {

    public EspelhoConcavo(String caminhoFigura){
        super(caminhoFigura);
    }

    public double equacaoGauss(double dObj, double foco) {
        double dIm;
        dIm = (dObj * foco)/(dObj - foco);
        return dIm;
    }
}
