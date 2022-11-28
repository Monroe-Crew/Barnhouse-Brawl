import greenfoot.*; 
public class SelectionScreen extends World{
    public SelectionScreen(){    
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        prepare();
    }
    
    private void prepare(){
        Left left = new Left();
        addObject(left,338,497);
        Right right = new Right();
        addObject(right,883,479);
    }
}
