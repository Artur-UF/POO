package EntidadesOticas;

public class EspelhoConvexo extends Instrumentos{

    public EspelhoConvexo(String caminhoFigura){
        super(caminhoFigura);
    }

    public double equacaoGauss(double dObj, double foco) {
        double dIm;
        double dfoco = -foco;
        dIm = (dObj * dfoco)/(dObj - dfoco);
        return dIm;
    }
}
