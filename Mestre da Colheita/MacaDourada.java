import greenfoot.*;

/**
 * Classe MacaDourada (subclasse de Fruta)
 * 
 * Esta classe representa as maçãs douradas que o jogador deve coletar na segunda fase.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.01.20
 */
public class MacaDourada extends Fruta {
    /**
     * Construtor da classe MacaDourada.
     */
    public MacaDourada() {
        super(2); // Define a velocidade das maçãs douradas como 2
        // Redimensiona a imagem da maçã dourada
        GreenfootImage imagem = getImage();
        imagem.scale(imagem.getWidth() / 2, imagem.getHeight() / 2); // Reduz o tamanho pela metade
        setImage(imagem);
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     * Faz a fruta realizar suas ações.
     */
    public void act() {
        super.act(); // Chama o método act da superclasse Fruta

        // Verifica se a maçã dourada atingiu o chão e não foi coletada
        if (getY() >= getWorld().getHeight() - 245) {
            World mundo = getWorld();

            // Verifica se o mundo é uma instância de CenarioFase2
            if (mundo instanceof CenarioFase2) {
                CenarioFase2 cenarioFase2 = (CenarioFase2) mundo;
                Contador contador = cenarioFase2.getContador();
                contador.atualizarMacasBoasPerdidas(); // Atualiza a quantidade de maçãs douradas perdidas
            }

            getWorld().removeObject(this); // Remove a maçã dourada do mundo
        }
    }
}