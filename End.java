import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends Menu
{    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     */
    public End(Game game)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(game); 
        showText("Game over", getWidth()/2, getHeight()/2 - 50);
        showText("Press space to start", getWidth()/2, getHeight()/2 + 50);
    }
    
    public void act(){
        showText("Game over", getWidth()/2, getHeight()/2 - 50);
        showText("Press space to start", getWidth()/2, getHeight()/2 + 50);
        
        if(Greenfoot.isKeyDown("space")){
            Game temp = (Game)world;
            temp.reset();
            Greenfoot.setWorld(temp);
        } else if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new Pause(this));
        }
    }
}
