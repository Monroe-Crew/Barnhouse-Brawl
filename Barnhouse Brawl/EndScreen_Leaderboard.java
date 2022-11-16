import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen_Leaderboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen_Leaderboard extends Actor
{
    GreenfootImage image;
    public EndScreen_Leaderboard(){
        image = new GreenfootImage(200,100);
        image.setColor(new Color(0,0,255));
        image.setFont(new Font("Arial", true, false, 50));
        image.drawString("ahhhhh", 10, 100);
        setImage(image);
    }
    public void act() 
    {
    }    
}
