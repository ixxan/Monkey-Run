import greenfoot.*;  

//***image citation***
//"Free Image on Pixabay - Cartoon, Background, Day, Nature.” 
//pixabay, https://pixabay.com/en/cartoon-background-day-nature-2614618/
//********************

public class Tree extends Actor
{
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Moves the trees with the background
    public void act() 
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()-5, 171);
        }
        else
        {
            setLocation(getX(), 171);
        }
    }    
}
