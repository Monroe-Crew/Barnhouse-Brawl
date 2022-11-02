import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hitbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hitbox extends Actor
{
    private Actor actor;
    public Hitbox(Actor actor) {
        this.actor = actor;
        int w = actor.getImage().getWidth()+10;
        int h = actor.getImage().getHeight()+10;
        GreenfootImage actorImage = actor.getImage();
        GreenfootImage hitboxImage = new GreenfootImage(w,h);//,);
        hitboxImage.setColor(new Color(0,0,255,127));
        hitboxImage.fillRect(0,0,w,h);
        setImage(hitboxImage);
    }
    
    public void addedToWorld(World world) {
        setLocation(actor.getX(), actor.getY());
        
    }

    public void act() 
    {
        setLocation(actor.getX(), actor.getY());
        // Add your action code here.
    }    
}
