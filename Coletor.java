import greenfoot.*; // Importa as classes Greenfoot

/**
 * Classe Coletor (subclasse de Actor)
 * 
 * Esta classe representa o personagem que coleta itens (como maçãs),
 * com funcionalidades de movimento, pulo, animação e colisões.
 * 
 * @author Alex, Pedro e Ruan
 * @version 2024.12.08
 */
public class Coletor extends Actor {
    private int velocidadeMovimento = 7; // Velocidade padrão de movimento
    private Contador contador; // Contador para exibir as informações
    private boolean jogoEncerrado = false; // Indica se o jogo terminou

    // Variáveis para animação
    private GreenfootImage[] imagensIdle; // Vetor para imagens "Idle" (Parado)
    private GreenfootImage[] imagensIdleEspelhadas; // Vetor para imagens "Idle" espelhadas
    private GreenfootImage[] imagensRun; // Vetor para imagens "Run" (Correndo)
    private GreenfootImage[] imagensRunEspelhadas; // Vetor para imagens "Run" espelhadas
    private GreenfootImage[] imagensJump; // Vetor para imagens "Jump" (Pulando)
    private GreenfootImage[] imagensJumpEspelhadas; // Vetor para imagens "Jump" espelhadas
    private int indiceImagemAtual = 0; // Índice atual da animação
    private boolean emMovimento = false; // Estado do movimento
    private boolean olhandoDireita = true; // Direção atual do personagem
    private int contadorFrames = 0; // Temporizador para controlar a troca de frames

    // Variáveis para controle do pulo
    private boolean pulando = false; // Indica se o personagem está pulando
    private int forcaPulo = 20; // Força inicial do pulo
    private int gravidade = 1; // Força da gravidade
    private int impulsoHorizontal = 4; // Impulso horizontal durante o pulo

    /**
     * Construtor da classe Coletor.
     * 
     * @param contador O contador de pontuação do jogo.
     */
    public Coletor(Contador contador) {
        this.contador = contador;

        // Inicializa as imagens "Idle"
        imagensIdle = new GreenfootImage[10];
        imagensIdleEspelhadas = new GreenfootImage[10];
        for (int i = 0; i < imagensIdle.length; i++) {
            imagensIdle[i] = new GreenfootImage("Idle (" + (i + 1) + ").png");
            imagensIdle[i].scale(120, 140);

            // Cria as imagens espelhadas
            imagensIdleEspelhadas[i] = new GreenfootImage(imagensIdle[i]);
            imagensIdleEspelhadas[i].mirrorHorizontally();
        }

        // Inicializa as imagens "Run"
        imagensRun = new GreenfootImage[8];
        imagensRunEspelhadas = new GreenfootImage[8];
        for (int i = 0; i < imagensRun.length; i++) {
            imagensRun[i] = new GreenfootImage("Run (" + (i + 1) + ").png");
            imagensRun[i].scale(120, 140);

            // Cria as imagens espelhadas
            imagensRunEspelhadas[i] = new GreenfootImage(imagensRun[i]);
            imagensRunEspelhadas[i].mirrorHorizontally();
        }

        // Inicializa as imagens "Jump"
        imagensJump = new GreenfootImage[12];
        imagensJumpEspelhadas = new GreenfootImage[12];
        for (int i = 0; i < imagensJump.length; i++) {
            imagensJump[i] = new GreenfootImage("Jump (" + (i + 1) + ").png");
            imagensJump[i].scale(120, 140);

            // Cria as imagens espelhadas
            imagensJumpEspelhadas[i] = new GreenfootImage(imagensJump[i]);
            imagensJumpEspelhadas[i].mirrorHorizontally();
        }

        // Define a imagem inicial
        setImage(imagensIdle[0]);
    }

    /**
     * Método chamado a cada ato ou quando o botão "Run" é pressionado no Greenfoot.
     * Atualiza o movimento, pulo, gravidade e animação do coletor.
     */
    public void act() {
        if (jogoEncerrado) return;

        verificarMovimento();
        verificarPulo();
        aplicarGravidade();
        aplicarImpulsoHorizontal();
        verificarColisoes();
        atualizarAnimacao();
    }

    /**
     * Verifica se o coletor deve se mover.
     */
    private void verificarMovimento() {
        if (Greenfoot.isKeyDown("left")) {
            moverEsquerda();
        }
        if (Greenfoot.isKeyDown("right")) {
            moverDireita();
        }
    }

    /**
     * Move o coletor para a esquerda e atualiza a direção.
     */
    private void moverEsquerda() {
        move(-velocidadeMovimento);
        olhandoDireita = false;
    }

    /**
     * Move o coletor para a direita e atualiza a direção.
     */
    private void moverDireita() {
        move(velocidadeMovimento);
        olhandoDireita = true;
    }

    /**
     * Verifica se o coletor deve pular.
     */
    private void verificarPulo() {
        if (Greenfoot.isKeyDown("up") && !pulando && getY() >= getWorld().getHeight() - 245) {
            pulando = true;
            forcaPulo = 20; // Atualiza a força do pulo
        }
    }

    /**
     * Aplica a gravidade ao coletor.
     */
    private void aplicarGravidade() {
        if (pulando) {
            setLocation(getX(), getY() - forcaPulo); // Move o coletor para cima
            forcaPulo -= gravidade; // Reduz a força do pulo

            // Verifica se o coletor atingiu o chão
            if (getY() >= getWorld().getHeight() - 210) {
                setLocation(getX(), getWorld().getHeight() - 210); // Coloca o coletor no chão
                pulando = false; // Finaliza o pulo
            }
        }
    }

