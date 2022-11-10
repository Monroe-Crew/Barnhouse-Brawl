import greenfoot.*;
import java.util.*;

public class Projectile extends Actor{
    Actor animal;
    public Projectile(Actor actor){
        this.animal = actor;
        this.setRotation(actor.getRotation()-90);
    }
    public void act(){
        this.move(10);
        Actor a = getOneIntersectingObject(Animal.class);
        if(a != null && a != animal){
            //bump actor
            this.getWorld().removeObject(this);
        }
        //Move the object
    }    
}
