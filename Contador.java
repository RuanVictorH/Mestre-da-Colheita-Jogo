import greenfoot.*;    // Importa as classes necessárias do Greenfoot

/**
 * Classe Contador (subclasse de Actor)
 * 
 * Esta classe é responsável por manter e atualizar a contagem de maçãs coletadas,
 * perdidas e podres.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.12.08
 */
public class Contador extends Actor {
    private int macasBoas = 0; // Contador de maçãs boas
    private int macasBoasPerdidas = 0; // Contador de maçãs boas perdidas
    private int macasPodres = 0; // Contador de maçãs podres
    private int macasNecessarias = 30; // Pontuação necessária para vencer (inicialmente 30 para a fase 1)
    private int limiteMacasPerdidas = 10; // Limite de maçãs perdidas para perder o jogo
    private GreenfootImage image;

    /**
     * Construtor da classe Contador.
     * Inicializa a imagem do contador e atualiza o texto.
     */
    public Contador() {
        image = new GreenfootImage(200, 30);
        setImage(image);
        atualizarTexto(); // Inicializa o contador
    }

    /**
     * Atualiza a quantidade de maçãs boas perdidas.
     */
    public void atualizarMacasBoasPerdidas() {
        this.macasBoasPerdidas++;
        atualizarTexto();
        verificarDerrota();
    }

    /**
     * Verifica se o jogador perdeu o jogo.
     */
    private void verificarDerrota() {
    if (macasBoasPerdidas >= limiteMacasPerdidas) {
        World mundo = getWorld();
        if (mundo != null) {
            // Verifica se a lista não está vazia antes de tentar pegar o primeiro item
            java.util.List<Coletor> coletores = mundo.getObjects(Coletor.class);
            if (!coletores.isEmpty()) {
                Coletor coletor = coletores.get(0);
                coletor.morrer(); 
            }
        }
    }
}

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     * Atualiza o texto no contador a cada ciclo.
     */
    public void act() {
        atualizarTexto(); 
    }

    /**
     * Atualiza a quantidade de maçãs boas.
     * 
     * @param incremento Quantidade a ser incrementada nas maçãs boas.
     */
    public void atualizarMacasBoas(int incremento) {
        this.macasBoas += incremento; 
    }

    /**
     * Atualiza o número de maçãs podres.
     * 
     * @param incremento Quantidade a ser incrementada nas maçãs podres.
     */
    public void atualizarMacasPodres(int incremento) {
        this.macasPodres += incremento; 
    }

    /**
     * Atualiza a pontuação necessária para vencer.
     * 
     * @param incremento Quantidade a ser incrementada na pontuação necessária.
     */
    public void atualizarMacasNecessarias(int incremento) {
        this.macasNecessarias += incremento;
    }

    /**
     * Atualiza a imagem do contador com as informações.
     */
    private void atualizarTexto() {
        String texto = "Boas: " + macasBoas + " Perdidas: " + macasBoasPerdidas + " Podres: " + macasPodres + " Necessárias: " + macasNecessarias;

        // Limpa a imagem antes de desenhar o novo texto
        image.clear();

        // Define uma fonte branca para o texto
        GreenfootImage tempImage = new GreenfootImage(texto, 20, Color.WHITE, new Color(0, 0, 0, 0)); // Tamanho da fonte 20, cor branca, fundo transparente

        // Redimensiona a imagem principal para caber o texto
        image.scale(tempImage.getWidth() + 10, tempImage.getHeight() + 5);

        // Desenha o texto na imagem principal
        image.drawImage(tempImage, 5, 5); // Adiciona um pequeno espaçamento
    }

    /**
     * Ajusta o numero de maçãs necessárias para vencer na fase 2
     */
    public void ajustarParaFase2() {
        macasNecessarias = 20; // Define o limite de maçãs douradas para vencer como 20
    }

    // Getters
    /**
     * Acessa a quantidade de maçãs boas.
     * 
     * @return A quantidade de maçãs boas.
     */
    public int getMacasBoas() {
        return macasBoas;
    }

    /**
     * Acessa a quantidade de maçãs boas perdidas.
     * 
     * @return A quantidade de maçãs boas perdidas.
     */
    public int getMacasBoasPerdidas() {
        return macasBoasPerdidas;
    }

    /**
     * Acessa a quantidade de maçãs podres.
     * 
     * @return A quantidade de maçãs podres.
     */
    public int getMacasPodres() {
        return macasPodres;
    }

    /**
     * Acessa a quantidade de maçãs necessárias para vencer.
     * 
     * @return A quantidade de maçãs necessárias.
     */
    public int getMacasNecessarias() {
        return macasNecessarias;
    }
}