    /**
     * Aplica o impulso horizontal durante o pulo.
     */
    private void aplicarImpulsoHorizontal() {
        if (pulando) {
            if (olhandoDireita) {
                setLocation(getX() + impulsoHorizontal, getY()); // Impulso para a direita
            } else {
                setLocation(getX() - impulsoHorizontal, getY()); // Impulso para a esquerda
            }
        }
    }

    /**
     * Verifica colisões do coletor com maçãs e maçãs douradas.
     */
    private void verificarColisoes() {
        // Verifica a colisão com maçãs boas
        Actor maca = getOneIntersectingObject(Maca.class);
        if (maca != null) {
            getWorld().removeObject(maca);
            contador.atualizarMacasBoas(1);  // Incrementa o contador de maçãs boas
            ControlaSom.getcontrole().tocarsomJogo(1); // Efeito sonoro

            // Verifica a condição de vitória
            if (contador.getMacasBoas() >= contador.getMacasNecessarias()) {
                ganhar();
            }
        }

        // Verifica a colisão com maçãs douradas (apenas na fase 2)
        Actor macaDourada = getOneIntersectingObject(MacaDourada.class);
        if (macaDourada != null) {
            getWorld().removeObject(macaDourada);
            contador.atualizarMacasBoas(1);  // Incrementa o contador de maçãs boas
            ControlaSom.getcontrole().tocarsomJogo(1); // Efeito sonoro

            // Verifica a condição de vitória
            if (contador.getMacasBoas() >= contador.getMacasNecessarias()) {
                ganhar();
            }
        }

        // Verifica a colisão com maçãs podres
        Actor macaPodre = getOneIntersectingObject(MacaPodre.class);
        if (macaPodre != null) {
            getWorld().removeObject(macaPodre);
            contador.atualizarMacasPodres(1);  // Incrementa o contador de maçãs podres
            ControlaSom.getcontrole().tocarsomJogo(4); // Efeito sonoro

            // Aumenta a pontuação necessária para vencer em 10
            contador.atualizarMacasNecessarias(10);

            // Verifica se o jogador coletou 3 maçãs podres
            if (contador.getMacasPodres() >= 3) {
                morrer();
            }
        }
    }

    /**
     * Atualiza a animação do coletor.
     */
    private void atualizarAnimacao() {
        // Verifica se o coletor está se movendo
        boolean estavaEmMovimento = emMovimento; // Guarda o estado anterior
        emMovimento = Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right"); // Atualiza o estado atual

        // Seleciona o conjunto de imagens atual com base no estado de movimento e direção
        GreenfootImage[] imagensAtuais;
        if (pulando) {
            imagensAtuais = olhandoDireita ? imagensJump : imagensJumpEspelhadas;
        } else {
            imagensAtuais = emMovimento 
                ? (olhandoDireita ? imagensRun : imagensRunEspelhadas) 
                : (olhandoDireita ? imagensIdle : imagensIdleEspelhadas);
        }

        // Alterna a imagem a cada 5 frames
        if (contadorFrames % 5 == 0) {
            indiceImagemAtual = (indiceImagemAtual + 1) % imagensAtuais.length;
            setImage(imagensAtuais[indiceImagemAtual]);
        }
        contadorFrames++;
    }

    /**
     * Método que termina o jogo quando o coletor morre.
     */
    public void morrer() {
        jogoEncerrado = true; // Sinaliza que o jogo terminou
        World mundo = getWorld();

        // Verifica o tipo de mundo para passar os parâmetros corretos
        if (mundo instanceof Cenario) {
            Cenario cenario = (Cenario) mundo;
            Greenfoot.setWorld(new MundoFinal(false, contador.getMacasBoas(), cenario.getTempoInicio(), 1));
        } else if (mundo instanceof CenarioFase2) {
            CenarioFase2 cenarioFase2 = (CenarioFase2) mundo;
            Greenfoot.setWorld(new MundoFinal(false, contador.getMacasBoas(), cenarioFase2.getTempoInicio(), 2));
        }

        ControlaSom.getcontrole().pararSomDeFundo(); // Para o som de fundo 
        ControlaSom.getcontrole().tocarsomJogo(2); // Toca o som de GameOver
    }

    /**
     * Método que termina o jogo quando o coletor vence.
     */
    private void ganhar() {
        jogoEncerrado = true; // Sinaliza que o jogo terminou
        World mundo = getWorld();

        // Verifica o tipo de mundo para passar os parâmetros corretos
        if (mundo instanceof Cenario) {
            Cenario cenario = (Cenario) mundo;
            Greenfoot.setWorld(new MundoFinal(true, contador.getMacasBoas(), cenario.getTempoInicio(), 1));
        } else if (mundo instanceof CenarioFase2) {
            CenarioFase2 cenarioFase2 = (CenarioFase2) mundo;
            Greenfoot.setWorld(new MundoFinal(true, contador.getMacasBoas(), cenarioFase2.getTempoInicio(), 2));
        }

        ControlaSom.getcontrole().pararSomDeFundo(); // Para o som de fundo
        ControlaSom.getcontrole().tocarsomJogo(3); // Toca o som da Vitória
    }

    /**
     * Verifica se o coletor está pulando.
     * 
     * @return true se o coletor estiver pulando, false caso contrário.
     */
    public boolean estaPulando() {
        return pulando;
    }
}