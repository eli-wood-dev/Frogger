import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * vehicle abstract class
 * 
 * @author Eli Wood 
 * @version 1
 */
public class Car extends Thing{
    private double speed;
    GreenfootImage image;
    protected Game world;
    private int yOffset;
    
    protected boolean touchingFrog;
    
    public Car(){
        speed = 5;
    }
    
    public Car(double speed, GreenfootImage image){
        this.speed = speed;
        this.image = image;
        
        setImage(image);
    }
    
    public Car(double speed, GreenfootImage image, int yOffset){
        this.speed = speed;
        this.image = image;
        this.yOffset = yOffset;
        
        setImage(image);
    }
    
    public Car(double speed, GreenfootImage image, int width, int height){
        this.speed = speed;
        this.image = image;
        
        image.scale(width, height);
        setImage(image);
    }
    
    public Car(double speed, GreenfootImage image, int width, int height, int yOffset){
        this.speed = speed;
        this.image = image;
        this.yOffset = yOffset;
        
        image.scale(width, height);
        setImage(image);
    }
    
    public void act(){
        if(world == null){
            world = (Game)getWorld();
        }
        x = getX();
        y = getY();
        move((int)speed);
        
        checkCollision();
        
        
    }
    
    protected void checkCollision(){
        if(intersects(world.getFrog())){
            world.getFrog().kill();
            touchingFrog = true;
        } else{
            touchingFrog = false;
        }
    }
    
    public void moveTo(int x, int y){
        setLocation(x, y + yOffset);
    }
    
    protected void checkEdge(){
        if(speed > 0){
            if(x > world.getWidth()){
                isDead = true;
            }
        } else {
            if(x < 0){
                isDead = true;
            }
        }
        
        if(y > world.getHeight()){
            isDead = true;
        }
    }
    
    public boolean touchingFrog(){
        return touchingFrog;
    }
}
