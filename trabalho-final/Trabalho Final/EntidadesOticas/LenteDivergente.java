package EntidadesOticas;

public class LenteDivergente extends Instrumentos{

    public LenteDivergente(String caminhoFigura){
        super(caminhoFigura);
    }

    public double equacaoGauss(double dObj, double foco) {
        double dIm;
        double dfoco = -foco;
        dIm = (dObj * dfoco)/(dObj - dfoco);
        return dIm;
    }
}
