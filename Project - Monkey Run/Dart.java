import greenfoot.*; 
public class Dart extends Actor
{
   
    //Creates speed variable
    public int speed;
    
    //Declares the speed variable
    public Dart(){
        speed = 5;
    }
    
    //Makes the dartsmove across the screen
    public void act() 
    {
        setLocation(getX()+speed, getY());
        
        if (getX() == 1200) 
        {
            getWorld().removeObject(this);
        }
    }
   
}
