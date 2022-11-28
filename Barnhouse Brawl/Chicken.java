import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Chicken extends Animal
{
    private GreenfootImage normal;
    public Chicken(Player player){
        super(Constants.Chicken.weight,Constants.Chicken.specialCooldown, player);
        normal = getImage();
        normal.scale(normal.getWidth()*3, normal.getHeight()*3);
    }
    
    @Override
    public void specialAbility(){
        GreenfootSound sound = new GreenfootSound("eggThrow.mp3");
        sound.setVolume(25);
        sound.play();
        getWorld().addObject(new Projectile(this),getX(),getY());
    }
}
