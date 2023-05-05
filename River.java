import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class River here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class River extends Road{
    GreenfootImage carImage = new GreenfootImage("bread.png");
    ArrayList<Rock> rocks = new ArrayList<Rock>();
    
    public River(){
        super();
        y-= 25;
    }
    
    public River(int width, int height){
        super(width, height);
        y-= 25;
    }
    
    public River(int width, int height, double carSpeed, int carFrequency){
        super(width, height, carSpeed, carFrequency);
        y-= 25;
    }
    
    private void createRocks(){
        int yOffset = 60;
        int rockX = 0;
        for(int i = 0; i < 10; i++){
            rocks.add(new Rock(yOffset));
            
            world.addObject(rocks.get(i), rockX, y);
            yOffset *= -1;
            
            if(i%2 == 1){
                rockX += 75;
            }
        }
        
    }
    
    @Override //changes cars to logs and kills player
    public void act(){
        if(world == null){
            world = (Game)getWorld();
        }
        
        if(rocks.size() == 0){
            createRocks();
        }
        
        int carY = y;
        int yOffset = 25;
        double newSpeed = carSpeed;
        boolean kill = true;;
        
        if(timer % carFrequency == 0){
            for(int i = 0; i < 2; i++){
                cars.add(new Log(newSpeed, carImage, yOffset));
                int carX;
                if(newSpeed > 0){
                    carX = 0;
                } else{
                    carX = world.getWidth();
                }
                
                world.addObject(cars.get(cars.size()-1), carX, carY);
                newSpeed *= -1.25; //reverse for the second car
                yOffset *= -1;
            }
        }
        
        for(int i = 0; i < rocks.size(); i++){
            rocks.get(i).moveTo(rocks.get(i).getX(), y);
            if(rocks.get(i).getDead()){
                world.removeObject(rocks.get(i));
                rocks.remove(i);
                i--;
            }
            
            if(rocks.get(i).touchingFrog()){
                kill = false;
            }
        }
        
        for(int i = 0; i < cars.size(); i++){
            cars.get(i).moveTo(cars.get(i).getX(), y);
            
            if(cars.get(i).getDead()){
                world.removeObject(cars.get(i));
                cars.remove(i);
                i--;
            }
            
            if(cars.get(i).touchingFrog()){
                kill = false;
            }
        }
        
        if(intersects(world.getFrog()) && kill){
            world.getFrog().drown();
        }
        
        setLocation(x, y);
        
        timer++;
    }
    
    public void killAll(){
        for(int i = 0; i < cars.size(); i++){
            world.removeObject(cars.get(i));
            cars.remove(i);
            i--;
        }
        
        for(int i = 0; i < rocks.size(); i++){
            world.removeObject(rocks.get(i));
            rocks.remove(i);
            i--;
        }
    }
}
