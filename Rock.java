import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Thing
{
    protected boolean touchingFrog;
    
    public Rock(int yOffset){
        this.yOffset = yOffset;
        getImage().scale(50, 50);
    }
    
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(world == null){
            world = (Game)getWorld();
        }
        checkCollision();
        checkEdge();
    }
    
    protected void checkCollision(){
        if(intersects(world.getFrog())){
            world.getFrog().setLocation(getX(), world.getFrog().getY());
            touchingFrog = true;
        } else{
            touchingFrog = false;
        }
    }
    
    protected void checkEdge(){
        if(y > world.getHeight()){
            isDead = true;
        }
    }
    
    public boolean touchingFrog(){
        return touchingFrog;
    }
    
    public void moveTo(int x, int y){
        setLocation(x, y + yOffset);
    }
}
