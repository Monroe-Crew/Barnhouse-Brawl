import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Goat extends Animal{  
    private GreenfootImage normal;
    private int specialAbilityTimer = 0;
    private ParticleEffect dashingParticle;
    private boolean activated = false;
    private boolean goatSpecial = false;
    public Goat(Player player){
        super(Constants.Goat.weight,Constants.Goat.specialCooldown, player);
        switch(player.getColor()){
            case RED :
            setImage("Goat/RedGoat.png");
            break;
            case BLUE :
            setImage("Goat/BlueGoat.png");
            break;
            case YELLOW :
            setImage("Goat/YellowGoat.png");
            break;
            case GREEN :
            setImage("Goat/GreenGoat.png");
            break;
        }
        dashingParticle = new ParticleEffect(80,new Color(255, 255, 255,255));
        normal = getImage();
        normal.scale(normal.getWidth()*3, normal.getHeight()*3);
    }  
    
    public void addedToWorld(World world){
        super.addedToWorld(world);
        world.addObject(dashingParticle, getX(), getY());
    }

    public void act() {
        super.act();
        if(specialAbilityTimer > Constants.Goat.dashLength * 60){
            activated = false; 
            goatSpecial = false;
            changeDecay(Constants.Animal.friction);
        }
        if(activated){
            dashingParticle.generateParticles(20);
            dashingParticle.setLocation(getX(),getY());
            specialAbilityTimer++;
            basicPush();
        }
        if(goatSpecial){
            specialMovement(getRotation());
        }
    }    

    @Override
    public void specialAbility(){
        //Straight forward dash for 3 seconds
        //Make to where you can't move
        double multiplyer = (1.0/Math.max(getXVelocity(), getYVelocity()));
        setSpeed(getXVelocity()*multiplyer, getYVelocity()*multiplyer);
        changeDecay(.95);
        goatSpecial = true;
        int actorW = getImage().getWidth();
        int actorH = getImage().getHeight();
        activated = true;
        specialAbilityTimer = 0;
    }
}
