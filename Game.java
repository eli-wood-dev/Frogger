import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;

/**
 * Main game
 * 
 * @author Eli Wood 
 * @version 1
 */
public class Game extends World{
    
    Frogger player;
    ArrayList<Road> roads = new ArrayList<Road>();
    ArrayList<Corpse> corpses = new ArrayList<Corpse>();
    
    int roadFrequency = 100;
    int timer = 0;
    int iFramesDuration = 60;
    int width;
    int height;
    int lives;
    int score;
    int minRoadDistance = 300;
    
    int moveRoad = 0;
    int maxPlayerHeight = 400;
    Random r = new Random();
    
    GreenfootSound titleMusic;
    int currentVolume = 100;
    int currentSoundVolume = 100;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     */
    public Game() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 500, 1, false); 
        titleMusic = new GreenfootSound("funnysong.mp3");
        titleMusic.playLoop();
        titleMusic.setVolume(80);
        Greenfoot.setWorld(new Start(this));
        
        setPaintOrder(new Class[]{Car.class, Frogger.class, Log.class, Rock.class, River.class, Corpse.class, Road.class});
        setActOrder(new Class[]{Car.class, Rock.class, Log.class, Road.class, River.class, Frogger.class, Corpse.class});
        
        width = getWidth();
        height = getHeight();
        
        GreenfootImage background = new GreenfootImage("cell.jpg");
        background.scale(100, 100);
        
        
        
        reset();
    }
    
    /**
     * resets the game
     * 
     * @author Eli Wood
     * @version 1
     */
    public void reset(){
        if(player != null){
            removeObject(player);
        }
        
        player = new Frogger(50);
        
        addObject(player, width/2, maxPlayerHeight);
        
        //remove old roads
        for(int i = 0; i < roads.size(); i++){
            roads.get(i).killAll();
            removeObject(roads.get(i));
            roads.remove(i);
            i--;
        }
        
        //remove old corpses
        for(int i = 0; i < corpses.size(); i++){
            removeObject(corpses.get(i));
            corpses.remove(i);
            i--;
        }
        
        //add starting road
        roads.add(new Road(width, 125, 5, 60));
        addObject(roads.get(roads.size()-1), width/2, -25);
        
        lives = 3;
        score = 0;
        
        timer = 0;
    }
    
    /**
     * Act - do whatever the World wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        moveRoad = 0;
        
        if(roads.size() > 0 && roads.get(roads.size()-1).getY() > minRoadDistance){
            int direction = r.nextInt(2);
            if(direction == 0){
                direction = -1;
            }
            double minSpeed = .75 + score*0.01;//scales as the player gets further
            
            double speedMultiplier = r.nextDouble()/2 + minSpeed;
            double frequency = map(speedMultiplier, minSpeed, minSpeed+0.5, 60*minSpeed+0.5, 60*minSpeed);
            
            if(r.nextInt(2) == 1){
                roads.add(new Road(width, 125, 5 * direction * speedMultiplier, (int)frequency));
            } else{
                roads.add(new River(width, 125, 2 * direction * speedMultiplier, (int)(frequency * 1.5)));
            }
            
            addObject(roads.get(roads.size()-1), width/2, -25);
        }
        
        getKeys();
        
        for(int i = 0; i < corpses.size(); i++){
            corpses.get(i).setY(corpses.get(i).getY() + moveRoad);
            
            if(corpses.get(i).getY() > height || corpses.get(i).getTransparency() < 100){
                removeObject(corpses.get(i));
                corpses.remove(i);
                i--;
            }
        }
        
        for(int i = 0; i < roads.size(); i++){
            roads.get(i).setX(roads.get(i).getX()); //make sure the road stays in the middle
            roads.get(i).setY(roads.get(i).getY() + moveRoad);
            
            if(roads.get(i).getY() - 75 > height){
                roads.get(i).killAll();
                removeObject(roads.get(i));
                roads.remove(i);
                i--;
            }
        }
        
        
        if(!player.isAlive()){
            lives--;
            
            corpses.add(new Corpse());
            addObject(corpses.get(corpses.size()-1), player.getX(), player.getY());
            
            removeObject(player);
            player = new Frogger(50);
            addObject(player, width/2, maxPlayerHeight);
            
            player.setAlive(true);
            player.setInvincible(iFramesDuration);
        }
        
        if(lives <= 0){
            Greenfoot.setWorld(new End(this));
        }
        
        displayLives();
        displayScore();
        showText("press m to mute music", 200, 25);
        showText("press n to mute sfx", 200, 50);
        titleMusic.setVolume(currentVolume);
        player.setVolume(currentSoundVolume);
        
        timer++;
    }
    
    /**
     * displays your current lives
     * 
     * @author Eli Wood
     * @version 1
     */
    private void displayLives(){
        showText("lives: " + lives, 50, 25);
    }
    
    /**
     * displays your current score
     * 
     * @author Eli Wood
     * @version 1
     */
    private void displayScore(){
        showText("score: " + score, 50, 50);
    }
    
    /**
     * detects user input
     * 
     * @author Eli Wood
     * @version 1
     */
    private void getKeys(){
        
        String key = Greenfoot.getKey();
        
        if(key == null){
            key = "";
        }
        
        if(key.equalsIgnoreCase("w")){
            if(player.getY() > maxPlayerHeight){
                player.setLocation(player.getX(), player.getY() - player.getSpeed());
            } else{
                moveRoad = player.getSpeed();
                score++;
            }
            player.playBoing();
        }
        if(key.equalsIgnoreCase("s")){
            player.setLocation(player.getX(), player.getY() + player.getSpeed());
            player.playBoing();
        }
        if(key.equalsIgnoreCase("a")){
            if(player.getX() - player.getSpeed() > 0){
                player.setLocation(player.getX() - player.getSpeed(), player.getY());
                player.playBoing();
            }
        }
        if(key.equalsIgnoreCase("d")){
            if(player.getX() + player.getSpeed() < getWidth()){
                player.setLocation(player.getX() + player.getSpeed(), player.getY());
                player.playBoing();
            }
        }
        if(key.equals("escape")){
            Greenfoot.setWorld(new Pause(this));
        }
        //remove and transfer to pause screen
        if(key.equalsIgnoreCase("m")){
            if(titleMusic.getVolume() == 0){
                currentVolume = 100;
            } else{
                currentVolume = 1;
            }
        }
        if(key.equalsIgnoreCase("n")){
            if(titleMusic.getVolume() == 0){
                currentSoundVolume = 80;
            } else{
                currentSoundVolume = 1;
            }
        }
    }
    
    /**
     * getter for the player
     * 
     * @author Eli Wood
     * @version 1
     * @return the player
     */
    public Frogger getFrog(){
        return player;
    }
    
    /**
     * remaps a number between two ranges
     *
     * @author EliWood
     * @version 1
     *
     * @param s
     * @param low1
     * @param high1
     * @param low2
     * @param high2
     * @return s remapped to the new range
     */
    public static double map(double s, double low1, double high1, double low2, double high2){
        return (s-low1)*(high2-low2)/(high1-low1) + low2;
    }
}
