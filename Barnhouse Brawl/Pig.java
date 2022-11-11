import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pig extends Animal
{
    private int specialAbilityTimer = 0;
    private boolean activated = false;
    public Pig(int playerID){
        super(Constants.Pig.weight,Constants.Pig.specialCooldown, playerID);
    }

    public void act(){
        //Animate air for special
        super.act();
        if(specialAbilityTimer > Constants.Pig.slideLength * 60){
            activated = false; 
            changeDecay(.85);
            hitBox.resetSize();
            hitBox.resetIndent();
        }
        if(activated){
            specialAbilityTimer++;
            basicPush();
        }
    }

    public void specialAbility(){
        changeDecay(1);

        int actorW = getImage().getWidth();
        int actorH = getImage().getHeight();
        hitBox.setSize(actorW+20, actorH+20);
        hitBox.setIndent(0);

        activated = true;
        specialAbilityTimer = 0;
    }
}
