import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UIElement here.
 * 
 * @author Eli Wood
 * @version 1
 */
public class UIElement extends Actor
{
    private GifImage gif;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     * @param gif the gif for the ui element
     */
    public UIElement(GifImage gif){
        this.gif = gif;
        setImage(gif.getCurrentImage());
    }
    
    /**
     * Act - do whatever the UIElement wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(gif.getCurrentImage());
    }
}
