
import greenfoot.*; 
import java.util.*;
public class Animal extends Actor {
    private int weight;
    private int playerID;
    private double xVelocity;
    private double yVelocity;
    private String[] controls;
    private int pushCooldown = 0;
    private Hitbox hitBox;
    private Hurtbox hurtBox;

    public static enum AnimalType {
        CHICKEN,
        PIG
    }

    private enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Animal(int weight, int playerID) {
        this.weight = weight;
        this.playerID = playerID;

        /* Control order:
         * Index 0 - Up
         * Index 1 - Left
         * Index 2 - Down
         * Index 3 - Right
         * Index 4 - Basic Push
         */
        controls = new String[]{"-","-","-","-","-"};
        if(playerID==1) controls = new String[]{"W","A","S","D","Q"};
        if(playerID==2) controls = new String[]{"I","J","K","L","U"};
    }

    @Override
    public void addedToWorld(World world) {
        this.hitBox = new Hitbox(this);
        this.hurtBox = new Hurtbox(this);
        getWorld().addObject(hitBox, 100, 100);
        getWorld().addObject(hurtBox, 100, 100);
    }

    public void act() {
        if(pushCooldown < 11) pushCooldown += 1;

        if(Greenfoot.isKeyDown(controls[0])){
            movement(Direction.UP);
        }
        if(Greenfoot.isKeyDown(controls[1])){
            movement(Direction.LEFT);
        }
        if(Greenfoot.isKeyDown(controls[2])){
            movement(Direction.DOWN);
        }
        if(Greenfoot.isKeyDown(controls[3])){
            movement(Direction.RIGHT);
        }
        if(Greenfoot.isKeyDown(controls[4]) && pushCooldown > 10){
            basicPush();
            pushCooldown = 0;
        }
        updatePosition();
    }

    public void basicPush(){
        ArrayList<Animal> touching = hitBox.findTouching();
        for(Animal animal : touching){
            int xStrength = (int)((animal.getX() - this.getX()) / Math.sqrt(animal.getWeight()*8));
            int yStrength = (int)((animal.getY() - this.getY()) / Math.sqrt(animal.getWeight()*8));
            animal.knockBack(xStrength, yStrength);
        }
        //call getObjects(class) or getObjectsAt(x,y,class) on world to get all actors
    }

    public void movement(Direction direction) {
        // Physics: The heavier the slower you are
        int maxSpeed = 5/(int)Math.sqrt(weight);
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

        xVelocity *= .8;
        yVelocity *= .8;
    }

    public void knockBack(int xStrength, int yStrength){
        this.xVelocity += xStrength;
        this.yVelocity += yStrength;
    }

    public int getWeight(){
        return this.weight;
    }
}
