import greenfoot.*;  // Importa as classes Greenfoot

/**
 * Classe Contador - Responsável por manter e atualizar a contagem de frutas coletadas e perdidas.
 */
public class Contador extends Actor {
    private int frutasBoas = 0; // Contador de frutas boas
    private int frutasBoasPerdidas = 0; // Contador de frutas boas perdidas
    private int frutasPodres = 0; // Contador de frutas podres
    private GreenfootImage image;

    public Contador() {
        image = new GreenfootImage(200, 30);
        setImage(image);
        atualizarTexto(); // Inicializa o contador
    }

    public void act() {
        atualizarTexto(); // Atualiza o texto no contador a cada ciclo
    }

    public void atualizarFrutasBoas(int frutasBoas) {
        this.frutasBoas = frutasBoas; // Atualiza a quantidade de frutas boas
    }

    public void atualizarFrutasBoasPerdidas() {
        this.frutasBoasPerdidas++; // Incrementa o número de frutas boas perdidas
    }

    public void atualizarFrutasPodres(int frutasPodres) {
        this.frutasPodres = frutasPodres; // Atualiza o número de frutas podres
    }

    private void atualizarTexto() {
        // Atualiza a imagem do contador com as informações
        String texto = "Boas: " + frutasBoas + " Perdidas: " + frutasBoasPerdidas + " Podres: " + frutasPodres;
        image.clear(); // Limpa a imagem antes de desenhar o novo texto
        image.drawString(texto, 10, 20); // Exibe o texto
    }

    // Métodos para acessar as contagens
    public int getFrutasBoas() {
        return frutasBoas;
    }

    public int getFrutasBoasPerdidas() {
        return frutasBoasPerdidas;
    }

    public int getFrutasPodres() {
        return frutasPodres;
    }
}
