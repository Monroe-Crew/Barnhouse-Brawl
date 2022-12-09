import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class ExpandFadeImage extends TempImage{
    private GreenfootImage image;
    private int opacity=255;
    private int scale=100;
    public ExpandFadeImage(){
        super();
        this.image = this.getImage();
    }
    
    public ExpandFadeImage(GreenfootImage image){
        super();
        this.image = image;
    }
    
    public void animate(){
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
        super.act();
    }
}
