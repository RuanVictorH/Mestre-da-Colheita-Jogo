import greenfoot.*;

/**
 * Classe MacaDourada (subclasse de Fruta)
 * * Esta classe representa as maçãs douradas que o jogador deve coletar na segunda fase.
 */
public class MacaDourada extends Fruta {
    /**
     * Construtor da classe MacaDourada.
     * @param vel Velocidade recebida do mundo.
     */
    public MacaDourada(int vel) {
        super(vel); // Agora a variável 'vel' é reconhecida e enviada para a classe Fruta
        
        // Redimensiona a imagem da maçã dourada para o novo padrão de tela
        GreenfootImage imagem = getImage();
        imagem.scale(50, 50); 
        setImage(imagem);
    }

    /**
     * Método chamado automaticamente pela superclasse Fruta quando a maçã toca o chão.
     */
    @Override
    protected void executarAcaoDePerda() {
        World mundo = getWorld();
        if (mundo instanceof CenarioFase2) {
            // Agora o contador só atualiza quando a fruta atingir os 245 pixels definidos na superclasse
            ((CenarioFase2) mundo).getContador().atualizarMacasBoasPerdidas(); 
        }
    }
}