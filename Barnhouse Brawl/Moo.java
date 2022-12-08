import greenfoot.*; 

public class Moo extends Actor
{
    //GreenfootImage moo;
    GifImage gif = new GifImage("MooTest.gif");
    int time = 0;
    public Moo(){
    }

    public void act() 
    {
        time++;
        setImage(gif.getCurrentImage());
        if(time>80){
            getWorld().removeObject(this);
        }
    }    
}
