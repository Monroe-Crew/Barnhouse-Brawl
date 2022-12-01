import greenfoot.*; 
public class Moo extends Actor
{
    GreenfootImage moo;
    int width;
    int height;
    int time = 0;
    public Moo(){
        moo = new GreenfootImage(getImage());
        getImage().scale(128,32);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }

    public void act() 
    {
        time++;
        GreenfootImage placeholder = new GreenfootImage(moo);
        double tempW = 128.0;
        double tempH = 32.0;
        placeholder.scale((int)tempW, (int)tempH);
        setImage(placeholder);
        if(time>100){
            getWorld().removeObject(this);
        }
    }    
}
