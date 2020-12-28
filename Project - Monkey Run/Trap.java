import greenfoot.*; 

//***image citation***
//openclipart.org/image/2400px/svg_to_png/4550/ivak-Bear-Trap.png
//********************

public class Trap extends Actor
{
    //moves the location of the trap with the background
    public void act() 
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()-5, 300);
        }
        else
        {
            setLocation(getX(), 300);
        }
    }   
}