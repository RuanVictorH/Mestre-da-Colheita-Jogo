import greenfoot.*;  // Importa as classes necessárias do Greenfoot

/**
 * Classe Cenario (subclasse de World)
 * * Esta classe representa o cenário da primeira fase do jogo, que ocorre à tarde.
 * * @author Alex, Pedro e Ruan
 * @version 2025.01.29
 */
public class Cenario extends World {
    private Contador contadorDeFrutas; // O contador de frutas
    private long tempoInicio; // Tempo de início da partida

    /**
     * Construtor para objetos da classe Cenario.
     */
    public Cenario() {    
        // Configuração do mundo: 1200 pixels de largura, 655 de altura, e 1x escala
        super(1200, 655, 1); 
        
        // Define o fundo do cenário (tarde)
        setBackground("Tela_Fase1.jpg");

        // Cria o contador e o adiciona ao mundo
        contadorDeFrutas = new Contador();
        addObject(contadorDeFrutas, getWidth() / 2, 30); // Posição do contador centralizada no topo

        // Toca a música tema
        ControlaSom.getcontrole().tocarSomDeFundo();
        
        preparar(); // Prepara o cenário inicial

        // Registra o tempo de início da partida
        tempoInicio = System.currentTimeMillis();
    }

    /**
     * Prepara o cenário inicial do jogo, adicionando o jogador.
     */
    private void preparar() {
        Coletor coletor = new Coletor(contadorDeFrutas);
        addObject(coletor, getWidth() / 2, getHeight() - 210); 
    }

/**
     * Método chamado a cada ato. 
     * Ajustado para um início mais calmo e progressão suave.
     */
    public void act() {
        int boas = contadorDeFrutas.getMacasBoas();

        // 1. Velocidade: Começa em 2, aumenta +1 a cada 5 maçãs. Máximo 8.
        int velCalculada = 2 + (boas / 5);
        if (velCalculada > 8) velCalculada = 8;

        // 2. Frequência Dinâmica (Escala de 1000):
        // Começa em 5 (0.5% de chance). A cada 5 maçãs, aumenta +2 na chance.
        // O limite de 25 garante que não passe de 2.5% de chance por ciclo.
        int chanceDeSpawn = 5 + (boas * 2 / 5);
        if (chanceDeSpawn > 25) chanceDeSpawn = 25; 

        // Gera maçãs boas
        if (Greenfoot.getRandomNumber(1000) < chanceDeSpawn) {
            addFruta(velCalculada);
        }

        // Gera maçãs podres (frequência fixa e baixa: 0.3% de chance)
        if (Greenfoot.getRandomNumber(1000) < 3) {
            addFrutaPodre(velCalculada);
        }
    }

    /**
     * Adiciona uma maçã boa ao mundo em uma posição aleatória no topo.
     * @param vel Velocidade calculada para a fruta.
     */
    private void addFruta(int vel) {
        Maca maca = new Maca(vel);
        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(maca, x, 0);
    }

    /**
     * Adiciona uma maçã podre ao mundo em uma posição aleatória no topo.
     * @param vel Velocidade calculada para a fruta.
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