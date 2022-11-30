
import greenfoot.*; 
public class SelectionScreen extends World{
    public SelectionScreen(){    
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        prepare();
    }
    
    private void prepare(){
        SelectorBox selectorBox1 = new SelectorBox(1);
        addObject(selectorBox1,172,655);
        
        SelectorBox selectorBox2 = new SelectorBox(2);
        addObject(selectorBox2,485,655);
        
        SelectorBox selectorBox3 = new SelectorBox(3);
        addObject(selectorBox3,796,655);
        
        SelectorBox selectorBox4 = new SelectorBox(4);
        addObject(selectorBox4,1108,655);
        
        Left left1 = new Left();
        addObject(left1,75,820);
        Right right1 = new Right();
        addObject(right1,270,820);
        
        Left left2 = new Left();
        addObject(left2,387,820);
        Right right2 = new Right();
        addObject(right2,582,820);
        
        Left left3 = new Left();
        addObject(left3,699,820);
        Right right3 = new Right();
        addObject(right3,894,820);
        
        Left left4 = new Left();
        addObject(left4,1011,820);
        Right right4 = new Right();
        addObject(right4,1206,820);
    }
}
