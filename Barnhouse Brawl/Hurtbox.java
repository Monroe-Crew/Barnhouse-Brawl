import greenfoot.*;
public class Hurtbox extends Actor
{
    private Actor actor;
    public Hurtbox(Actor actor) {
        this.actor = actor;
        int w = actor.getImage().getWidth()-5;
        int h = actor.getImage().getHeight()-1;

        GreenfootImage actorImage = actor.getImage();
        GreenfootImage hurtboxImage = new GreenfootImage(w,h);
        if(Constants.debugMode){
            hurtboxImage.setColor(new Color(0,0,255,127));
            hurtboxImage.fillRect(0,0,w,h);
        }
        setImage(hurtboxImage);
    }

    public void act() 
    {
        setLocation(actor.getX(), actor.getY());
        setRotation(actor.getRotation());
    }  

    public Actor getActor(){
        return this.actor;
    }

    public void addedToWorld(World world) {
        setLocation(actor.getX(), actor.getY());
    }
}
