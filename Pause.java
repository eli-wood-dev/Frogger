import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pause screen
 * 
 * @author Eli Wood
 * @version 1
 */
public class Pause extends Menu{
    UIElement title;
    
    /**
     * Constructor 
     * 
     * @author Eli Wood
     * @version 1
     */
    public Pause(World world){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(world); 
        
        showText("Press space to resume", getWidth()/2, getHeight()/2 - 100);
        
        title = new UIElement(new GifImage("title.gif"));
        addObject(title, getWidth()/2, getHeight()/2 - 150);
    }
    
    /**
     * main act function
     * 
     * @author Eli Wood
     * @version 1
     */
    public void act(){
        showText("Press space to resume", getWidth()/2, getHeight()/2 - 100);
        
        //add sliders for volume and buttons to mute
        
        if(Greenfoot.isKeyDown("space")){
            removeObject(title);
            Greenfoot.setWorld(world);
        }
    }
}
