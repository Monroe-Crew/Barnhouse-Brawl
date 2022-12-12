import greenfoot.*; 

public class Cow extends Animal
{
    private GreenfootImage normal;
    private int specialAbilityTimer = 0;
    private boolean activated = false;
    public Cow(Player player){
        super(Constants.Cow.weight,Constants.Cow.specialCooldown, player);
        switch(player.getColor()){
            case RED :
                setImage("Cow/RedCow.png");
                break;
            case BLUE :
                setImage("Cow/BlueCow.png");
                break;
            case YELLOW :
                setImage("Cow/YellowCow.png");
                break;
            case GREEN :
                setImage("Cow/GreenCow.png");
                break;
        }
        normal = getImage();
        normal.scale(normal.getWidth()*3, normal.getHeight()*3);
    }

    public void act() 
    {
        super.act();
        if(specialAbilityTimer > Constants.Cow.mooLength * 60){
            activated = false; 
            hitBox.resetSize();
            hitBox.resetIndent();
        }
        if(activated){
            walkingParticle.generateParticles(20);
            specialAbilityTimer++;
            basicPush(Constants.Cow.mooStrength);
        }
    }    
    @Override
    public void specialAbility(){
        //Moo moo = new Moo();
        //getWorld().addObject(moo, getX(), getY());
        getWorld().addObject(new ExpandFadeImage(new GreenfootImage("MooAura.png")), getX(), getY());
        int actorW = (int)(getImage().getWidth()*2);
        int actorH = (int)(getImage().getHeight()*2);
        hitBox.setSize(actorW+30, actorH+30);
        hitBox.setIndent(0);
        activated = true;
        specialAbilityTimer = 0;
        
    }
}
