import greenfoot.*;   // Importa as classes necessárias do Greenfoot

/**
 * Classe Descricao (subclasse de World)
 * 
 * Esta classe exibe a história e objetivos do jogo para o jogador.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2024.12.10
 */
public class Descricao extends World
{
    private ControlaSom controlaSom;

    /**
     * Construtor para objetos da classe Descricao.
     * Define o tamanho do mundo e inicializa os componentes.
     */
    public Descricao()
    {
        super(1200, 700, 1); // Cria um novo mundo com 1200x700 células com o tamanho da célula de 1x1 pixels.
        GreenfootImage imagemFundo = new GreenfootImage(getWidth(), getHeight()); // Cria uma nova imagem com as dimensões do mundo
        setBackground("Tela_Descricao.jpg"); // Imagem com a história do jogo
        controlaSom = ControlaSom.getcontrole();
        controlaSom.tocarMusicasMenu(1); // Toca a música de fundo
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     */
    public void act()
    {
        voltar();
    }

    /**
     * Volta ao menu principal quando a tecla Backspace é pressionada.
     */
    public void voltar()
    {
        if (Greenfoot.isKeyDown("backspace"))
        {
            Greenfoot.setWorld(new Menu());
            controlaSom.pararSomMenu();
        }
    }
}

