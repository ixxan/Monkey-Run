import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerup extends Actor
{
    /**
     * Act - do whatever the Powerup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Moves the powerup with the background
    public void act() 
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()-5, 294);
        }
        else
        {
            setLocation(getX(), 294);
        }
    }    
}
