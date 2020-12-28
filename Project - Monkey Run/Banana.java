import greenfoot.*; 

//***image citation***
//“Free photo Banana Yellow Bunch Fruit Food Bananas Fruits.” 
//Banana Yellow Bunch Fruit Food Bananas Fruits - Max Pixel FreeGreatPicture.com, 
//http://maxpixel.freegreatpicture.com/Banana-Yellow-Bunch-Fruit-Food-Bananas-Fruits-25339
//*********************

public class Banana extends Actor
{
    private int y = 160;
    public boolean makebananafall = false;
    
    public void act() 
    {
        //Makes the banana move with the background
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()-5, y);
        }
        else
        {
            setLocation(getX(), y);
        }
        
        //Calls the checkCollision method
        checkCollision();
        
        //Allows the banana to fall
        if(makebananafall == true){
            bananaFall();
        }

    }
    
    //Makes the banana fall if it is hit by poop
    public void checkCollision()
    {
        Actor poopHit = getOneIntersectingObject(Poop.class);
      
        
        if(poopHit != null)
        {
            makebananafall = true;
            getWorld().removeObject(poopHit);
        }
      
    }
        
    //Makes the banana fall to the ground
    public void bananaFall()
    {   
        if(y < 290)
        {
            y += 4;
            setLocation(getX(), y);
        }
    }
}
