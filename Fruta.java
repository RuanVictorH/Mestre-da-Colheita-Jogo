import greenfoot.*;

/**
 * Classe pai para todas as frutas.
 */
public class Fruta extends Actor {
    protected int velocidade; // Usamos protected para as subclasses acessarem se precisarem

    public Fruta(int velocidade) {
        this.velocidade = velocidade;
        GreenfootImage imagem = getImage();
        imagem.scale(50, 50); 
        setImage(imagem);
    }

    public void act() {
        cair();
        if (getY() >= getWorld().getHeight() - 180) {
            executarAcaoDePerda();
            getWorld().removeObject(this);
        }
    }

    public void cair() {
        setLocation(getX(), getY() + velocidade);
    }

    /**
     * Método que as subclasses (Maca) podem sobrescrever para tirar pontos ou atualizar contadores.
     */
    protected void executarAcaoDePerda() {
        // Por padrão, não faz nada.
    }
}