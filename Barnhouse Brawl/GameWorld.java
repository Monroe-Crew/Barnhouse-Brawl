import greenfoot.*;
import java.util.*;
public abstract class GameWorld extends World
{
    private GreenfootSound backgroundMusic;
    boolean start = false;
    List<Animal> animalList;
    
    public GameWorld(GreenfootSound backgroundMusic)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        this.backgroundMusic = backgroundMusic;
        animalList = new ArrayList<>();

        Animal.changeKnockbackMultiplier(Constants.Animal.defaultKnockback);
    }
    
    protected void prepare(){
        setPaintOrder(Animal.class, ParticleEffect.class);
    }
    
    public void act(){
        if(!start){
            Music.playMusic(backgroundMusic);
        }
        start=true;
        List<Projectile> projectileList = getObjects(Projectile.class);
        for(Actor a : projectileList){
            if(a.getX()==0||a.getX()>=Constants.Settings.worldWidth-10){
                removeObject(a);
            }
            else if(a.getY()==0||a.getY()>=Constants.Settings.worldHeight-10){
                removeObject(a);
            }
        }
        if(getObjects(Animal.class).size() == 1){
            Music.playMusic(null);
            for(Animal animal : getObjects(Animal.class)){
                animal.setPlacement(1);
            }
            Greenfoot.setWorld(new EndScreen());
        }
    }
}
