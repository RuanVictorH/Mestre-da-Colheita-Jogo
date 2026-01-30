import greenfoot.*;    // Importa as classes necessárias do Greenfoot

/**
 * Classe Menu (subclasse de World)
 * 
 * Esta classe representa o menu inicial do jogo, onde o jogador pode
 * acessar outras partes do jogo, como iniciar, ajuda e descrição.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2024.12.08
 */
public class Menu extends World
{
    private ControlaSom controlaSom;

    /**
     * Construtor para objetos da classe Menu.
     * Define o tamanho do mundo e inicializa os componentes.
     */
    public Menu()
    {   
        super(1200, 655, 1); // Cria um novo mundo com 700x700 células com o tamanho da célula de 1x1 pixels.
        
        // Define a imagem de fundo
        setBackground("menu.png");
        
        // Inicia o controlador de som
        controlaSom = new ControlaSom();
        controlaSom.tocarMusicasMenu(0);
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     */
    public void act()
    {
        start();
    }

    /**
     * Inicia o jogo com base na tecla pressionada.
     * 'J' inicia o jogo, 'A' abre o menu de ajuda e 'D' abre a descrição do jogo.
     */
    public void start()
    {   
        // Faz os comandos escritos no menu serem possíveis
        if(Greenfoot.isKeyDown("j") || Greenfoot.isKeyDown("J"))
        {
            Greenfoot.setWorld(new Cenario());
            // A cada chamada troca de tela a música para
            controlaSom.pararSomMenu();
        }
        else if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("A"))
        {
            Greenfoot.setWorld(new Ajuda());
            controlaSom.pararSomMenu();
        }
        else if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("D"))
        {
            Greenfoot.setWorld(new Descricao());
            controlaSom.pararSomMenu();
        }
    }
    

}

