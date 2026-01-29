import greenfoot.*;  // Importa as classes necessárias do Greenfoot

/**
 * Classe Botao (superclasse de Actor)
 * 
 * Esta classe representa um botão genérico que pode ser clicado.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.01.10
 */
public abstract class Botao extends Actor {
    /**
     * Construtor da classe Botao.
     * 
     * @param texto O texto exibido no botão.
     * @param tamanhoFonte O tamanho da fonte do texto.
     * @param corTexto A cor do texto.
     * @param corFundo A cor de fundo do botão.
     */
    public Botao(String texto, int tamanhoFonte, Color corTexto, Color corFundo) {
        GreenfootImage imagem = new GreenfootImage(texto, tamanhoFonte, corTexto, corFundo);
        setImage(imagem);
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     * Verifica se o botão foi clicado e executa a ação correspondente.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            aoClicar();
        }
    }

    /**
     * Método abstrato que define a ação do botão ao ser clicado.
     */
    public abstract void aoClicar();
}
