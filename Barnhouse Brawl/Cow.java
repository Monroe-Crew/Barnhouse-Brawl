import greenfoot.*; 

public class Cow extends Animal
{
    private GreenfootImage normal;
    public Cow(Player player){
        super(Constants.Cow.weight,Constants.Cow.specialCooldown, player);
        normal = getImage();
        normal.scale(normal.getWidth()*3, normal.getHeight()*3);
    }

    public void act() 
    {
        super.act();
    }    
    @Override
    public void specialAbility(){
        
    }
}
