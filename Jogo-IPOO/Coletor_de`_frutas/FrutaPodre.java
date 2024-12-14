import greenfoot.*;  // Importa as classes necessárias do Greenfoot

public class FrutaPodre extends Actor {
    private static double velocidadeQueda = 1.5; // Velocidade inicial da queda das frutas podres (ajustada para ser mais lenta)

    public static void aumentarVelocidade() {
        velocidadeQueda += 0.2; // Incrementa de forma mais sutil
    }

    public void act() {
        // Faz a fruta podre cair
        setLocation(getX(), (int)(getY() + velocidadeQueda));

        // Remove a fruta podre se atingir o fundo do mundo
        if (getY() >= getWorld().getHeight() - 1) {
            getWorld().removeObject(this);
        }
    }
}
