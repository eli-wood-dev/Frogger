import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class for an item that can interact with the player
 * 
 * @author Eli Wood 
 * @version 1
 */
public class Item extends Thing
{
    /**
     * main act function
     * 
     * @author Eli Wood
     */
    public void act(){
        y = getY();
        x = getX();
        checkCollision();
        checkEdge();
    }
    
    public void moveTo(int x, int y){
        setLocation(x, y);
    }
    
    public void checkCollision(){
        if(intersects(world.getFrog())){
            
            
            isDead = true;
        }
    }
    
    public void checkEdge(){
        if(y < world.getHeight()){
            isDead = true;
        }
    }
}
