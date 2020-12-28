import greenfoot.*;  

public class Menu extends World
{
    private Text easy, instruction, hard;
    private boolean isHard = false;
    
    // create the menu screen
    public Menu()
    {    
        //Create a new world with 1000x380 cells with a cell size of 1x1 pixels.
        super(1000, 380, 1, false);
        
        easy =  new Text();
        addObject(easy, getWidth()/2, getHeight()/3);
        instruction =  new Text();
        addObject(instruction, getWidth()/2, getHeight()/3 + getHeight()/3);
        hard =  new Text();
        addObject(hard, getWidth()/2, getHeight()/2);
        
        easy.setImage(new GreenfootImage("Easy", 50, Color.WHITE, Color.BLACK));
        instruction.setImage(new GreenfootImage("Instructions", 50, Color.WHITE, Color.BLACK));
        hard.setImage(new GreenfootImage("Hard", 50, Color.WHITE, Color.BLACK));
    }
    
    //act using checkClicks method
    public void act()
    {
        if(Greenfoot.mouseClicked(null))
        {
            checkClicks();
        }
    }
    
    //mouse click for different levels and instruction
    public void checkClicks()
    {
        if (Greenfoot.mouseClicked(easy)) 
        {
            Greenfoot.setWorld(new MyWorld(isHard));
        } 
        else if(Greenfoot.mouseClicked(instruction))
                {
                Greenfoot.setWorld(new Instructions());
                } 
            else if(Greenfoot.mouseClicked(hard))
                    {
                        isHard = true;
                        Greenfoot.setWorld(new MyWorld(isHard));
                    }
    }
    
    //return isHard
    public boolean returnIsHard()
    {
        return isHard;
    }
}
