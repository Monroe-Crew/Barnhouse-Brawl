import greenfoot.*; 
public class SelectorArrows extends Actor{
    private GreenfootImage arrow;
    private int width;
    private int height;
    private int frame = 0;
    private int time = 0;
    private int freeze = 0;
    public SelectorArrows(){
        arrow = new GreenfootImage(getImage());
        getImage().scale(30,25);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }  

    public void act(){
        time++;
        
        if(freeze == 0){
            animate();
        }
        else{
            freeze--;
        }
    }

    public void changeArrow(){
        //Make arrow bigger
        //Set image to diffrent image when bigger
        freezeAnimation(5);
        getImage().scale(getImage().getWidth()*2,getImage().getHeight()*2);
    }

    public void animate(){
        frame++;
        GreenfootImage placeholder = new GreenfootImage(arrow);
        double tempW = 30 + Constants.SelectorScreen.arrowAmplitude*Math.abs(width * Math.sin(time/Constants.SelectorScreen.arrowFrequency));
        double tempH = 30 + Constants.SelectorScreen.arrowAmplitude*Math.abs(height * Math.sin(time/Constants.SelectorScreen.arrowFrequency));
        placeholder.scale((int)tempW, (int)tempH);
        setImage(placeholder);
        frame = 0;
        if(frame == Integer.MAX_VALUE) frame = 0;
    }

    public void freezeAnimation(int time){
        freeze=time;
    }
}
