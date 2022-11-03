
import greenfoot.*; 
import java.util.*;
public class Animal extends Actor {
    private int weight;
    private int playerID;
    private double xVelocity;
    private double yVelocity;
    private String[] controls;
    private int pushCooldown = 0;
    private int w = this.getImage().getWidth();
    private int h = this.getImage().getHeight();
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
            hitBox.turn(Math.abs((90-hitBox.getRotation())));
            hitBox.setxAdjust(0);
            hitBox.setyAdjust(20);
        }
        if(Greenfoot.isKeyDown(controls[1])){
            movement(Direction.LEFT);
            hitBox.turn(Math.abs((180-hitBox.getRotation())));
            hitBox.setxAdjust(20);
            hitBox.setyAdjust(0);
        }
        if(Greenfoot.isKeyDown(controls[2])){
            movement(Direction.DOWN);
            hitBox.turn(Math.abs((270-hitBox.getRotation())));
            hitBox.setxAdjust(0);
            hitBox.setyAdjust(-20);
        }
        if(Greenfoot.isKeyDown(controls[3])){
            movement(Direction.RIGHT);
            hitBox.turn(Math.abs((360-hitBox.getRotation())));
            hitBox.setxAdjust(-20);
            hitBox.setyAdjust(0);
        }
        if(Greenfoot.isKeyDown(controls[4]) && pushCooldown > 10){
            basicPush();
            pushCooldown = 0;
        }
        updatePosition();
    }

    public void basicPush(){
        int multiplier = 3;
        ArrayList<Animal> touching = hitBox.findTouching();
        for(Animal animal : touching){
            if(animal == this) continue;
            System.out.println(((animal.getX() - this.getX()) < 0 ? -1 : 1) * (double)animal.getX()/this.getX() * 5);
            int xStrength = (int)((((animal.getX() - this.getX()) < 0 ? -1 : 1) * (double)animal.getX()/this.getX() * 5)/Math.sqrt(animal.getWeight()))*multiplier;
            int yStrength = (int)((((animal.getY() - this.getY()) < 0 ? -1 : 1) * (double)animal.getY()/this.getY() * 5)/Math.sqrt(animal.getWeight()))*multiplier;
            animal.knockBack(xStrength, yStrength);
        }
        //call getObjects(class) or getObjectsAt(x,y,class) on world to get all actors
    }

    public void movement(Direction direction) {
        // Physics: The heavier the slower you are
        int maxSpeed = 5/(int)Math.sqrt(weight);
        int responsiveness = 1;
        switch(direction){
            case UP: 
            if(yVelocity > -maxSpeed) yVelocity -= responsiveness;
            break;

            case DOWN: 
            if(yVelocity < maxSpeed) yVelocity += responsiveness;
            break;

            case LEFT: 
            if(xVelocity > -maxSpeed) xVelocity -= responsiveness;
            break;

            case RIGHT: 
            if(xVelocity < maxSpeed) xVelocity += responsiveness;
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
            yVelocity=0;
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
