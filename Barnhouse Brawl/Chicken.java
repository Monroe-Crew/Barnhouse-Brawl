import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Chicken extends Animal
{
    public Chicken(int playerID){
        super(Constants.Chicken.weight,30, playerID);
    }
    
    @Override
    public void specialAbility(){
        getWorld().addObject(new Projectile(this),getX(),getY());
    }
}
