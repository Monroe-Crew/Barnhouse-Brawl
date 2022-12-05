import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Chicken extends Animal
{
    private GreenfootImage normal;
    int playerID;
    public Chicken(Player player){
        super(Constants.Chicken.weight,Constants.Chicken.specialCooldown, player);
        playerID = player.getPlayerID();
        switch(playerID){
            case 1 :
                setImage("Chicken/RedChicken.png");
                break;
            case 2 :
                setImage("Chicken/BlueChicken.png");
                break;
            case 3 :
                setImage("Chicken/YellowChicken.png");
                break;
            case 4 :
                setImage("Chicken/GreenChicken.png");
                break;
        }
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
