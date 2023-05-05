import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Log extends Car{
    public Log(double speed, GreenfootImage image){
        super(speed, image);
    }
    
    public Log(double speed, GreenfootImage image, int yOffset){
        super(speed, image, yOffset);
    }
    
    public Log(){
        super();
    }
    
    public Log(double speed, GreenfootImage image, int width, int height){
        super(speed, image, width, height);
    }
    
    public Log(double speed, GreenfootImage image, int width, int height, int yOffset){
        super(speed, image, width, height, yOffset);
    }

    @Override
    protected void checkCollision(){
        //save the player
        if(intersects(world.getFrog())){
            world.getFrog().setLocation(getX(), world.getFrog().getY());
            touchingFrog = true;
        } else{
            touchingFrog = false;
        }
    }
}
