import greenfoot.*;  // Importa as classes necessárias do Greenfoot

/**
 * Classe MundoFinal (subclasse de World)
 * 
 * Esta classe representa o mundo que aparece ao final do jogo, mostrando se o jogador venceu
 * ou perdeu, os pontos obtidos em cada fase, o total de pontos e o tempo de duração da partida.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.01.10
 */
public class MundoFinal extends World {
    private int pontosTotais; // Pontos totais obtidos pelo jogador
    private long tempoInicio; // Tempo de início da partida
    private long tempoFim; // Tempo de fim da partida
    private int fase; // Fase atual (1 para tarde, 2 para noite)

    /**
     * Construtor para objetos da classe MundoFinal.
     * 
     * @param vitoria Indica se o jogador venceu (true) ou perdeu (false).
     * @param pontosTotais Pontos totais obtidos pelo jogador.
     * @param tempoInicio Tempo de início da partida.
     * @param fase A fase atual (1 para tarde, 2 para noite).
     */
    public MundoFinal(boolean vitoria, int pontosTotais, long tempoInicio, int fase) {
        super(700, 700, 1); // Configuração do mundo: 700 pixels de largura, 700 de altura, e 1x escala
        
        this.pontosTotais = pontosTotais;
        this.tempoInicio = tempoInicio;
        this.tempoFim = System.currentTimeMillis();
        this.fase = fase;

        // Exibe a mensagem de vitória ou derrota
        String mensagem = vitoria ? "Você Venceu a Fase " + fase + "!" : "Game Over";
        exibirTexto(mensagem, 50, Color.WHITE, getWidth() / 2 + 10, getHeight() / 2 - 200);

        // Exibe os pontos totais
        exibirTexto("Pontos Totais: " + pontosTotais, 25, Color.WHITE, getWidth() / 2 + 10, getHeight() / 2 + 15);

        // Exibe o tempo de duração da partida
        long duracao = (tempoFim - tempoInicio) / 1000; // Converte para segundos
        exibirTexto("Tempo de Jogo: " + duracao + " segundos", 20, Color.WHITE, getWidth() / 2 + 20, getHeight() / 2 + 60);

        // Adiciona o botão para reiniciar o jogo
        addObject(new BotaoReiniciarJogo(), getWidth() / 2, getHeight() / 2 + 120);

        // Adiciona o botão para voltar ao menu
        addObject(new BotaoVoltarMenu(), getWidth() / 2, getHeight() / 2 + 180);

        // Se o jogador venceu a primeira fase, adiciona o botão para ir à segunda fase
        if (vitoria && fase == 1) {
            addObject(new BotaoProximaFase(), getWidth() / 2, getHeight() / 2 + 240);
        }
    }

    /**
     * Método auxiliar para exibir um texto no mundo.
     * 
     * @param texto O texto a ser exibido.
     * @param tamanhoFonte O tamanho da fonte do texto.
     * @param cor A cor do texto.
     * @param x A posição horizontal do texto.
     * @param y A posição vertical do texto.
     */
    private void exibirTexto(String texto, int tamanhoFonte, Color cor, int x, int y) {
        GreenfootImage imagemTexto = new GreenfootImage(texto, tamanhoFonte, cor, new Color(0, 0, 0, 0));
        Actor textoActor = new Actor() {};
        textoActor.setImage(imagemTexto);
        addObject(textoActor, x, y);
    }
}