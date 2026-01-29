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
        super(700, 700, 1); // Cria um novo mundo com 700x700 células com o tamanho da célula de 1x1 pixels.
        GreenfootImage imagemFundo = new GreenfootImage(getWidth(), getHeight()); // Cria uma nova imagem com as dimensões do mundo
        setBackground("imagem-Ajuda(1).png"); // Imagem de fundo
        controlaSom = ControlaSom.getcontrole();
        controlaSom.tocarMusicasMenu(2); // Toca a música de fundo

        // Adiciona o texto com as instruções do jogo
        imagemFundo = getBackground(); 
        String instrucoes = "Bem-vindo ao Mestre da Colheita!\n\n" +
                            "Comandos:\n\n" +
                            "← (Seta Esquerda): Move o coletor para a esquerda.\n\n" +
                            "→ (Seta Direita): Move o coletor para a direita.\n\n" +
                            "↑ (Seta para Cima): Faz o coletor pular.\n\n" +
                            "Objetivo:\n\n" +
                            "Fase 1: Colete 30 maçãs boas para vencer.\n" +
                            "Fase 2: Colete 20 maçãs douradas para vencer.\n\n" +
                            "Cuidado:\n" +
                            "Maçãs podres aumentam a quantidade necessária para vencer.\n" +
                            "Evite perder muitas maçãs ou pegar muitas podres!\n\n" +
                            "Pressione Backspace para voltar ao menu principal.\n\n" +
                            "Boa sorte!";
        GreenfootImage texto = new GreenfootImage(instrucoes, 24, Color.WHITE, new Color(0, 0, 0, 128));
        int xTexto = (getWidth() - texto.getWidth()) / 2;
        int yTexto = (getHeight() - texto.getHeight()) / 2;
        imagemFundo.drawImage(texto, xTexto, yTexto);
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


