import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UIElement here.
 * 
 * @author Eli Wood
 * @version 1
 */
public class UIElement extends SmoothMover
{
    private GifImage gif;
    private GreenfootImage image;
    
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
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     * @param image the image the ui element will use
     */
    public UIElement(GreenfootImage image){
        this.image = image;
        setImage(image);
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     */
    public UIElement(){
        
    }
    
    /**
     * Act - do whatever the UIElement wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if(gif != null){
            setImage(gif.getCurrentImage());
        }
        
    }
}
