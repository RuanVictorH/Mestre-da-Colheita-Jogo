import greenfoot.*;  // Importa as classes Greenfoot

/**
 * Classe Personagem - Representa o personagem jogável do jogo
 */
public class Personagem extends Actor {
    private int frutasBoas = 0; // Contagem de frutas boas coletadas
    private int frutasPodres = 0; // Contagem de frutas podres coletadas
    private Contador contador; // Contador para exibir as informações

    public Personagem(Contador contador) {
        this.contador = contador; // Recebe o contador
    }

    public void act() {
        if (Greenfoot.isKeyDown("left")) {
            move(-5); // Move para a esquerda
        }
        if (Greenfoot.isKeyDown("right")) {
            move(5); // Move para a direita
        }

        // Verifica a colisão com frutas boas
        Actor fruta = getOneIntersectingObject(Fruta.class);
        if (fruta != null) {
            getWorld().removeObject(fruta); // Remove a fruta
            frutasBoas++; // Incrementa a contagem de frutas boas
            contador.atualizarFrutasBoas(frutasBoas); // Atualiza o contador

            // Se coletou 3 frutas boas, aumenta a velocidade
            if (frutasBoas % 3 == 0) {
                Fruta.aumentarVelocidade(); // Aumenta a velocidade das frutas boas
                FrutaPodre.aumentarVelocidade(); // Aumenta a velocidade das frutas podres
            }
        }

        // Verifica a colisão com frutas podres
        Actor frutaPodre = getOneIntersectingObject(FrutaPodre.class);
        if (frutaPodre != null) {
            getWorld().removeObject(frutaPodre); // Remove a fruta podre
            frutasPodres++; // Incrementa a contagem de frutas podres
            contador.atualizarFrutasPodres(frutasPodres); // Atualiza o contador

            // Se coletou 3 frutas podres, morre
            if (frutasPodres >= 3) {
                morrer();
            }
        }

        // Verifica se o jogador pegou 50 frutas boas e morre
        if (contador.getFrutasBoasPerdidas() >= 20) {
            morrer();
        }
    }

    // Função para matar o personagem
    public void morrer() {
        World mundo = getWorld();
        mundo.removeObject(this); // Remove o personagem do mundo
        Greenfoot.stop(); // Para o jogo
    }
}
