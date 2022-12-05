import greenfoot.*; 

public class Cow extends Animal
{
    private GreenfootImage normal;
    private int specialAbilityTimer = 0;
    private boolean activated = false;
    public Cow(Player player){
        super(Constants.Cow.weight,Constants.Cow.specialCooldown, player);
        int playerID = player.getPlayerID();
        switch(playerID){
            case 1 :
                setImage("Cow/RedCow.png");
                break;
            case 2 :
                setImage("Cow/BlueCow.png");
                break;
            case 3 :
                setImage("Cow/YellowCow.png");
                break;
            case 4 :
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
            basicPush();
        }
    }    
    @Override
    public void specialAbility(){
        Moo moo = new Moo();
        getWorld().addObject(moo, getX(), getY());
        int actorW = getImage().getWidth();
        int actorH = getImage().getHeight();
        hitBox.setSize(actorW+30, actorH+30);
        hitBox.setIndent(0);
        activated = true;
        specialAbilityTimer = 0;
    }
}
