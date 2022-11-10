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
        Animal a = (Animal)getOneIntersectingObject(Animal.class);
        if(a != null && a != animal){
            //Add a stun mechanic in the future
            int x = Math.abs(a.getX()-this.getX());
            int y = Math.abs(a.getY()-this.getY());
            double angle = Math.tan(y/x);
            if(angle<=90){
                a.knockBack(-10,-10);
            }
            else if(angle<=180){
                a.knockBack(-10,10);
            }
            else if(angle<=270){
                a.knockBack(10,10);
            }
            else{
                a.knockBack(10,-10);
            }
            this.getWorld().removeObject(this);
        }
    }    
}
