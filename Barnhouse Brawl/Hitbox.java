import greenfoot.*;
import java.util.*;
public class Hitbox extends Actor
{
    private Actor actor;
    private int xAdjust=0;
    private int yAdjust=0;
    public Hitbox(Actor actor) {
        this.actor = actor;
        int w = actor.getImage().getWidth()+10*3;
        int h = actor.getImage().getHeight()-10;
        GreenfootImage actorImage = actor.getImage();
        GreenfootImage hitboxImage = new GreenfootImage(w,h);
        hitboxImage.setColor(new Color(255,0,0,127));
        hitboxImage.fillRect(0,0,w,h);
        setImage(hitboxImage);
    }
    
    public void setxAdjust(int x){
        xAdjust = x;
    }
    
    public void setyAdjust(int y){
        yAdjust = y;
    }

    public void addedToWorld(World world) {
        setLocation(actor.getX()-xAdjust, actor.getY()-yAdjust);
    }

    public void act(){
        setLocation(actor.getX()-xAdjust, actor.getY()-yAdjust);
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
