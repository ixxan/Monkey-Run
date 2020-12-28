import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Background img1, img2;
    private Monkey monkey;
   
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 456, 1, false);
        img1 =  new Background();
        addObject(img1, getWidth()/2, getHeight()/2);
        
        img2 =  new Background();
        addObject(img2, getWidth()/2 + getWidth(), getHeight()/2);
        
        monkey = new Monkey();
        addObject(monkey, 500, 200);
        
        
        
    }
    
    public void act(){
        //Background background = new Background();
        //if (background.returnX() <= 0){
        //    addObject(background, 1200, 228);
        //}
        //if(background1.returnX < 1){
       //     background2.setloc(1200);
        //}
        
        //background2.moveX(1);
        //background1.moveX(1);
        if (Greenfoot.isKeyDown("right")) {
            img1.scroll();
            img2.scroll();
        }
        
        //int monkeyX = monkey.getX();
        
        
        if(Greenfoot.mouseClicked(null)){
            addObject(new Poop(), monkey.getX(), monkey.getY());
        }
        
        
        if (Greenfoot.getRandomNumber(1000) < 1)
        {
            addObject(new Protection(), 779, Greenfoot.getRandomNumber(360));
        }
    }
}
