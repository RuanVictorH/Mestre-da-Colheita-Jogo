import greenfoot.*;  // Importa as classes necessárias do Greenfoot

/**
 * Classe Cenario (subclasse de World)
 * 
 * Esta classe representa o cenário da primeira fase do jogo, que ocorre à tarde.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.01.08
 */
public class Cenario extends World {
    private Contador contadorDeFrutas; // O contador de frutas
    private long tempoInicio; // Tempo de início da partida

    /**
     * Construtor para objetos da classe Cenario.
     */
    public Cenario() {    
        super(700, 700, 1); // Configuração do mundo: 700 pixels de largura, 700 de altura, e 1x escala
        
        // Define o fundo do cenário (tarde)
        setBackground("tarde.png");

        // Cria o contador e o adiciona ao mundo
        contadorDeFrutas = new Contador();
        addObject(contadorDeFrutas, 350, 20); // Posição do contador no mundo (centralizado)

        // Toca a música tema do menu
        ControlaSom.getcontrole().tocarSomDeFundo();
        
        preparar(); // Prepara o cenário inicial

        // Registra o tempo de início da partida
        tempoInicio = System.currentTimeMillis();
    }

    /**
     * Prepara o cenário inicial do jogo, adicionando o jogador.
     */
    private void preparar() {
        // Adiciona o personagem no centro inferior do mundo
        Coletor coletor = new Coletor(contadorDeFrutas);
        addObject(coletor, getWidth() / 2, getHeight() - 245);
    }

    /**
     * Método para acessar o contador de frutas.
     * 
     * @return O contador de frutas.
     */
    public Contador getContador() {
        return contadorDeFrutas;
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     * Gera frutas boas e podres aleatoriamente.
     */
    public void act() {
        // Gera duas frutas boas a cada 200 frutas
        if (Greenfoot.getRandomNumber(200) < 2) {
            addFruta();
        }

        // Gera uma fruta podre a cada 200 frutas
        if (Greenfoot.getRandomNumber(200) < 1) {
            addFrutaPodre();
        }
    }

    /**
     * Adiciona uma maçã boa ao mundo em uma posição aleatória no topo.
     */
    private void addFruta() {
        Maca maca = new Maca();
        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(maca, x, 0);
    }

    /**
     * Adiciona uma maçã podre ao mundo em uma posição aleatória no topo.
     */
    private void addFrutaPodre() {
        MacaPodre macaPodre = new MacaPodre();
        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(macaPodre, x, 0);
    }

    /**
     * Método para acessar o tempo de início da partida.
     * 
     * @return O tempo de início da partida.
     */
    public long getTempoInicio() {
        return tempoInicio;
    }
}