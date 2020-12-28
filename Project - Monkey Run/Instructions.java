import greenfoot.*; 

public class Instructions extends World
{
    private Text text, back;
    private String ins;
    
    //instruction text
    public Instructions()
    {    
        // Create a new world with 1000x380 cells with a cell size of 1x1 pixels.
        super(1000, 380, 1, false);
        
        ins = "Use left & right arrows to move around, up arrow to jump\n" +
              "Click on any objects you want to shoot on\n" + 
              "Be careful with the darts and traps(only in hard mood), jump over or shoot them\n" + 
              "Protection will protect you for 20 seconds\n" + 
              "100 points to win\n";
        
        text = new Text();
        addObject(text, getWidth()/2, getHeight()/2);
        text.setImage(new GreenfootImage(ins, 22, Color.WHITE, Color.BLACK));
        
        back = new Text();
        addObject(back, 70, 20);
        back.setImage(new GreenfootImage("<-- Back", 30, Color.WHITE, Color.BLACK));
    }
    
    // return to menu screen
    public void act()
    {
        if (Greenfoot.mouseClicked(back)) 
        {
            Greenfoot.setWorld(new Menu());
        }
    }
}
