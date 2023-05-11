import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pause screen
 * 
 * @author Eli Wood
 * @version 1
 */
public class Pause extends Menu{
    UIElement title;
    Button muteMusic;
    Button muteSound;
    
    private static int musicVolume = 80;
    private static int soundVolume = 80;
    
    /**
     * Constructor 
     * 
     * @author Eli Wood
     * @version 1
     */
    public Pause(World world){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(world); 
        
        showText("Press space to resume", getWidth()/2, getHeight()/2 - 100);
        
        muteMusic = new Button();
        muteSound = new Button();
        
        title = new UIElement(new GifImage("title.gif"));
        addObject(title, getWidth()/2, getHeight()/2 - 150);
        addObject(muteMusic, getWidth()/4, getHeight()/2);
        addObject(muteSound, getWidth()/4, getHeight()/2 + 50);
        showText("" + musicVolume, getWidth()/4*3, getHeight()/2);
        showText("" + soundVolume, getWidth()/4*3, getHeight()/2 + 50);
        
        if(musicVolume >1){
            muteMusic.setState(false);
        } else{
            muteMusic.setState(true);
        }
        if(soundVolume >1){
            muteSound.setState(false);
        } else{
            muteSound.setState(true);
        }
    }
    
    /**
     * main act function
     * 
     * @author Eli Wood
     * @version 1
     */
    public void act(){
        showText("Press space to resume", getWidth()/2, getHeight()/2 - 100);
        
        showText("" + musicVolume, getWidth()/4*3, getHeight()/2);
        showText("" + soundVolume, getWidth()/4*3, getHeight()/2 + 50);
        
        if(muteMusic.getState() == true){
            musicVolume = 1;
        } else{
            musicVolume = 80;//change when sliders are added
        }
        
        if(muteSound.getState() == true){
            soundVolume = 1;
        } else{
            soundVolume = 80;//change when sliders are added
        }
        
        //add sliders for volume and buttons to mute
        
        if(Greenfoot.isKeyDown("space")){
            removeObject(title);
            removeObject(muteMusic);
            removeObject(muteSound);
            Greenfoot.setWorld(world);
        }
    }
    
    /**
     * gets the music volume
     * 
     * @author Eli Wood
     * @version 1
     * @return music volume
     */
    public static int getVolume(){
        return musicVolume;
    }
    
    /**
     * gets the sound effect volume
     * 
     * @author Eli Wood
     * @version 1
     * @return sound effect volume
     */
    public static int getSoundVolume(){
        return soundVolume;
    }
}
