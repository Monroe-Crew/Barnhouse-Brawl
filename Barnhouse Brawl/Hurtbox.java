import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hurtbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hurtbox extends Actor
{
    private Actor actor;
    public Hurtbox(Actor actor) {
        this.actor = actor;
        GreenfootImage hurtboxImage = new GreenfootImage(30,30);
        hurtboxImage.setColor(new Color(0,0,255,127));
        hurtboxImage.fillRect(0,0,30,30);
        setImage(hurtboxImage);
    }
    public void act() 
    {
        setLocation(actor.getX(), actor.getY());
        // Add your action code here.
    }    
}
