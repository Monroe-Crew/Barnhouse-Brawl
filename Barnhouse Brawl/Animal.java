
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
        updatePosition();
    }

    public void basicPush(){
        ArrayList<Animal> touching = pushBox.findTouching();
        for(Animal animal : touching){
            int xStrength = (int)((animal.getX() - this.getX()) / Math.sqrt(animal.getWeight()*8));
            int yStrength = (int)((animal.getY() - this.getY()) / Math.sqrt(animal.getWeight()*8));
            animal.knockBack(xStrength, yStrength);
        }
        //call getObjects(class) or getObjectsAt(x,y,class) on world to get all actors
    }

    public void movement(Direction direction) {
        // Physics: The heavier the slower you are
        int maxSpeed = weight;
        int responsiveness = 3;
        switch(direction){
            case UP: 
            yVelocity -= responsiveness;
            break;

            case DOWN: 
             yVelocity += responsiveness;
            break;

            case LEFT: 
            xVelocity -= responsiveness;
            break;

            case RIGHT: 
            xVelocity += responsiveness;

            break;
        }
        
        if(Math.abs(yVelocity) > maxSpeed) yVelocity = yVelocity > 0 ? maxSpeed : -maxSpeed;
        if(Math.abs(xVelocity) > maxSpeed) xVelocity = xVelocity > 0 ? maxSpeed : -maxSpeed;
    }

    public void updatePosition(){
        int oldX = getX();
        int oldY = getY();
        setLocation(getX() + (int)xVelocity, getY());
        if(this.getOneIntersectingObject(Animal.class) != null){ 
            setLocation(oldX, getY());
            xVelocity = 0;
        }
        setLocation(getX(), getY() + (int)yVelocity);
        if(this.getOneIntersectingObject(Animal.class) != null){ 
            setLocation(getX(), oldY);
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
