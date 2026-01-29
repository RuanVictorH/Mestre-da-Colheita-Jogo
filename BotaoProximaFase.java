import greenfoot.*;  // Importa as classes necessárias do Greenfoot

/**
 * Classe BotaoProximaFase (subclasse de Botao)
 * 
 * Esta classe representa um botão que leva o jogador para a próxima fase quando clicado.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.01.10
 */
public class BotaoProximaFase extends Botao {
    /**
     * Construtor da classe BotaoProximaFase.
     */
    public BotaoProximaFase() {
        super("Próxima Fase", 30, Color.WHITE, new Color(0, 0, 0, 0));
    }

    /**
     * Método que define a ação do botão ao ser clicado.
     */
    @Override
    public void aoClicar() {
        Greenfoot.setWorld(new CenarioFase2()); // Inicia a segunda fase
    }
}
