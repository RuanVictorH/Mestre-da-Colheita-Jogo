import greenfoot.*;

/**
 * Classe MacaPodre (subclasse de Fruta)
 * 
 * Esta classe representa as frutas podres que devem ser evitadas pelo personagem.
 * 
 * @autor Alex, Pedro e Ruan
 * @version 2024.12.08
 */
public class MacaPodre extends Fruta {
    /**
     * Construtor da classe MacaPodre.
     */
    public MacaPodre() {
        super(2); // Define a velocidade das frutas podres como 2
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     * Faz a fruta podre realizar suas ações.
     */
    public void act() {
        super.act(); // Chama o método act da superclasse Fruta

        // Verifica se a fruta podre atingiu o chão e não foi coletada
        if (getY() >= getWorld().getHeight() - 240) {
            getWorld().removeObject(this); // Remove a fruta podre do mundo
        }
    }

    /**
     * Aumenta a velocidade da fruta podre até um máximo de 5.
     */
    @Override
    public void aumentarVelocidade() {
        if (getVelocidade() < 5) {
            super.aumentarVelocidade();
        }
    }
}
