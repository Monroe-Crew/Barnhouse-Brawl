import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Goat extends Animal{  
    private GreenfootImage normal;
    private int specialAbilityTimer = 0;
    private ParticleEffect dashingParticle;
    private boolean activated = false;
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
            changeDecay(Constants.Animal.friction);
        }
        if(activated){
            setRotation(getRotation()-90);
            move(10);
            setRotation(getRotation()+90);
            dashingParticle.setLocation(getX(),getY());
            dashingParticle.generateParticles(20);
            specialAbilityTimer++;
            basicPush(3);
        }

    }    

    public void movement(Direction direction){
        if(!activated) super.movement(direction);
    }
    
    @Override
    public void specialAbility(){
        //Straight forward dash for 3 seconds
        //Make to where you can't move
        int actorW = getImage().getWidth();
        int actorH = getImage().getHeight();
        activated = true;
        specialAbilityTimer = 0;
    }
}
