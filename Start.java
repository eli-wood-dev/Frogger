import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The start screen for the game
 * 
 * @author Eli Wood
 * @version 1
 */
public class Start extends World
{
    Game game;
    UIElement title;

    /**
     * Constructor
     * 
     * @author Eli Wood
     * 
     */
    public Start(Game game)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 500, 1); 
        showText("Press space to start", getWidth()/2, getHeight()/2);
        this.game = game;
        title = new UIElement(new GifImage("title.gif"));
        addObject(title, getWidth()/2, getHeight()/2 - 50);
        
    }
    
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        showText("Press space to start", getWidth()/2, getHeight()/2);
        
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(game);
        }
    }
}
