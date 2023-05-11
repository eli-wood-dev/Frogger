import greenfoot.*;
/**
 * Clickable interface
 * 
 * @author Eli Wood
 * @version 1
 */
public interface Clickable{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    
    //use this for what happens when the mouse ir clicked
    public void onClick();
    
}
