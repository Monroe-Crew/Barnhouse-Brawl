import greenfoot.*;
public class SelectorBox extends Actor{
    private String[] controls;  
    public SelectorBox(int playerID){
        /* Control order:
         * Index 0 - Join / Select
         * Index 1 - Left
         * Index 2 - Right
         */
        getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);
        controls = new String[]{"-","-","-"};
        if(playerID==1) controls = new String[]{"1", "A","D"};
        if(playerID==2) controls = new String[]{"2","LEFT","RIGHT"};
        if(playerID==3) controls = new String[]{"3", "J","L"};
        if(playerID==4) controls = new String[]{"4","1","3"};
    }
    public void act() {
        // Add your action code here.
    }    
}
