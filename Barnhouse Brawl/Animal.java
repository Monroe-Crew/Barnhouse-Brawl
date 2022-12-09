
import greenfoot.*; 
import java.util.ArrayList;
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
    private ParticleEffect deathParticle;
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
        this.controls = player.getControls();
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
        
        this.deathParticle = new ParticleEffect(80,new Color(230, 136, 73,200));
    }

    public void act() {
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

        //Look at GameWorld timer, and see if equal to -1
        if(((GameWorld)getWorld()).getStartTime()==0){
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
            if(Greenfoot.isKeyDown(controls[5]) && ((double)pushCooldownTimer/60 > Constants.Animal.pushCooldown)){
                basicPush(7);
                pushCooldownTimer = 0;
            }
            if(Greenfoot.isKeyDown(controls[6]) && ((double)specialCooldownTimer/60 > specialCooldown)){
                specialAbility();
                specialCooldownTimer = 0;
            }

            
            
            if(getX()<100 || getX()>1198 || getY()<100 || getY()>870){
                this.dead = true;
            }
            
            if(dead){
            changeDecay(.75);
                frame++;
                animateDeath();
            }
            updatePosition();
        }
    }

    public void basicPush(double multiplier){
        // Larger multiplier = harder push for all characters
        ArrayList<Animal> touching = hitBox.findTouching();
        
        GameWorld world = (GameWorld)getWorld();
        
        multiplier += world.getKnockbackMultiplier();
        
        for(Animal animal : touching){
            if(animal == this) continue;
            double rotation = Math.atan2((animal.getY()-getY()),(animal.getX()-getX()));
            System.out.println(Math.toDegrees(rotation));
            double xStrength = Math.cos (rotation)*multiplier;
            double yStrength = Math.sin (rotation)*multiplier;
            animal.knockBack((int)xStrength, (int)yStrength);

            hit.play();
        }
        //call getObjects(class) or getObjectsAt(x,y,class) on world to get all actors
    }

    public void movement(Direction direction) {
        if(dead) return;
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
        int maxVelocity = 50;

        // Sets max velocity
        xVelocity = xVelocity > maxVelocity ? maxVelocity : xVelocity;
        yVelocity = yVelocity > maxVelocity ? maxVelocity : yVelocity;

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

    public double getAbilityTimer() { return (double)specialCooldownTimer/60; }

    public double getSpecialCooldown() { return specialCooldown; }

    public void setPlacement(int placement){
        player.setPlacement(placement);
    }

    public boolean getDead(){
        return dead;
    }

    public Player getPlayer(){ return player; }

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
