import greenfoot.*; 
public class SelectorArrows extends Actor{
    GreenfootImage arrow;
    int width;
    int height;
    int playerID;
    int frame = 0;
    int time = 0;
    public SelectorArrows(int ID){
        arrow = new GreenfootImage(getImage());
        getImage().scale(30,25);
        playerID = ID;
        width = getImage().getWidth();
        height = getImage().getHeight();
    }  

    public void act(){
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
}
