import greenfoot.*;    // Importa as classes necessárias do Greenfoot
import java.util.ArrayList; // Importa a classe ArrayList

/**
 * Classe ControlaSom
 * 
 * Esta classe é responsável por gerenciar todos os sons do jogo, incluindo
 * músicas de fundo e efeitos sonoros.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2024.12.15
 */
public class ControlaSom  
{
    private static ControlaSom controle; // Instância única da classe
    private ArrayList<GreenfootSound> somMenu; // ArrayList de sons do menu
    private ArrayList<GreenfootSound> somJogo; // ArrayList de sons do jogo

    /**
     * Construtor para objetos da classe ControlaSom.
     */
    public ControlaSom()
    {
        inicializarSons();
    }

    /**
     * Inicializa os sons para o menu e para o jogo.
     */
    private void inicializarSons() {
        // ArrayList responsável pelos sons do menu
        somMenu = new ArrayList<>();
        adicionarSom("som-menu.wav", 35, somMenu);
        adicionarSom("som-descricao.mp3", 35, somMenu);
        adicionarSom("som-ajuda.mp3", 35, somMenu);

        // ArrayList responsável pelos efeitos sonoros do jogo
        somJogo = new ArrayList<>();
        adicionarSom("som-cenario.mp3", 40, somJogo);
        adicionarSom("pegar-maca.mp3", 20, somJogo);
        adicionarSom("gameover.mp3", 20, somJogo);
        adicionarSom("vitoria.wav", 20, somJogo);
        adicionarSom("pegar-macapodre.mp3", 20, somJogo);
        adicionarSom("som-fase2.mp3", 40, somJogo);
    }
         
    /**
     * Adiciona um som à lista especificada com o volume definido.
     * 
     * @param arquivo Nome do arquivo de som.
     * @param volume Volume do som.
     * @param lista ArrayList onde o som será adicionado.
     */
    private void adicionarSom(String arquivo, int volume, ArrayList<GreenfootSound> lista) {
        GreenfootSound som = new GreenfootSound(arquivo);
        som.setVolume(volume); // Define o volume do som
        lista.add(som);
    }

    /**
     * Retorna a instância única de ControlaSom.
     * 
     * @return A instância única de ControlaSom.
     */
    public static ControlaSom getcontrole() {
        if (controle == null) {
            controle = new ControlaSom(); // Se for nula, cria uma nova instância
        }
        return controle;
    }

    /**
     * Toca a música do menu em loop.
     * 
     * @param indice Índice da música na lista de sons do menu.
     */
    public void tocarMusicasMenu(int indice) {
        pararTodosOsSons();
        somMenu.get(indice).playLoop();
    }

    /**
     * Para todos os sons do menu.
     */
    public void pararSomMenu() {
        pararTodosOsSons();
    }

    /**
     * Toca o som de fundo da fase 1 em loop.
     */
    public void tocarSomDeFundo() {
        somJogo.get(0).playLoop();
    }

    /**
     * Toca o som de fundo da fase 2 em loop.
     */
    public void tocarSomDeFundoFase2() {
        somJogo.get(5).playLoop();
    }

    /**
     * Toca um som específico do jogo.
     * 
     * @param indice Índice do som na lista de sons do jogo.
     */
    public void tocarsomJogo(int indice) {
        somJogo.get(indice).play();
    }

    /**
     * Para o som de fundo do jogo.
     */
    public void pararSomDeFundo() { 
        somJogo.get(0).stop(); // Para a música na fase 1
        somJogo.get(5).stop(); // Para a música na fase 2
    }
   
    /**
     * Para todos os sons, tanto do menu quanto do jogo.
     */
    private void pararTodosOsSons() {
        for (GreenfootSound som : somMenu) {
            som.stop();
        }
        for (GreenfootSound som : somJogo) {
            som.stop();
        }
    }
}

