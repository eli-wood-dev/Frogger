import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Thing extends Actor
{
    protected int x;
    protected int y;
    protected int speed;
    protected Game world;
    protected int yOffset;
    protected boolean isDead = false;
    
    abstract void checkEdge();
    abstract void checkCollision();
    abstract void moveTo(int x, int y);
    public boolean getDead(){
        return isDead;
    }
}
