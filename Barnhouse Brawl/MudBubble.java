import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MudBubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MudBubble extends EnviornmentalAnimation
{
    //GreenfootImage moo;
    GifImage gif;
    int width;
    int height;
    
    //int time = 0;
    public MudBubble(){
        gif  = new GifImage("MudGif.gif");
        width = getImage().getWidth()*2;
        height = getImage().getHeight()*2;
    }

    public void act() 
    {
        if(Greenfoot.getRandomNumber(10) == 0){
            setImage(gif.getCurrentImage());
        getImage().scale(width,height);
        }
        

        /*
        if(time>80){
            getWorld().removeObject(this);
        }
        */
    }    
} 
