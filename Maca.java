import greenfoot.*;

public class Maca extends Fruta {
    
    // O construtor PRECISA receber a velocidade do mundo
    public Maca(int vel) {
        super(vel);
    }

    @Override
    protected void executarAcaoDePerda() {
        World mundo = getWorld();
        // Usamos polimorfismo para verificar onde a maçã caiu
        if (mundo instanceof Cenario) {
            ((Cenario) mundo).getContador().atualizarMacasBoasPerdidas();
        } else if (mundo instanceof CenarioFase2) {
            ((CenarioFase2) mundo).getContador().atualizarMacasBoasPerdidas();
        }
    }
}