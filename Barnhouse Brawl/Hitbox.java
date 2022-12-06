import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
public class Hitbox extends Actor
{
    private Actor actor;
    private int xAdjust=0;
    private int yAdjust=0;

    private int boxW;
    private int boxH;
    private int hitboxIndent;

    private int actorW;
    private int actorH;
    public Hitbox(Actor actor) {
        this.actor = actor;
        actorW = actor.getImage().getWidth();
        actorH = actor.getImage().getHeight();
        resetIndent();
        resetSize();
    }

    public void setPosition(int x, int y){
        xAdjust = x;
        yAdjust = y;
    }

    public void setAngle(int angle){
        setRotation(angle);
    }

    public void addedToWorld(World world) {
        act();
    }

    public void act(){
        setLocation(actor.getX(), actor.getY());
        setRotation(actor.getRotation()-90);
        move(hitboxIndent);
    }

    public void setSize(int boxW, int boxH){
        GreenfootImage actorImage = actor.getImage();
        GreenfootImage hitboxImage = new GreenfootImage(boxH,boxW);
        if(Constants.Settings.debugMode){
            hitboxImage.setColor(new Color(255,0,0,127));
            hitboxImage.fillRect(0,0,boxH,boxW);
        }
        setImage(hitboxImage);
    }

    public void resetSize(){
        boxW = actorW+5;
        boxH = 30;
        setSize(boxW, boxH);
    }

    public void setIndent(int hitboxIndent){
        this.hitboxIndent = hitboxIndent;
    }

    public void resetIndent(){
        this.hitboxIndent = actorH/2;
    }

    public ArrayList<Animal> findTouching(){
        ArrayList<Animal> touching = new ArrayList<Animal>();
        
        if(((Animal)(actor)).dead) return touching;
        List<Hurtbox> list = this.getWorld().getObjects(Hurtbox.class);
        
        //List of all the animal classes on map
        for(Hurtbox animal : list){
            if(this.intersects(animal)){
                touching.add((Animal)animal.getActor());
            }
        }
        return touching; //Return array with all animals to push
    }
}
