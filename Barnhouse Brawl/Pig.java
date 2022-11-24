import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pig extends Animal
{
    private int specialAbilityTimer = 0;
    private boolean activated = false;
    public Pig(Player player){
        super(Constants.Pig.weight,Constants.Pig.specialCooldown, player);
    }

    public void act(){
        //Animate air for special
        super.act();
        if(specialAbilityTimer > Constants.Pig.slideLength * 60){
            activated = false; 
            changeDecay(Constants.Animal.friction);
            hitBox.resetSize();
            hitBox.resetIndent();
            GreenfootImage pigImage = new GreenfootImage("Pig.png");
            pigImage.scale(78,138);
            setImage(pigImage);
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
        GreenfootImage muddyPigImage = new GreenfootImage("MuddyPig.png");
        muddyPigImage.scale(78,138);
        setImage(muddyPigImage);
        int actorW = getImage().getWidth();
        int actorH = getImage().getHeight();
        hitBox.setSize(actorW+20, actorH+20);
        hitBox.setIndent(0);

        activated = true;
        specialAbilityTimer = 0;
    }
}
