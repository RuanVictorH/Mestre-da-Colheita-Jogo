import greenfoot.*;  // Importa as classes necessárias do Greenfoot

/**
 * Classe BotaoReiniciarJogo (subclasse de Botao)
 * 
 * Esta classe representa um botão que reinicia o jogo quando clicado.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.01.10
 */
public class BotaoReiniciarJogo extends Botao {
    /**
     * Construtor da classe BotaoReiniciarJogo.
     */
    public BotaoReiniciarJogo() {
        super("Reiniciar Jogo", 30, Color.WHITE, new Color(0, 0, 0, 0));
    }

    /**
     * Método que define a ação do botão ao ser clicado.
     */
    @Override
    public void aoClicar() {
        Greenfoot.setWorld(new Cenario());
    }
}
