import greenfoot.*;

public class Projectile extends Actor{
    Actor animal;
    GreenfootSound hit = new GreenfootSound("hit.wav");

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

            hit.play();
            this.getWorld().removeObject(this);
        }
    } 

    public void basicPush(Animal animal){
        double multiplier = Constants.Chicken.eggStrength;
        
        double rotation = Math.atan2((animal.getY()-getY()),(animal.getX()-getX()));
        double xStrength = Math.cos (rotation)*multiplier;
        double yStrength = Math.sin (rotation)*multiplier;
        animal.knockBack((int)xStrength, (int)yStrength);
    }
}
