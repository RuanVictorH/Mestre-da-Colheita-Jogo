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
        super(700, 700, 1); // Cria um novo mundo com 700x700 células com o tamanho da célula de 1x1 pixels.
        GreenfootImage imagemFundo = new GreenfootImage(getWidth(), getHeight()); // Cria uma nova imagem com as dimensões do mundo
        setBackground("imagem-descricao.png"); // Imagem com a história do jogo
        controlaSom = ControlaSom.getcontrole();
        controlaSom.tocarMusicasMenu(1); // Toca a música de fundo

        // Adiciona o texto com as instruções do jogo
        imagemFundo = getBackground(); 
        String instrucoes = "Mestre da Colheita\n\n" +
                            "Fase 1:\n" +
                            "- Colete 30 maçãs boas para vencer.\n" +
                            "- Cada maçã podre coletada aumenta a meta em +10.\n" +
                            "- Se perder 10 maçãs boas ou pegar 3 maçãs podres: Game Over.\n\n" +
                            "Fase 2:\n" +
                            "- Colete 20 maçãs douradas para vencer.\n" +
                            "- Cuidado com o Ladrão! Ele rouba 5 maçãs douradas ao tocá-lo.\n" +
                            "- Cada maçã podre coletada aumenta a meta em +10.\n" +
                            "- Se perder 10 maçãs douradas ou pegar 3 maçãs podres: Game Over.\n\n" +
                            "Pontuação:\n" +
                            "- Maçãs Boas/Douradas: Quantidade coletada.\n" +
                            "- Maçãs Perdidas: Quantidade deixada cair.\n" +
                            "- Maçãs Podres: Quantidade coletada (penalidade).\n\n" +
                            "Dicas:\n" +
                            "- Use o pulo (↑) para evitar maçãs podres e o Ladrão.\n" +
                            "- Fique atento às metas e penalidades!\n\n" +
                            "Pressione Backspace para voltar ao menu principal.";

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

