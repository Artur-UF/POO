package EntidadesOticas;

public class LenteConvergente extends Instrumentos {

    public LenteConvergente(String caminhoFigura){
        super(caminhoFigura);
    }

    public double equacaoGauss(double dObj, double foco) {
        double dIm;
        dIm = (dObj * foco)/(dObj - foco);
        return dIm;
    }
}
