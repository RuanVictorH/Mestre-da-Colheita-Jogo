import greenfoot.*;  // Importa as classes necessárias do Greenfoot

/**
 * Classe BotaoVoltarMenu (subclasse de Botao)
 * 
 * Esta classe representa um botão que volta ao menu principal quando clicado.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.01.10
 */
public class BotaoVoltarMenu extends Botao {
    /**
     * Construtor da classe BotaoVoltarMenu.
     */
    public BotaoVoltarMenu() {
        super("Voltar ao Menu", 30, Color.WHITE, new Color(0, 0, 0, 0));
    }

    /**
     * Método que define a ação do botão ao ser clicado.
     */
    @Override
    public void aoClicar() {
        Greenfoot.setWorld(new Menu());
    }
}