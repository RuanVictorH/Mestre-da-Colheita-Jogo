import greenfoot.*;  // Importa as classes necessárias do Greenfoot

/**
 * Classe CenarioFase2 (subclasse de World)
 * 
 * Esta classe representa o cenário da segunda fase do jogo, que ocorre à noite.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.01.10
 */
public class CenarioFase2 extends World {
    private Contador contadorDeFrutas; // O contador de frutas
    private long tempoInicio; // Tempo de início da partida
    private int tempoProximoLadrao = 0; // Tempo para o próximo ladrão aparecer

    /**
     * Construtor para objetos da classe CenarioFase2.
     */
    public CenarioFase2() {    
        super(700, 700, 1); // Configuração do mundo: 700 pixels de largura, 700 de altura, e 1x escala

        // Define o fundo do cenário (noite)
        setBackground("noite.png");

        // Cria o contador e o adiciona ao mundo
        contadorDeFrutas = new Contador();
        addObject(contadorDeFrutas, 350, 20); // Posição do contador no mundo (centralizado)

        // Toca a música tema do menu
        ControlaSom.getcontrole().tocarSomDeFundoFase2();

        preparar(); // Prepara o cenário inicial

        // Registra o tempo de início da partida
        tempoInicio = System.currentTimeMillis();
        
        // Ajusta o número de maçãs necessárias para vencer na fase 2
        contadorDeFrutas.ajustarParaFase2();
    }

    /**
     * Prepara o cenário inicial do jogo, adicionando o jogador.
     */
    private void preparar() {
        // Adiciona o personagem no centro inferior do mundo
        Coletor coletor = new Coletor(contadorDeFrutas);
        addObject(coletor, getWidth() / 2, getHeight() - 230);
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
     * Gera maçãs douradas, frutas podres e ladrões aleatoriamente.
     */
    public void act() {
        // Gera duas maçãs douradas a cada 200 maçãs
        if (Greenfoot.getRandomNumber(300) < 2) {
            addMacaDourada();
        }

        // Gera uma maçã podre a cada 400 maçãs
        if (Greenfoot.getRandomNumber(400) < 1) {
            addFrutaPodre();
        }

        // Gera um ladrão de tempos em tempos
        if (tempoProximoLadrao <= 0) {
            gerarLadrao();
            tempoProximoLadrao = Greenfoot.getRandomNumber(300) + 200;
        } else {
            tempoProximoLadrao--;
        }
    }

    /**
     * Adiciona uma maçã dourada ao mundo em uma posição aleatória no topo.
     */
    private void addMacaDourada() {
        MacaDourada macaDourada = new MacaDourada();
        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(macaDourada, x, 0);
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
     * Adiciona um ladrão ao mundo.
     */
    private void gerarLadrao() {
        // Verifica se já existe um ladrão no mundo
        if (getObjects(Ladrao.class).isEmpty()) {
            // Escolhe aleatoriamente o lado de geração (esquerda ou direita)
            boolean gerarDaEsquerda = Greenfoot.getRandomNumber(2) == 0;
            int x = gerarDaEsquerda ? 0 : getWidth();
            int y = getHeight() - 235;

            // Gera um novo ladrão
            Ladrao ladrao = new Ladrao(contadorDeFrutas, !gerarDaEsquerda); // Usa contadorDeFrutas
            addObject(ladrao, x, y);
        }
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