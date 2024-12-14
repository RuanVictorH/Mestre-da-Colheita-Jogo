import greenfoot.*;  // Importa as classes Greenfoot

/**
 * Classe Cenario - O mundo onde o jogo acontece.
 * Aqui configuramos o tamanho do mundo, adicionamos o personagem e geramos frutas e frutas podres.
 */
public class Cenario extends World {
    private Contador contadorDeFrutas; // O contador de frutas

    public Cenario() {    
        // Configuração do mundo: 600 pixels de largura, 400 de altura, e 1x escala
        super(600, 400, 1); 
        
        // Cria o contador e o adiciona ao mundo
        contadorDeFrutas = new Contador();
        addObject(contadorDeFrutas, 100, 20); // Posição do contador no mundo

        // Cria o personagem e passa o contador para ele
        Personagem personagem = new Personagem(contadorDeFrutas);
        addObject(personagem, 300, 350); // Posição do personagem
        preparar(); // Prepara o cenário inicial
    }

    private void preparar() {
        // Adiciona o personagem no centro inferior do mundo
        Personagem jogador = new Personagem(contadorDeFrutas);
        addObject(jogador, getWidth() / 2, getHeight() - 50);
    }

    public Contador getContador() {
        return contadorDeFrutas;  // Método para acessar o contador
    }

    public void act() {
        // Reduzimos a probabilidade de geração de frutas
        if (Greenfoot.getRandomNumber(200) < 2) {  // Menos chance (1 a cada 200)
            addFruta();
        }

        if (Greenfoot.getRandomNumber(200) < 1) {  // Menos chance (1 a cada 200)
            addFrutaPodre();
        }
    }

    private void addFruta() {
        Maca maca = new Maca();
        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(maca, x, 0); // Adiciona a fruta no topo, em uma posição aleatória
    }

    private void addFrutaPodre() {
        FrutaPodre frutaPodre = new FrutaPodre();
        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(frutaPodre, x, 0); // Adiciona a fruta podre no topo, em uma posição aleatória
    }
}
