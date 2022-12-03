import java.util.*;
import greenfoot.*; 
public class SelectionScreen extends World{
    public SelectionScreen(){    
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        prepare();
    }

    private void prepare(){
        SelectorBox selectorBox1 = new SelectorBox(1);
        addObject(selectorBox1,170,655);

        SelectorBox selectorBox2 = new SelectorBox(2);
        addObject(selectorBox2,483,655);

        SelectorBox selectorBox3 = new SelectorBox(3);
        addObject(selectorBox3,794,655);

        SelectorBox selectorBox4 = new SelectorBox(4);
        addObject(selectorBox4,1106,655);
    }
}
