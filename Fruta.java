import greenfoot.*; // Importa as classes Greenfoot

/**
 * Classe Fruta (subclasse de Actor)
 * 
 * Esta classe representa as frutas e suas ações dentro do jogo.
 * 
 * @autor Alex, Pedro e Ruan
 * @version 2025.01.20
 */
public class Fruta extends Actor {
    private int velocidade; // Velocidade de movimento da fruta

    /**
     * Construtor da classe Fruta.
     * Inicializa a velocidade e escala a imagem da fruta.
     * 
     * @param velocidade A velocidade de movimento da fruta.
     */
    public Fruta(int velocidade) {
        this.velocidade = velocidade;
        GreenfootImage imagem = getImage();
        imagem.scale(imagem.getWidth() / 2, imagem.getHeight() / 2);
        setImage(imagem);
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     * Faz a fruta cair.
     */
    public void act() {
        cair();
    }

    /**
     * Move a fruta para baixo com a velocidade definida.
     */
    public void cair() {
        setLocation(getX(), getY() + velocidade);
    }

    /**
     * Aumenta a velocidade da fruta até um máximo de 5.
     */
    public void aumentarVelocidade() {
        if (velocidade < 5) {
            velocidade++;
        }
    }

    /**
     * Acessa a velocidade da fruta.
     * 
     * @return A velocidade da fruta.
     */
    public int getVelocidade() {
        return velocidade;
    }
}