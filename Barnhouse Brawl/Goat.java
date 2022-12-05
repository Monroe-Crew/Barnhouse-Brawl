import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Goat extends Animal{  
    private GreenfootImage normal;
    private int specialAbilityTimer = 0;
    private boolean activated = false;
    private boolean goatSpecial = false;
    public Goat(Player player){
        super(Constants.Goat.weight,Constants.Goat.specialCooldown, player);
        int playerID = player.getPlayerID();
        switch(playerID){
            case 1 :
                setImage("RedGoat.png");
            case 2 :
                setImage("BlueGoat.png");
            case 3 :
                setImage("YellowGoat.png");
            case 4 :
                setImage("GreenGoat.png");
        }
        normal = getImage();
        normal.scale(normal.getWidth()*3, normal.getHeight()*3);
    }  

    public void act() {
        super.act();
        if(specialAbilityTimer > Constants.Goat.dashLength * 60){
            activated = false; 
            goatSpecial = false;
            changeDecay(Constants.Animal.friction);
        }
        if(activated){
            walkingParticle.generateParticles(20);
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
