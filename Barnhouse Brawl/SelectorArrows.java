import greenfoot.*; 
public class SelectorArrows extends Actor{
    GreenfootImage arrow;
    int width;
    int height;
    int frame = 0;
    int time = 0;
    int freeze = 0;
    public SelectorArrows(){
        arrow = new GreenfootImage(getImage());
        getImage().scale(30,25);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }  

    public void act(){
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
        getImage().scale(100,100);
    }

    public void animate(){
        frame++;
        time++;
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
