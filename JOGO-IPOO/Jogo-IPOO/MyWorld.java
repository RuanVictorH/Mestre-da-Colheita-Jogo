import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe Menu.
 * 
 * @author (Alex, Pedro e Ruan) 
 * @version (07.12.2024)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1400, 700, 1); // Configura o mundo com dimensões 1500x700
        GreenfootImage imagemMenu = new GreenfootImage("Imagem-Menu.png"); // Carrega a imagem
        imagemMenu.scale(getWidth(), getHeight()); // Redimensiona para caber no mundo
        setBackground(imagemMenu); // Define a imagem como fundo
    }
}
