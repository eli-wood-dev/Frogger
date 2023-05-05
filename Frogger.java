import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Frog class for the player
 * 
 * @author Eli Wood
 * @version 1
 */
public class Frogger extends Actor
{
    GreenfootImage frog;
    private int x;
    private int y;
    private int speed = 5;
    private int newX;
    private int newY;
    private World world;
    private int maxHeight = 400;
    private boolean isAlive = true;
    private boolean invincible = false;
    
    private int timer;
    int invinEnd;
    GreenfootSound die;
    GreenfootSound boing;
    GreenfootSound drown;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the speed and width of the frog
     */
    public Frogger(int speed){
        this.speed = speed;
        
        frog = getImage();
        frog.scale(speed, speed);
        die = new GreenfootSound("splat.wav");
        boing = new GreenfootSound("boing.wav");
        drown = new GreenfootSound("drown.wav");
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the speed and width of the frog
     * @param maxHeight the max height the frog can go
     */
    public Frogger(int speed, int maxHeight){
        this.speed = speed;
        this.maxHeight = maxHeight;
        
        frog = getImage();
        frog.scale(speed, speed);
        setImage(frog);
        die = new GreenfootSound("splat.wav");
        boing = new GreenfootSound("boing.wav");
        drown = new GreenfootSound("drown.wav");
    }
    
    /**
     * Act - do whatever the Frogger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
        if(world == null){
            world = getWorld();
        }
        
        x = getX();
        y = getY();
        
        if(x + speed/2 < 0){
            kill();
        }
        
        if(x - speed/2 > world.getWidth()){
            kill();
        }
        
        if(y < maxHeight){
            setLocation(x, y + speed);
        }
        
        if(y + speed/2 > world.getHeight()){
            setLocation(x, y - speed);
        }
        
        if(invincible && timer % 4 == 0){
            blink();
        } else if(!invincible){
            show();
        }
        
        if(timer >= invinEnd){
            invincible = false;
        }
        
        timer ++;
    }
    
    /**
     * getter for the speed
     * 
     * @author Eli Wood
     * @version 1
     * @return speed the frog's speed
     */
    public int getSpeed(){
        return speed;
    }
    
    /**
     * getter for if the player is alive
     * 
     * @author Eli Wood
     * @version 1
     * @return if the player is alive
     */
    public boolean isAlive(){
        return isAlive;
    }
    
    /**
     * setter for if the player is alive
     * 
     * @author Eli Wood
     * @version 1
     * @param life what to set the player isAlive to
     */
    public void setAlive(boolean life){
        isAlive = life;
    }
    
    /**
     * kills the player
     * 
     * @author Eli Wood
     * @version 1
     */
    public void kill(){
        if(!invincible){
            isAlive = false;
            die.play();
        }
    }
    
    /**
     * drowns the player(identical to kill)
     * 
     * @author Eli Wood
     * @version 1
     */
    public void drown(){
        if(!invincible){
            isAlive = false;
            drown.play();
        }
    }
    
    /**
     * makes the player blink
     * 
     * @author Eli Wood
     * @version 1
     */
    public void blink(){
        if(frog.getTransparency() == 0){
            show();
        } else{
            hide();
        }
    }
    
    /**
     * makes the player visible
     * 
     * @author Eli Wood
     * @version 1
     */
    public void show(){
        frog.setTransparency(255);
    }
    
    /**
     * makes the player invisible
     * 
     * @author Eli Wood
     * @version 1
     */
    public void hide(){
        frog.setTransparency(0);
    }
    
    /**
     * getter for if the player is invincible
     * 
     * @author Eli Wood
     * @version 1
     * @return if the player is invincible
     */
    public boolean isInvincible(){
        return invincible;
    }
    
    /**
     * setter for if the player is invincible
     * 
     * @author Eli Wood
     * @version 1
     * @param if the player is invincible
     */
    public void setInvincible(boolean invincible){
        this.invincible = invincible;
    }
    
    /**
     * sets the player invincible for a time
     * 
     * @author Eli Wood
     * @version 1
     * @param if the player is invincible
     */
    public void setInvincible(int duration){
        invinEnd = timer + duration;
        setInvincible(true);
    }
    
    /**
     * setter for the volume
     * 
     * @author Eli Wood
     * @version 1
     * @param newVolume the volume to set all sounds to
     */
    public void setVolume(int newVolume){
        die.setVolume(newVolume);
        boing.setVolume(newVolume);
    }
    
    /**
     * getter for the volume
     * 
     * @author Eli Wood
     * @version 1
     * @return the volume for sfx
     */
    public int getVolume(){
        return die.getVolume();
    }
    
    /**
     * plays a boing sound
     * 
     * @author Eli Wood
     * @version 1
     */
    public void playBoing(){
        if(boing.isPlaying()){
            GreenfootSound temp = new GreenfootSound("boing.wav");
            temp.setVolume(boing.getVolume());
            temp.play();
        } else{
            boing.play();
        }
    }
}
