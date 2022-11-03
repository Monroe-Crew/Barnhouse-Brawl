import greenfoot.*;
import java.util.*;
import java.awt.Color;
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

    public void act(){
        setLocation(actor.getX(), actor.getY());
    }    

    public ArrayList<Animal> findTouching(){
        List<Hurtbox> list = this.getWorld().getObjects(Hurtbox.class);
        //List of all the animal classes on map
        ArrayList<Animal> touching = new ArrayList<Animal>();
        for(Hurtbox animal : list){
            if(this.intersects(animal)){
                touching.add((Animal)animal.getActor());
            }
        }
        return touching; //Return array with all animals to push
    }
}
