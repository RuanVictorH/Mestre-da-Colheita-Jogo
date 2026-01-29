import greenfoot.*; // Importa as classes Greenfoot

/**
 * Classe Ladrao (subclasse de Actor)
 * 
 * Esta classe representa o ladrão que rouba maçãs douradas do coletor.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2025.01.20
 */
public class Ladrao extends Actor {
    private GreenfootImage[] imagensRun; // Vetor para imagens "Run" (direita)
    private GreenfootImage[] imagensRunEspelhadas; // Vetor para imagens "Run" (esquerda)
    private int indiceImagemAtual = 0; // Índice atual da animação
    private int velocidade = 1; // Velocidade de movimento do ladrão
    private int contadorFrames = 0; // Temporizador para controlar a troca de frames
    private boolean olhandoDireita; // Direção atual do ladrão
    private Contador contador; // Contador para acessar as maçãs coletadas

    /**
     * Construtor da classe Ladrao.
     * 
     * @param contador O contador de pontuação do jogo.
     * @param olhandoDireita Define se o ladrão começa olhando para a direita.
     */
    public Ladrao(Contador contador, boolean olhandoDireita) {
        this.contador = contador;
        this.olhandoDireita = olhandoDireita;

        // Inicializa as imagens "Run" (direita)
        imagensRun = new GreenfootImage[8];
        for (int i = 0; i < imagensRun.length; i++) {
            imagensRun[i] = new GreenfootImage("run" + (i + 1) + ".png");
            imagensRun[i].scale(140, 160); // Redimensiona as imagens
        }

        // Inicializa as imagens "Run" espelhadas (esquerda)
        imagensRunEspelhadas = new GreenfootImage[8];
        for (int i = 0; i < imagensRunEspelhadas.length; i++) {
            imagensRunEspelhadas[i] = new GreenfootImage(imagensRun[i]);
            imagensRunEspelhadas[i].mirrorHorizontally(); // Espelha as imagens
        }

        // Define a imagem inicial com base na direção
        setImage(olhandoDireita ? imagensRun[0] : imagensRunEspelhadas[0]);
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     * Atualiza a animação e move o ladrão.
     */
    public void act() {
        mover();
        atualizarAnimacao();
        verificarColisaoComColetor();
    }

    /**
     * Move o ladrão de acordo com a direção atual.
     */
    private void mover() {
        if (olhandoDireita) {
            setLocation(getX() + velocidade, getY()); // Move para a direita
            // Inverte a direção ao atingir a borda direita
            if (getX() >= getWorld().getWidth() - 10) {
                inverterDirecao();
            }
        } else {
            setLocation(getX() - velocidade, getY()); // Move para a esquerda
            // Inverte a direção ao atingir a borda esquerda
            if (getX() <= 10) {
                inverterDirecao();
            }
        }
    }

    /**
     * Atualiza a animação do ladrão.
     */
    private void atualizarAnimacao() {
        // Seleciona o conjunto de imagens atual com base na direção
        GreenfootImage[] imagensAtuais = olhandoDireita ? imagensRun : imagensRunEspelhadas;

        // Alterna a imagem a cada 5 frames
        if (contadorFrames % 5 == 0) {
            indiceImagemAtual = (indiceImagemAtual + 1) % imagensAtuais.length;
            setImage(imagensAtuais[indiceImagemAtual]);
        }
        contadorFrames++;
    }

    /**
     * Verifica se o ladrão colidiu com o coletor.
     */
    private void verificarColisaoComColetor() {
        Actor coletor = getOneIntersectingObject(Coletor.class);
        if (coletor != null) {
            Coletor c = (Coletor) coletor;

            // Só rouba maçãs se o coletor estiver no chão
            if (!c.estaPulando()) {
                // Rouba 5 maçãs douradas ou zera, se o coletor tiver menos de 5
                int macasColetadas = contador.getMacasBoas();
                if (macasColetadas >= 5) {
                    contador.atualizarMacasBoas(-5); // Reduz 5 maçãs
                } else {
                    contador.atualizarMacasBoas(-macasColetadas); // Zera as maçãs
                }

                // Remove o ladrão após roubar as maçãs
                getWorld().removeObject(this);
            }
        }
    }

    /**
     * Inverte a direção do ladrão.
     */
    public void inverterDirecao() {
        olhandoDireita = !olhandoDireita;
    }
}
           
