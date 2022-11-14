import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Chicken extends Animal
{
    public Chicken(int playerID){
        super(Constants.Chicken.weight,Constants.Chicken.specialCooldown, playerID);
    }
    
    @Override
    public void specialAbility(){
        GreenfootSound sound = new GreenfootSound("eggThrow.mp3");
        sound.setVolume(25);
        sound.play();
        getWorld().addObject(new Projectile(this),getX(),getY());
    }
}
