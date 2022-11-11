
import greenfoot.*; 
import java.util.*;
public abstract class Animal extends Actor {
    private int width = this.getImage().getWidth();
    private int height = this.getImage().getHeight();
    private int weight;
    private int playerID;
    private double xVelocity;
    private double yVelocity;
    private String[] controls;
    private double specialCooldown;
    private int pushCooldownTimer = 0;
    private int specialCooldownTimer = 0;
    protected Hitbox hitBox;
    protected Hurtbox hurtBox;
    private double decay = .85; // Friction

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

    public Animal(int weight,double specialCooldown, int playerID) {
        this.weight = weight;
        this.specialCooldown = specialCooldown;
        this.playerID = playerID;

        /* Control order:
         * Index 0 - Up
         * Index 1 - Left
         * Index 2 - Down
         * Index 3 - Right
         * Index 4 - Basic Push
         * Index 5 - Special Ability 1
         */
        controls = new String[]{"-","-","-","-","-","-"};
        if(playerID==1) controls = new String[]{"W","A","S","D","Q","E"};
        if(playerID==2) controls = new String[]{"I","J","K","L","U","O"};
    }

    @Override
    public void addedToWorld(World world) {
        // Scales up the image
        GreenfootImage image = getImage();
        image.scale(image.getWidth()*3, image.getHeight()*3);
        setImage(image);
        this.hitBox = new Hitbox(this);
        this.hurtBox = new Hurtbox(this);
        getWorld().addObject(hitBox, 100, 100);
        getWorld().addObject(hurtBox, 100, 100);
    }

    public void act() {
        // Reloads push cooldown
        if(pushCooldownTimer < 10000) pushCooldownTimer += 1;
        if(specialCooldownTimer < 10000) specialCooldownTimer += 1;
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
        if(Greenfoot.isKeyDown(controls[4]) && ((double)pushCooldownTimer/60 > Constants.Animal.pushCooldown)){
            basicPush();
            pushCooldownTimer = 0;
        }
        if(Greenfoot.isKeyDown(controls[5]) && ((double)specialCooldownTimer/60 > specialCooldown)){
            specialAbility();
            specialCooldownTimer = 0;
        }
        
        // Update position using velocities
        updatePosition();
    }

    public void basicPush(){
        // Larger multiplier = harder push for all characters
        int multiplier = 3;
        ArrayList<Animal> touching = hitBox.findTouching();
        for(Animal animal : touching){
            if(animal == this) continue;
            int xStrength = (int)(((animal.getX() - this.getX() > 0 ? 1 : -1) * (double)animal.getX()/this.getX() * 5)/Math.sqrt(animal.getWeight()))*multiplier;
            int yStrength = (int)(((animal.getY() - this.getY() > 0 ? 1 : -1) * (double)animal.getY()/this.getY() * 5)/Math.sqrt(animal.getWeight()))*multiplier;
            animal.knockBack(xStrength, yStrength);
        }
        //call getObjects(class) or getObjectsAt(x,y,class) on world to get all actors
    }

    public void movement(Direction direction) {
        // Physics: The heavier the slower you are
        int maxSpeed = 5/(int)Math.sqrt(weight);
        double responsiveness = Constants.Animal.movementResponsiveness;
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

        // Changes rotation based on velocity.
        int oldRotation = getRotation();
        int turnX = (int)(xVelocity*10000);
        int turnY = (int)(yVelocity*10000);
        
        // 100 is the threshold so it never attemts to turn towards its own coordinates
        if(Math.abs(turnX) > 100 || Math.abs(turnY) > 100){
            turnTowards(getX()+turnX, getY()+turnY);
            setRotation(getRotation() + 90);
        }
        
        // Checks for intersection, if there is then undo rotation
        if(this.getOneIntersectingObject(Animal.class) != null){ 
            setRotation(oldRotation);
        }
        
        if(Math.abs(yVelocity) > maxSpeed) yVelocity = yVelocity > 0 ? maxSpeed : -maxSpeed;
        if(Math.abs(xVelocity) > maxSpeed) xVelocity = xVelocity > 0 ? maxSpeed : -maxSpeed;
    }

    public void updatePosition(){
        int maxVelocity = 50;
        
        // Sets max velocity
        xVelocity = xVelocity > maxVelocity ? maxVelocity : xVelocity;
        yVelocity = yVelocity > maxVelocity ? maxVelocity : yVelocity;
        
        /* 
         * Checks for intersection for individual X and Y positions. 
         * If there is intersection then it goes back to previous position.
        */
       
        int oldX = getX();
        int oldY = getY();
        
        setLocation(getX() + (int)xVelocity, getY());
        if(this.getOneIntersectingObject(Animal.class) != null){ 
            setLocation(oldX, getY());
        }
        
        setLocation(getX(), getY() + (int)yVelocity);
        if(this.getOneIntersectingObject(Animal.class) != null){ 
            setLocation(getX(), oldY);
        }
        
        // Friction
        xVelocity *= decay;
        yVelocity *= decay;
        
        // Adds threshold so it isn't indefinitley multiplying by .9
        if(Math.abs(xVelocity) < .001) xVelocity = 0;
        if(Math.abs(yVelocity) < .001) yVelocity = 0;
    }

    public void knockBack(int xStrength, int yStrength){
        this.xVelocity += xStrength;
        this.yVelocity += yStrength;
    }

    public int getWeight(){
        return this.weight;
    }
    
    public void changeDecay(double decay){
        this.decay = decay;
    }
    
    public abstract void specialAbility();
}
