import greenfoot.*;
import java.util.*;
public class MyWorld extends World{
    private GreenfootSound sound = new GreenfootSound("mapBackground.mp3");
    boolean start = false;
    public MyWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1); 
        prepare();
    }

    private void prepare(){
        GreenfootSound sound = new GreenfootSound("mapBackground.mp3");
        Chicken animal = new Chicken(1);
        addObject(animal, 669, 673);
        Pig animal2 = new Pig(2);
        addObject(animal2, 316, 371);
        Chicken animal3 = new Chicken(3);
        addObject(animal3, 700, 361);
        Pig animal4 = new Pig(0);
        addObject(animal4, 1074, 360);
    }
    
    public void act(){
        if(!start){
           sound.setVolume(25);
           sound.playLoop(); 
        }
        start=true;
        List<Projectile> list = getObjects(Projectile.class);
        for(Actor a : list){
            if(a.getX()==0||a.getX()>=Constants.Settings.worldWidth-10){
                removeObject(a);
            }
            else if(a.getY()==0||a.getY()>=Constants.Settings.worldHeight-10){
                removeObject(a);
            }
        }
    }
}
