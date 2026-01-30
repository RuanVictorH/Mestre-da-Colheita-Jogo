import greenfoot.*;   // Importa as classes necessárias do Greenfoot

/**
 * Classe Ajuda (subclasse de World)
 * 
 * Esta classe exibe os comandos e instruções básicas para jogar o jogo.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2024.12.10
 */
public class Ajuda extends World
{   
    private ControlaSom controlaSom;

    /**
     * Construtor para objetos da classe Ajuda.
     * Define o tamanho do mundo e inicializa os componentes.
     */
    public Ajuda()
    {    
        super(1200, 655, 1); // Cria um novo mundo com 700x700 células com o tamanho da célula de 1x1 pixels.
        GreenfootImage imagemFundo = new GreenfootImage(getWidth(), getHeight()); // Cria uma nova imagem com as dimensões do mundo
        setBackground("Tela_Ajuda.jpg"); // Imagem de fundo
        controlaSom = ControlaSom.getcontrole();
        controlaSom.tocarMusicasMenu(2); // Toca a música de fundo

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


