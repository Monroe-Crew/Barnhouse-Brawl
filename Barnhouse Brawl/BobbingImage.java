import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BobbingImage extends TempImage
{
    private double amplitude;
    private double frequency;
    public BobbingImage(double amplitude, double frequency){
        super();
        this.amplitude = amplitude;
        this.frequency = frequency;
    }
    
    public BobbingImage(GreenfootImage image, double amplitude, double frequency){
        super();
        this.amplitude = amplitude;
        this.frequency = frequency;
        
        changeImage(image);
    }
    
    
    
    @Override
    public void animate(){
        frame++;
        GreenfootImage placeholder = new GreenfootImage(image);
        double tempW = placeholder.getWidth() + amplitude*Math.abs(image.getWidth() * Math.sin(time/frequency));
        double tempH = placeholder.getHeight() + amplitude*Math.abs(image.getWidth() * Math.sin(time/frequency));
        placeholder.scale((int)tempW, (int)tempH);
        setImage(placeholder);
        frame = 0;
        if(frame == Integer.MAX_VALUE) frame = 0;
    }
}
