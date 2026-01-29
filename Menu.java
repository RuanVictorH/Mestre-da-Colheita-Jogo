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
        super(700, 700, 1); // Cria um novo mundo com 700x700 células com o tamanho da célula de 1x1 pixels.
        
        // Define a imagem de fundo
        setBackground("menu.jpg");
        
        // Adiciona os textos ao menu
        adicionarTextoMenu();

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
    
    /**
     * Método usado para configurar os textos que aparecem no menu do jogo.
     */
    public void adicionarTextoMenu()
    {
        GreenfootImage imagemFundo = getBackground();
        
        // Informações dos desenvolvedores
        String desenvolvedores = "Desenvolvedores: Alex, Pedro e Ruan";
        GreenfootImage textoDesenvolvedores = new GreenfootImage(desenvolvedores, 20, Color.WHITE, new Color(0, 0, 0, 128));
        int xDesenvolvedores = (getWidth() - textoDesenvolvedores.getWidth()) / 2;
        int yDesenvolvedores = 100;
        imagemFundo.drawImage(textoDesenvolvedores, xDesenvolvedores, yDesenvolvedores);

        // Informações da disciplina
        String disciplina = "Introdução à Programação Orientada a Objetos (IPOO)";
        GreenfootImage textoDisciplina = new GreenfootImage(disciplina, 20, Color.WHITE, new Color(0, 0, 0, 128));
        int xDisciplina = (getWidth() - textoDisciplina.getWidth()) / 2;
        int yDisciplina = 130;
        imagemFundo.drawImage(textoDisciplina, xDisciplina, yDisciplina);

        // Período
        String periodo = "Período: 2024-2";
        GreenfootImage textoPeriodo = new GreenfootImage(periodo, 20, Color.WHITE, new Color(0, 0, 0, 128));
        int xPeriodo = (getWidth() - textoPeriodo.getWidth()) / 2;
        int yPeriodo = 160;
        imagemFundo.drawImage(textoPeriodo, xPeriodo, yPeriodo);

        // Instruções do jogo
        String instrucoes = "Pressione J para iniciar o Jogo.\n\n" +
                            "Pressione A para abrir o menu de Ajuda.\n\n" +
                            "Pressione D para ver a Descrição do jogo.";
        GreenfootImage textoInstrucoes = new GreenfootImage(instrucoes, 24, Color.WHITE, new Color(0, 0, 0, 128));
        int xInstrucoes = (getWidth() - textoInstrucoes.getWidth()) / 2;
        int yInstrucoes = getHeight() - 250; // Posição inferior
        imagemFundo.drawImage(textoInstrucoes, xInstrucoes, yInstrucoes);
    }
}

