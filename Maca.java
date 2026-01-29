import greenfoot.*;

/**
 * Classe Maca (subclasse de Fruta)
 * 
 * Esta classe representa as frutas boas que o personagem deve coletar.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2024.12.08
 */
public class Maca extends Fruta {
    /**
     * Construtor da classe Maca.
     */
    public Maca() {
        super(2); // Define a velocidade das frutas boas como 2
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     * Faz a fruta realizar suas ações.
     */
    public void act() {
        super.act(); // Chama o método act da superclasse Fruta

        // Verifica se a fruta atingiu o chão e não foi coletada
        if (getY() >= getWorld().getHeight() - 240) {
            World mundo = getWorld();

            // Verifica se o mundo é uma instância de Cenario ou CenarioFase2
            if (mundo instanceof Cenario) {
                Cenario cenario = (Cenario) mundo;
                Contador contador = cenario.getContador();
                contador.atualizarMacasBoasPerdidas(); // Atualiza a quantidade de maçãs boas perdidas
            } else if (mundo instanceof CenarioFase2) {
                CenarioFase2 cenarioFase2 = (CenarioFase2) mundo;
                Contador contador = cenarioFase2.getContador();
                contador.atualizarMacasBoasPerdidas(); // Atualiza a quantidade de maçãs boas perdidas
            }

            getWorld().removeObject(this); // Remove a fruta do mundo
    }
}
}