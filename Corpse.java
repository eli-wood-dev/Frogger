import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Left behind when the player dies
 * 
 * @author Eli Wood 
 * @version 1
 */
public class Corpse extends Actor
{
    int timer;
    GreenfootImage corpse;
    
    /**
     * empty constructor
     * 
     * @author Eli Wood
     */
    public Corpse(){
        
    }
    
    /**
     * setter for the x
     * 
     * @author Eli Wood
     * @param x the new x
     */
    public void setX(int x){
        setLocation(x, getY());
    }
    
    /**
     * setter for the y
     * 
     * @author Eli Wood
     * @param y the new y
     */
    public void setY(int y){
        setLocation(getX(), y);
    }
    
    /**
     * Act - do whatever the Corpse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if(corpse == null){
            corpse = getImage();
        }
        if(timer%1 == 0 && corpse.getTransparency() >= 0){
            fade();
        }
        
        timer++;
    }
    
    /**
     * makes the corpse 1 point more transparent
     * 
     * @author Eli Wood
     */
    public void fade(){
        corpse.setTransparency(corpse.getTransparency() - 1);
    }
    
    /**
     * getter for the transparency
     * 
     * @author Eli Wood
     * @return the corpse's transparency
     */
    public int getTransparency(){
        return corpse.getTransparency();
    }
}
