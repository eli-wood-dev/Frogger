import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Thing
{
    /**
     * Act - do whatever the Item wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
