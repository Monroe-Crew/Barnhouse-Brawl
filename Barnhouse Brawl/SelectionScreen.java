import java.util.*;
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

        Left left1 = new Left(1, ArrowDirection.LEFT);
        addObject(left1,75,820);
        Right right1 = new Right(1, ArrowDirection.RIGHT);
        addObject(right1,270,820);

        Left left2 = new Left(2, ArrowDirection.LEFT);
        addObject(left2,387,820);
        Right right2 = new Right(2, ArrowDirection.RIGHT);
        addObject(right2,582,820);

        Left left3 = new Left(3, ArrowDirection.LEFT);
        addObject(left3,699,820);
        Right right3 = new Right(3, ArrowDirection.RIGHT);
        addObject(right3,894,820);

        Left left4 = new Left(4, ArrowDirection.LEFT);
        addObject(left4,1011,820);
        Right right4 = new Right(4, ArrowDirection.RIGHT);
        addObject(right4,1206,820);
    }

    public void changeArrow(int playerID, ArrowDirection direction){
        //get correct arrows
        List<SelectorArrows> arrows = getObjects(SelectorArrows.class);
        SelectorArrows[] ans = new SelectorArrows[2];
        // ans[0] == LEFT ARROW
        // ans[1] == RIGHT ARROW
        for(SelectorArrows arrow : arrows){
            if(arrow.getID()==playerID){
                if(arrow.getDirection()==ArrowDirection.LEFT){
                    ans[0]=arrow;
                }
                else{
                    ans[1]=arrow;
                }
            }
        }
        //Make arrow bigger
        //Set image to diffrent image when bigger
        switch(direction){
            case LEFT :
                ans[0].freezeAnimation(5);
                ans[0].getImage().scale(100,100);
            break;
            case RIGHT :
                ans[1].freezeAnimation(5);
                ans[1].getImage().scale(100,100);
            break;
        }
    }
}
