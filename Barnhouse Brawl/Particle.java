import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends Actor
{
    private double decayInterval;
    private int distanceInterval;
    private int rotation;
    private double transparency = 255;
    public Particle(int distance, int decayTime, int height, int width, Color color){
        this.decayInterval = 255/(decayTime*60);
        this.distanceInterval = (int)(distance/(decayTime*60));
        Random random = new Random();
        this.rotation = random.nextInt(360 + 1);
        GreenfootImage particleImage = new GreenfootImage(height,width);
        particleImage.setColor(color);
        particleImage.fillRect(0,0,height,width);
        setImage(particleImage);
    }

    public void act()
    {
        transparency -= decayInterval;
        if(transparency > 0){
            setRotation(rotation);
            move(distanceInterval);
            setRotation(0);
            getImage().setTransparency((int)transparency);
        } else{
        getWorld().removeObject(this);
        }
    }
}
