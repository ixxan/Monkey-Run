import greenfoot.*; 

//***image citation***
//“Free vector graphic: Shield, Security, Protection, Sure.” 
//pixabay, https://pixabay.com/en/shield-security-protection-sure-1086702/
//*********************

public class Protection extends Actor
{
    /**
     * Act - do whatever the Protection wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */        
    //Moves the protection with the background
    public void act() 
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()-5, 290);
        }
        else
        {
            setLocation(getX(), 290);
        }
    }   
}
