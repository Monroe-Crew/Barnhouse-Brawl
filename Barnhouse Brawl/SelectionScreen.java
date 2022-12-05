import java.util.*;
import greenfoot.*;

public class SelectionScreen extends World {
    private String confirmButton = "";
    private int frame = 0;

    /*
     * Control order:
     * Index 0 - Join / Select
     * Index 1 - Left
     * Index 2 - Right
     */

    private String[] p1Controls = new String[] { "1", "A", "D" };
    private SelectorBox selectorBox1;

    private String[] p2Controls = new String[] { "2", "LEFT", "RIGHT" };
    private SelectorBox selectorBox2;

    private String[] p3Controls = new String[] { "3", "J", "L" };
    private SelectorBox selectorBox3;

    private String[] p4Controls = new String[] { "4", "1", "3" };
    private SelectorBox selectorBox4;

    public SelectionScreen() {
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        AllPlayers.reset();
        prepare();
    }

    public void act() {
        if (Greenfoot.isKeyDown(p1Controls[0]) && selectorBox1 == null) {
            if (confirmButton.equals(""))
                confirmButton = p1Controls[0];
            Player player1 = new Player(1);
            selectorBox1 = new SelectorBox(player1, p1Controls);
            addObject(selectorBox1, 172, 655);
        }

        if (Greenfoot.isKeyDown(p2Controls[0]) && selectorBox2 == null) {
            if (confirmButton.equals(""))
                confirmButton = p2Controls[0];
            Player player2 = new Player(2);
            selectorBox2 = new SelectorBox(player2, p2Controls);
            addObject(selectorBox2, 485, 655);
        }

        if (Greenfoot.isKeyDown(p3Controls[0]) && selectorBox3 == null) {
            if (confirmButton.equals(""))
                confirmButton = p3Controls[0];
            Player player3 = new Player(3);
            selectorBox3 = new SelectorBox(player3, p3Controls);
            addObject(selectorBox3, 796, 655);
        }

        if (Greenfoot.isKeyDown(p4Controls[0]) && selectorBox4 == null) {
            if (confirmButton.equals(""))
                confirmButton = p4Controls[0];
            Player player4 = new Player(4);
            selectorBox4 = new SelectorBox(player4, p4Controls);
            addObject(selectorBox4, 1100, 655);
        }

        if (frame > 60) {
            if (Greenfoot.isKeyDown(confirmButton))
                Greenfoot.setWorld(new Barnhouse());
        } else if (!confirmButton.equals("")) {
            frame++;
        }

    }

    private void prepare(){
        TempImage p1Start = new TempImage("PressStart");
        addObject(selectorBox1, 172, 655);
        TempImage p2Start = new TempImage("PressStart");
        TempImage p3Start = new TempImage("PressStart");
        addObject(selectorBox3, 796, 655);
        TempImage p4Start = new TempImage("PressStart");
        
        
    }
}
