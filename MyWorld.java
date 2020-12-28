import greenfoot.*;  

public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Background img1, img2;
    private Monkey monkey;
    private int time;
    private int score;
    private int tick = 0;
    private boolean isHard = false;
     
    public MyWorld(boolean difficulty)
    {    
        // Create a new world with 1200x380 cells with a cell size of 1x1 pixels.
        super(1000, 380, 1, false);
        
        //set dificulty
        isHard = difficulty;
        
        // background image with half width
        img1 =  new Background();
        addObject(img1, getWidth()/2, getHeight()/2);
        
        // background image with one half width
        img2 =  new Background();
        addObject(img2, getWidth()/2 + getWidth(), getHeight()/2);
       
        // monkey appears when the game start
        monkey = new Monkey();
        addObject(monkey, 500, 200);
        
        score = 0;
        time = 20;
        showScore();
    }
    
    public void act()
    {    
        // scroll background
        if (Greenfoot.isKeyDown("right")) 
        {
            img1.scroll();
            img2.scroll();
        }
        
        // click mouse shoot poop
        if(Greenfoot.mouseClicked(null)){
            addObject(new Poop(), monkey.getX(), monkey.getY());
        }
        
        //protection appears randomly
        if (Greenfoot.getRandomNumber(1600) < 1)
        {
            addObject(new Protection(), 1200, 290);
        }
    
        //banana and tree appears randomly
        if (Greenfoot.getRandomNumber(400) < 1)
        {
            addObject(new Tree(), 1200, 171);
            addObject(new Banana(), 1200, 160);
        }
        
        //Dart appears randomly
        if (Greenfoot.getRandomNumber(400) < 1)
        {
            addObject(new Dart(), -20, 280);
        }
        
        //trap appears randomly in hard mode
        if(isHard == true){
            if (Greenfoot.getRandomNumber(4000) < 1)
            {
                addObject(new Trap(), 1200, 300);
            }
        }
        countTime();
    }
   
   
    //add score
    public void addScore(int points)
    {
        score = score + points;
        showScore();
        if (score == 100) 
        {
           showEndMessage(); 
           Greenfoot.stop();
        }
    }
    
    //show end message
    private void showEndMessage()
    {
        showText("100 points!!!", 500, 160);
        showText("You win!!!", 500, 180);
    }
    
    //show score
    private void showScore()
    {
        showText("Score: " + score, 80, 25);
    }
    
    // count time for protection 
    private void countTime()
    {
       if (monkey.returnProtected() == true && time > 0)
        {   
            tick++;
            if(tick >= 60)
            {
                time--;
                tick = 0;
            }
            showText("Protection Time: " + time + "s", 840, 25);
        }
       if(time <= 0)
       {
           monkey.setProtectedFalse();
           if(monkey.returnProtected() == false)
           {
               showText("", 840, 25);
               time = 20;
            }
        }
    }
    
    //return time
    public int returnTime()
    {
       return time; 
    }
    
    //show time count down
    private void showTime()
    {
        showText("Protection Time: " + time + "s", 840, 25);
    }
    
    //show game over message
    public void gameOver()
    {
        showText("Game Over", 500, 180);
    }
}
 
