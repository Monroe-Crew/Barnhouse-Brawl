import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class CountDown extends TempImage{
    private GreenfootImage image;
    private int opacity;
    private int scale;
    public CountDown(String name){
        super(name);
        setImage(name);
        opacity=255;
        scale=100;
        image = this.getImage();
    }
    public void act(){
        GreenfootImage placeholder = new GreenfootImage(image);
        placeholder.scale(scale,scale);
        setImage(placeholder);
        getImage().setTransparency(opacity);
        scale+=4;
        opacity-=5;
        if(opacity==0){
            getWorld().removeObject(this);
        }
    }
    public void addedToWorld(World world){
        act();
    }
}
