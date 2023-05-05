import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{
    Game game;
    
    /**
     * Constructor for objects of class End.
     * 
     */
    public End(Game game)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 500, 1); 
        showText("Game over", getWidth()/2, getHeight()/2 - 50);
        showText("Press space to start", getWidth()/2, getHeight()/2 + 50);
        this.game = game;
    }
    
    public void act(){
        showText("Game over", getWidth()/2, getHeight()/2 - 50);
        showText("Press space to start", getWidth()/2, getHeight()/2 + 50);
        
        if(Greenfoot.isKeyDown("space")){
            game.reset();
            Greenfoot.setWorld(game);
        }
    }
}
