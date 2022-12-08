import greenfoot.*;
public abstract class TempImage extends Actor{
    protected int frame;
    protected int time;
    protected GreenfootImage image;
    private boolean animate = true;

    public TempImage(){
        this.image = getImage();
    }


    public void act(){
        time++;
        if(animate){animate();}
    }
    
    public void changeImage(GreenfootImage image){
        this.image = image;
        setImage(image);
    }

    public abstract void animate();

    public void stopAnimation(){
        animate=false;
    }
    
    public void startAnimation(){
        animate=true;
    }
    public void scale(int w, int h){
        image.scale(w,h);
        setImage(image);
    }
}
