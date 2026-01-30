import greenfoot.*;  // Importa as classes necessárias do Greenfoot

/**
 * Classe CenarioFase2 (subclasse de World)
 * * Esta classe representa o cenário da segunda fase do jogo, que ocorre à noite.
 * * @author Alex, Pedro e Ruan
 * @version 2026.01.29
 */
public class CenarioFase2 extends World {
    private Contador contadorDeFrutas; // O contador de frutas
    private long tempoInicio; // Tempo de início da partida
    private int tempoProximoLadrao = 0; // Tempo para o próximo ladrão aparecer

    /**
     * Construtor para objetos da classe CenarioFase2.
     */
    public CenarioFase2() {    
        // Configuração do mundo: 1238 pixels de largura, 700 de altura, e 1x escala
        super(1238, 700, 1); 

        // Define o fundo do cenário (noite)
        setBackground("noite.png");

        // Cria o contador e o adiciona ao mundo
        contadorDeFrutas = new Contador();
        addObject(contadorDeFrutas, getWidth() / 2, 30); // Posição centralizada no topo

        // Toca a música tema da fase 2
        ControlaSom.getcontrole().tocarSomDeFundoFase2();

        preparar(); // Prepara o cenário inicial

        // Registra o tempo de início da partida
        tempoInicio = System.currentTimeMillis();
        
        // Ajusta o número de maçãs necessárias para vencer na fase 2
        contadorDeFrutas.ajustarParaFase2();
    }

    private void preparar() {
        // Posicionamento original da Fase 2
        Coletor coletor = new Coletor(contadorDeFrutas);
        addObject(coletor, getWidth() / 2, getHeight() - 230);
    }
    
    private void gerarLadrao() {
        if (getObjects(Ladrao.class).isEmpty()) {
            boolean gerarDaEsquerda = Greenfoot.getRandomNumber(2) == 0;
            int x = gerarDaEsquerda ? 0 : getWidth();
            
            // Retornando o Ladrão para a altura de 235 pixels
            int y = getHeight() - 235; 
    
            Ladrao ladrao = new Ladrao(contadorDeFrutas, !gerarDaEsquerda);
            addObject(ladrao, x, y);
        }
    }

    /**
     * Método chamado a cada ato na Fase 2.
     * Aumenta a agressividade conforme o jogador progride.
     */
    public void act() {
        int boas = contadorDeFrutas.getMacasBoas();

        // Velocidade base da Fase 2: Começa em 3, Máximo 10.
        int velCalculada = 3 + (boas / 4);
        if (velCalculada > 10) velCalculada = 10;

        // Frequência Fase 2: Começa em 8 (0.8%). Aumenta +3 a cada 5 maçãs.
        int chanceDeSpawn = 8 + (boas * 3 / 5);
        if (chanceDeSpawn > 40) chanceDeSpawn = 40; // Limite de 4%

        // Gera maçãs douradas
        if (Greenfoot.getRandomNumber(1000) < chanceDeSpawn) {
            addMacaDourada(velCalculada);
        }

        // Gera maçãs podres (0.5% de chance fixa)
        if (Greenfoot.getRandomNumber(1000) < 5) {
            addFrutaPodre(velCalculada);
        }

        // Lógica do Ladrão
        if (tempoProximoLadrao <= 0) {
            gerarLadrao();
            tempoProximoLadrao = Greenfoot.getRandomNumber(300) + 200;
        } else {
            tempoProximoLadrao--;
        }
    }
    
    /**
     * Adiciona uma maçã dourada ao mundo com a velocidade calculada.
     */
    private void addMacaDourada(int vel) {
        MacaDourada macaDourada = new MacaDourada(vel);
        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(macaDourada, x, 0);
    }

    /**
     * Adiciona uma maçã podre ao mundo com a velocidade calculada.
     */
    private void addFrutaPodre(int vel) {
        MacaPodre macaPodre = new MacaPodre(vel);
        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(macaPodre, x, 0);
    }

    public Contador getContador() {
        return contadorDeFrutas;
    }

    public long getTempoInicio() {
        return tempoInicio;
    }
}