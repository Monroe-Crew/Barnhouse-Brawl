import greenfoot.*; 

public class Moo extends Actor
{
    GreenfootImage moo;
    GifImage gif = new GifImage("MooTest.gif");
    //int width;
    //int height;
    int time = 0;
    public Moo(){
        //gif = new GifImage(getImage());
        //getImage().scale(128,32);
        //width = getImage().getWidth();
        //height = getImage().getHeight();
    }

    public void act() 
    {
        time++;
        setImage(gif.getCurrentImage());
        //GreenfootImage placeholder = new GreenfootImage(moo);
        //double tempW = 128.0;
        //double tempH = 32.0;
        //placeholder.scale((int)tempW, (int)tempH);
        //setImage(placeholder);
        if(time>80){
            getWorld().removeObject(this);
        }
    }    
}
