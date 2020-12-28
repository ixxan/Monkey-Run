import greenfoot.*;  

//***image citation***
//“Image-2014-10-20-poop.png.” 2014-10-20-poop.png - Joke Battles Wiki, 
//joke-battles.wikia.com/wiki/File:2014-10-20-poop.png
//*********************

public class Poop extends Actor
{
    private int count = 0;
    
    //actions for the poop
    public void act() 
    {
        if(Greenfoot.mouseClicked(null))
        {
            shoot();
            count = 1;
        }
        move(7);
        
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        } 
        else 
        {
            checkCollision();
        }
    }    
    
    //shoot poop
    public void shoot(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(count == 0)
        {
            if(mouse.getX() < getX())
            {
                setImage(new GreenfootImage("poopInvert.png")); 
            } 
            else 
            {
                setImage(new GreenfootImage("poop.png"));
            }
            this.turnTowards(mouse.getX(), mouse.getY());
        }
        Greenfoot.playSound("Poopthrow.wav");
    }
    
    //remove dart and poop after collision
    public void checkCollision()
    {
        Actor hitDart = getOneIntersectingObject(Dart.class);
        
        if(hitDart != null)
        {
            getWorld().removeObject(hitDart);
            getWorld().removeObject(this);
        }

    }
}
