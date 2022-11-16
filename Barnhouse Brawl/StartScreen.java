import greenfoot.*; 


public class StartScreen extends World{
    public StartScreen(){    
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        prepare();
    }
    
    private void prepare(){
        StartButton startButton = new StartButton();
        addObject(startButton,598,589);
    }
}
