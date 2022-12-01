import greenfoot.*;
import java.util.*;
public class SelectorBox extends Actor{
    private String[] controls;  
    List<AnimalType> animals;
    int iterate;
    int frame = 30;
    public SelectorBox(int playerID){
        /* Control order:
         * Index 0 - Join / Select
         * Index 1 - Left
         * Index 2 - Right
         */

        controls = new String[]{"-","-","-"};
        if(playerID==1) controls = new String[]{"1", "A","D"};
        if(playerID==2) controls = new String[]{"2","LEFT","RIGHT"};
        if(playerID==3) controls = new String[]{"3", "J","L"};
        if(playerID==4) controls = new String[]{"4","1","3"};
        
        animals =  new ArrayList<AnimalType>(EnumSet.allOf(AnimalType.class));
        iterate=0;
        changeImage(animals.get(iterate));
    }

    public void act() {
        if(frame < 30) frame++;

        if(Greenfoot.isKeyDown(controls[1]) && frame > 15){
            iterate = iterate == 0 ? animals.size()-1 : iterate-1;
            changeImage(animals.get(iterate));
            frame = 0;
        }
        
        if(Greenfoot.isKeyDown(controls[2]) && frame > 15){
            iterate = (iterate + 1) % (animals.size());
            changeImage(animals.get(iterate));
            frame = 0;
        }
    }
    
    private void changeImage(AnimalType animal){
        switch(animals.get(iterate)){
                case PIG : 
                setImage(new GreenfootImage("SelectionPig.png"));
                getImage().scale((int)(getImage().getWidth()*3.35), (int)(getImage().getHeight()*3.35));
                break;
                case COW : 
                setImage(new GreenfootImage("SelectionCow.png"));
                getImage().scale((int)(getImage().getWidth()*3.35), (int)(getImage().getHeight()*3.35));
                break;
                case CHICKEN :
                setImage(new GreenfootImage("SelectionChicken.png"));
                getImage().scale((int)(getImage().getWidth()*3.35), (int)(getImage().getHeight()*3.35));
                break;
            }
    }
}
