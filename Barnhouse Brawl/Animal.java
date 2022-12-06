
import greenfoot.*; 
import java.util.*;
public abstract class Animal extends Actor {
    private int width = getImage().getWidth();
    private int height = getImage().getHeight();
    private int weight;
    private Player player;
    private double xVelocity;
    private double yVelocity;
    private String[] controls;
    private double specialCooldown;
    private int pushCooldownTimer = 0;
    private int specialCooldownTimer = 0;
    private double decay = Constants.Animal.friction;
    private static double knockbackMultiplier = 1;
    private int frame = 0;
    protected ParticleEffect walkingParticle;
    protected boolean dead = false;
    protected Hitbox hitBox;
    protected Hurtbox hurtBox;
    private boolean start = false;

    GreenfootSound hit = new GreenfootSound("hit.wav");

    protected enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Animal(int weight,double specialCooldown, Player player) {
        this.weight = weight;
        this.specialCooldown = specialCooldown;
        this.specialCooldownTimer = (int)(specialCooldown*60/2);
        this.player = player;

        /* Control order:
         * Index 0 - Up
         * Index 1 - Left
         * Index 2 - Down
         * Index 3 - Right
         * Index 4 - Basic Push
         * Index 5 - Special Ability 1
         */
        int playerID = player.getPlayerID();
        controls = new String[]{"-","-","-","-","-","-"};
        if(playerID==1) controls = new String[]{"W","A","S","D","Q","E"};
        if(playerID==2) controls = new String[]{"UP","LEFT","DOWN","RIGHT","B","N"};
        if(playerID==3) controls = new String[]{"I","J","K","L","U","O"};
        if(playerID==4) controls = new String[]{"5","1","2","3","7","8"};
    }

    @Override
    public void addedToWorld(World world) {
        // Scales up the image
        this.hitBox = new Hitbox(this);
        this.hurtBox = new Hurtbox(this);
        getWorld().addObject(hitBox, 100, 100);
        getWorld().addObject(hurtBox, 100, 100);

        this.walkingParticle = new ParticleEffect(80,new Color(230, 136, 73,200));
        getWorld().addObject(walkingParticle,getX(),getY());
    }

    public void act() {
        //Look at GameWorld timer, and see if equal to -1
        if(GameWorld.getStartTime()==-1){
            // Reloads push cooldown
            if(pushCooldownTimer < Constants.Animal.pushCooldown*60+1) pushCooldownTimer += 1;
            if(specialCooldownTimer < specialCooldown*60+1) specialCooldownTimer += 1;

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

            if(getX()<100 || getX()>1198 || getY()<100 || getY()>870){
                //remove();
                this.dead = true;
            }

            if(dead){
                frame++;
                animateDeath();
            }

            // Update position using velocities
            updatePosition();
        }
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

            hit.play();
        }
        //call getObjects(class) or getObjectsAt(x,y,class) on world to get all actors
    }

    public void specialMovement(){
        double speed = ((1.0/weight)*Constants.Animal.movementSpeed);
        System.out.println("Speed " + speed);
        System.out.println("xVelocity " + xVelocity);
        System.out.println("yVelocity " + yVelocity);
        if(yVelocity>0){
            yVelocity += speed;
        }
        else{
            yVelocity -= speed;
        }
        if(xVelocity>0){
            xVelocity += speed;
        }
        else{
            xVelocity -= speed;
        }

        walkingParticle.setLocation(getX(),getY());
        walkingParticle.generateParticles(3);
    }

    public void movement(Direction direction) {
        double oldXVelocity = 0 + xVelocity;
        double oldYVelocity = 0 + yVelocity;
        // Physics: The heavier the slower you are
        double speed = ((1.0/weight)*Constants.Animal.movementSpeed);
        switch(direction){
            case UP: 
            yVelocity -= speed;
            break;

            case DOWN: 
            yVelocity += speed;
            break;

            case LEFT: 
            xVelocity -= speed;
            break;

            case RIGHT: 
            xVelocity += speed;
            break;
        }

        // Changes rotation based on velocity.
        int oldRotation = getRotation();
        int turnX = (int)(xVelocity*1000000);
        int turnY = (int)(yVelocity*1000000);

        // 100 is the threshold so it never attemts to turn towards its own coordinates
        if(Math.abs(turnX) > 100 || Math.abs(turnY) > 100){
            turnTowards(getX()+turnX, getY()+turnY);
            setRotation(getRotation() + 90);
        }

        // Checks for intersection, if there is then undo rotation
        if(this.getOneIntersectingObject(Animal.class) != null || this.getOneIntersectingObject(Obstacles.class) != null ){ 
            setRotation(oldRotation);
        }

        walkingParticle.setLocation(getX(),getY());
        walkingParticle.generateParticles(3);
    }

    public void updatePosition(){
        if(dead) return;
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
        if(this.getOneIntersectingObject(Animal.class) != null || this.getOneIntersectingObject(Obstacles.class) != null){ 
            setLocation(oldX, getY());
        }

        setLocation(getX(), getY() + (int)yVelocity);
        if(this.getOneIntersectingObject(Animal.class) != null || this.getOneIntersectingObject(Obstacles.class) != null){ 
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
        this.xVelocity += (double)xStrength*knockbackMultiplier;
        this.yVelocity += (double)yStrength*knockbackMultiplier;
    }

    public void setSpeed(double xStrength, double yStrength){
        this.xVelocity *= xStrength;
        this.yVelocity *= yStrength;
    }

    public double getXVelocity(){
        return this.xVelocity;
    }

    public double getYVelocity(){
        return this.yVelocity;
    }

    public int getWeight(){
        return this.weight;
    }

    public void changeDecay(double decay){
        this.decay = decay;
    }

    public static void changeKnockbackMultiplier(double multiplier){
        knockbackMultiplier = multiplier;
    }

    public void remove(){
        player.setPlacement(getWorld().getObjects(Animal.class).size());
        getWorld().removeObject(hurtBox);
        getWorld().removeObject(walkingParticle);
        getWorld().removeObject(hitBox);
        getWorld().removeObject(this);        
    }

    public void setPlacement(int placement){
        player.setPlacement(placement);
    }

    public void animateDeath(){
        GreenfootImage image = getImage();
        //System.out.println(frame);
        if(image.getWidth()*.99 < 1 || image.getHeight()*.99 < 1) {
            remove();
        }else{
            int width =  (int)(image.getWidth()*.99);
            int height =  (int)(image.getHeight()*.99);
            image.scale(width, height);
            setImage(image);
        }
    }

    public abstract void specialAbility();
}
