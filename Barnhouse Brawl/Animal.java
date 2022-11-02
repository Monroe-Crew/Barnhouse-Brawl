
import greenfoot.*; 
import java.util.*;
public class Animal extends Actor {
    private int weight;
    private int playerID;
    private double xVelocity;
    private double yVelocity;
    private int pushCooldown = 0;
    private Hitbox pushBox;
    private Hurtbox hurtBox;

    public Animal(int weight, int playerID) {
        this.weight = weight;
        this.playerID = playerID;
        //Hitbox = attacker
        //Hurtbox = attacked
    }

    @Override
    public void addedToWorld(World world) {
        this.pushBox = new Hitbox(this);
        this.hurtBox = new Hurtbox(this);
        getWorld().addObject(pushBox, 100, 100);
        getWorld().addObject(hurtBox, 100, 100);
    }

    enum AnimalType {
        CHICKEN,
        PIG
    }
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public void act() {
        if(pushCooldown < 11) pushCooldown += 1;
        updatePosition();

        if(playerID==1){
            //Player 1 controls
            // Q E R F1
            if(Greenfoot.isKeyDown("W")){
                movement(Direction.UP);
            }
            if(Greenfoot.isKeyDown("A")){
                movement(Direction.LEFT);
            }
            if(Greenfoot.isKeyDown("S")){
                movement(Direction.DOWN);
            }
            if(Greenfoot.isKeyDown("D")){
                movement(Direction.RIGHT);
            }
            if(Greenfoot.isKeyDown("E") && pushCooldown > 10){
                basicPush();
                pushCooldown = 0;
            }
        }
        if(playerID==2){
            //Player 2 controls
            // U O P F2
            if(Greenfoot.isKeyDown("I")){
                movement(Direction.UP);
            }
            if(Greenfoot.isKeyDown("J")){
                movement(Direction.LEFT);
            }
            if(Greenfoot.isKeyDown("K")){
                movement(Direction.DOWN);
            }
            if(Greenfoot.isKeyDown("L")){
                movement(Direction.RIGHT);
            }
        }
    }

    public void basicPush(){
        ArrayList<Animal> touching = pushBox.findTouching();
        for(Animal animal : touching){
            int xStrength = (animal.getX() - this.getX()) / (animal.getWeight() * 2);
            int yStrength = (animal.getY() - this.getY()) / (animal.getWeight() * 2);
            animal.knockBack(xStrength, yStrength);
        }
        //call getObjects(class) or getObjectsAt(x,y,class) on world to get all actors
    }

    public void movement(Direction direction) {
        // Physics: The heavier the slower you are
        int maxSpeed = weight*3;
        switch(direction){
            case UP: 
            if(Math.abs(yVelocity) < maxSpeed) yVelocity -= 1;
            break;

            case DOWN: 
            if(Math.abs(yVelocity) < maxSpeed) yVelocity += 1;
            break;

            case LEFT: 
            if(Math.abs(xVelocity) < maxSpeed) xVelocity -= 1;
            break;

            case RIGHT: 
            if(Math.abs(xVelocity) < maxSpeed) xVelocity += 1;

            break;
        }
    }

    public void updatePosition(){
        setLocation(getX() + (int)xVelocity, getY() + (int)yVelocity);
        Actor intersectingActor = this.getOneIntersectingObject(Animal.class);
        if(intersectingActor != null){ 
            if(xVelocity < 0){ 
                System.out.println(getX() - intersectingActor.getX());
                int actorDiff =  Math.abs(getX() - intersectingActor.getX() + );
                setLocation(getX() + actorDiff, getY());
            }
            if(xVelocity > 0){ 
                System.out.println("asdf");
                setLocation(getX() - Math.abs((getX() - intersectingActor.getX())/2), getY());
            }
            if(yVelocity < 0){ 
                System.out.println("asdf");
                setLocation(getX(), getY() + Math.abs((getY() - intersectingActor.getY())/2));
            }
            if(yVelocity > 0){ 
                System.out.println("asdf");
                setLocation(getX(), getY() - Math.abs((getY() - intersectingActor.getY())/2));
            }
            xVelocity = 0;
            yVelocity = 0;
        }
        
        xVelocity *= .9;
        yVelocity *= .9;
    }

    public void knockBack(int xStrength, int yStrength){
        this.xVelocity += xStrength;
        this.yVelocity += yStrength;
    }

    public int getWeight(){
        return this.weight;
    }
}
