import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pig extends Animal
{
    
    public Pig(int playerID){
        super(Constants.Pig.weight, playerID);
    }
    
    public void specialAbility(){
        changeDecay(10);
    }
}
