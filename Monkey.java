import greenfoot.*; 
//***image citation***
//“File:Monkey Icon.svg.” File:Monkey Icon.svg - Wikimedia Commons, 
//commons.wikimedia.org/wiki/File:Monkey_icon.svg.
//*********************
public class Monkey extends Actor
{
    private int speed = 2;
    private int jumpSpeed = 6;
    private int fallSpeed = 6;
    private boolean isJumping = false;
    private boolean isProtected = false;
    private boolean hasPowerup = false;
    private boolean facingRight = true;
    
    // monkey's actions
    public void act() 
    {
        checkKeyPress();
        fall();
        checkCollision();
        checkProtectedStill();
        if(isJumping == true)
        {
            jump();
        }
    }
    
    public void checkProtectedStill(){
        if(facingRight == true && isProtected == false)
        {
            setImage("monkeyRight.png");
        } 
        else if (facingRight == false && isProtected == false)
            {
                setImage("monkeyLeft.png");
            }
    }
    
    //keyboard contrals 
    public void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            if(getY() == 264){
                isJumping = true;
            }
        }

        if (Greenfoot.isKeyDown("right")) 
        {
            
            if(isProtected == true)
            {
                setImage("monkeyProtectedRight.png");
            }
            else
            {
                setImage("monkeyRight.png");
            }
            
            if(getX() > 500)
            {
                setLocation(getX() - 3, getY());
            } 
            else 
            {
                setLocation(getX()+speed,getY());
            }
            facingRight = true;
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            if(isProtected == true)
            {
                setImage("monkeyProtectedLeft.png");
            }
            else
            {
                setImage("monkeyLeft.png");
            }
            if(getX() < 0)
            {
                setLocation(getX() + 20, getY());
            } else {
                setLocation(getX()-(speed+5),getY());
            }
            facingRight = false;
        }
    }
    
    //jump
    public void jump()
    {
        if(getY() < 120)
        {
            isJumping = false;
            fall();
        } 
        else 
        {
            if(getY() == 264)
            {
                Greenfoot.playSound("jump.wav");
            }
            setLocation(getX(), getY()-jumpSpeed);
        }
    }
    
    //fall
    public void fall()
    {   
       if(getY() < 264 && isJumping == false)
       {
           setLocation(getX(), getY() + fallSpeed);
        }
       if(getY() > 264)
       {
         setLocation(getX(), 264);
       }
    }
    
    //return x-axis
    public int saveX()
    {
        return getX();
    }
    
    //return y-axis
    public int saveY()
    {
        return getY();
    }
    
    // collisions
    private void checkCollision()
    {
        Actor hitProtection = getOneIntersectingObject(Protection.class);
        Actor hitTrap = getOneIntersectingObject(Trap.class);
        Actor hitBanana = getOneIntersectingObject(Banana.class);
        Actor hitDart= getOneIntersectingObject(Dart.class);
       
        if(hitProtection != null)
        {
            getWorld().removeObject(hitProtection);
            isProtected = true;
        }
        
        if(hitTrap != null)
        {
            if(isProtected == true)
            {
              getWorld().removeObject(hitTrap);
            }
            else
            {
            Greenfoot.playSound("trap.wav");
            Greenfoot.stop();
            Greenfoot.playSound("gameover.wav");
            MyWorld gameover = (MyWorld)getWorld();
            gameover.gameOver();
            }
        }
        
        if(hitBanana != null)
        {
           if(getY() != 160)
           {
               getWorld().removeObject(hitBanana);
               Greenfoot.playSound("hitbanana.wav");
           }
           MyWorld score = (MyWorld)getWorld();
           score.addScore(5);
        }
         
        if(hitDart != null)
        {
            if(isProtected == true)
            {
              getWorld().removeObject(hitDart);
            }
            else
            {
            getWorld().removeObject(hitDart);
            Greenfoot.stop();
            Greenfoot.playSound("gameover.wav");
            MyWorld gameover = (MyWorld)getWorld();
            gameover.gameOver();
            }
        }
    }
    
    //return protection
    public boolean returnProtected()
    {
        return isProtected;
    }
    
    //return protection
    public void setProtectedFalse(){
        isProtected = false;
    }
}
