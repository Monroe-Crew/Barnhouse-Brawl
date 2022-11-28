import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pig extends Animal
{
    private GreenfootImage normal;
    private GreenfootImage muddy;
    private int specialAbilityTimer = 0;
    private boolean activated = false;
    public Pig(Player player){
        super(Constants.Pig.weight,Constants.Pig.specialCooldown, player);
        normal = getImage();
        muddy = new GreenfootImage("MuddyPig.png");
        normal.scale(normal.getWidth()*3, normal.getHeight()*3);
        muddy.scale(muddy.getWidth()*3, muddy.getHeight()*3);
    }

    public void act(){
        //Animate air for special
        super.act();
        if(specialAbilityTimer > Constants.Pig.slideLength * 60){
            activated = false; 
            changeDecay(Constants.Animal.friction);
            hitBox.resetSize();
            hitBox.resetIndent();
            setImage(normal);
        }
        if(activated){
            walkingParticle.generateParticles(20);
            specialAbilityTimer++;
            basicPush();
        }

    }

    public void specialAbility(){
        changeDecay(.95);
        GreenfootSound sound = new GreenfootSound("oink.wav");
        sound.play();
        setImage(muddy);
        int actorW = getImage().getWidth();
        int actorH = getImage().getHeight();
        hitBox.setSize(actorW+20, actorH+20);
        hitBox.setIndent(0);

        activated = true;
        specialAbilityTimer = 0;
    }
}
