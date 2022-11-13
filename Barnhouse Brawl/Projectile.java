import greenfoot.*;
import java.util.*;

public class Projectile extends Actor{
    Actor animal;
    public Projectile(Actor actor){
        this.animal = actor;
        getImage().scale(50, 60);
        this.setRotation(actor.getRotation()-90);
    }

    public void act(){
        this.move(10);
        Animal a = (Animal)getOneIntersectingObject(Animal.class);
        if(a != null && a != animal){
            //Add a stun mechanic in the future
            basicPush(a);
            this.getWorld().removeObject(this);
        }
    } 

    public void basicPush(Animal animal){
        // Larger multiplier = harder push for all characters
        int multiplier = 5;
        int xStrength = (int)(((animal.getX() - this.getX() > 0 ? 1 : -1) * (double)animal.getX()/this.getX() * 5)/Math.sqrt(animal.getWeight()))*multiplier;
        int yStrength = (int)(((animal.getY() - this.getY() > 0 ? 1 : -1) * (double)animal.getY()/this.getY() * 5)/Math.sqrt(animal.getWeight()))*multiplier;
        animal.knockBack(xStrength, yStrength);
        //call getObjects(class) or getObjectsAt(x,y,class) on world to get all actors
    }
}
