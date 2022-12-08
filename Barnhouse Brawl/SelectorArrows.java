import greenfoot.*; 
public class SelectorArrows extends BobbingImage{
    private int freeze = 0;
    
    public SelectorArrows(){
        super(Constants.SelectorScreen.arrowAmplitude, Constants.SelectorScreen.arrowFrequency);
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

    public void freezeAnimation(int time){
        freeze=time;
    }
}
