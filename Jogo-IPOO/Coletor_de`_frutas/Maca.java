import greenfoot.*;  // Importa as classes Greenfoot

/**
 * Classe Fruta - Representa as frutas boas que o personagem deve coletar
 */
public class Maca extends Actor {
    private static int velocidade = 2; // Velocidade das frutas boas
    
    public Maca() {
        // Redimensiona a imagem para um tamanho menor
        GreenfootImage imagem = getImage();
        imagem.scale(imagem.getWidth() / 2, imagem.getHeight() / 2); // Reduz para metade do tamanho original
        setImage(imagem);
    }

    public void act() {
        cair(); // Faz a fruta cair

        // Verifica se a fruta atingiu o chão e não foi coletada
        if (getY() >= getWorld().getHeight() - 1) {
            Cenario cenario = (Cenario) getWorld();  // Acessa o mundo para chamar o contador
            Contador contador = cenario.getContador();  // Obtém o contador
            contador.atualizarFrutasBoasPerdidas();  // Atualiza a quantidade de frutas boas perdidas

            // Remove a fruta do mundo, pois ela atingiu o chão
            getWorld().removeObject(this);

            // Verifica se o número de frutas boas perdidas atingiu o limite de 50
            if (contador.getFrutasBoasPerdidas() >= 50) {
                Personagem personagem = (Personagem) getWorld().getObjects(Personagem.class).get(0);
                personagem.morrer(); // O personagem morre se perder 50 frutas boas
            }
        }
    }

    // Função para fazer a fruta cair
    private void cair() {
        setLocation(getX(), getY() + velocidade);  // Faz a fruta cair com a velocidade definida
    }

    // Função para aumentar a velocidade das frutas boas
    public static void aumentarVelocidade() {
        if (velocidade < 5) { // Limita a velocidade máxima
            velocidade++;
        }
    }
}


