import greenfoot.*;
import java.util.Random;

public class SelectionScreen extends World {
    private String confirmButton = "";
    private int frame = 0;
    private String joinSelectName = "JoinSelection.png";
    
    GreenfootSound selectMusic = new GreenfootSound("SelectionScreen.mp3");

    private String[] p1Controls = Constants.PlayerControl.p1Controls;
    private SelectorBox selectorBox1;
    private TempImage p1Start = new TempImage(joinSelectName);

    private String[] p2Controls = Constants.PlayerControl.p2Controls;
    private SelectorBox selectorBox2;
    private TempImage p2Start = new TempImage(joinSelectName);

    private String[] p3Controls = Constants.PlayerControl.p3Controls;
    private SelectorBox selectorBox3;
    private TempImage p3Start = new TempImage(joinSelectName);

    private String[] p4Controls = Constants.PlayerControl.p4Controls;
    private SelectorBox selectorBox4;
    private TempImage p4Start = new TempImage(joinSelectName);
    


    public SelectionScreen() {
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        AllPlayers.reset();
        Music.playMusic(selectMusic);
        prepare();
    }

    public void act() {
        if (Greenfoot.isKeyDown(p1Controls[4]) && selectorBox1 == null) {
            removeObject(p1Start);
            if (confirmButton.equals(""))
                confirmButton = p1Controls[4];
            Player player1 = new Player(1);
            selectorBox1 = new SelectorBox(player1);
            addObject(selectorBox1, 172, 655);
        }

        if (Greenfoot.isKeyDown(p2Controls[4]) && selectorBox2 == null) {
            removeObject(p2Start);
            if (confirmButton.equals(""))
                confirmButton = p2Controls[4];
            Player player2 = new Player(2);
            selectorBox2 = new SelectorBox(player2);
            addObject(selectorBox2, 485, 655);
        }

        if (Greenfoot.isKeyDown(p3Controls[4]) && selectorBox3 == null) {
            removeObject(p3Start);
            if (confirmButton.equals(""))
                confirmButton = p3Controls[4];
            Player player3 = new Player(3);
            selectorBox3 = new SelectorBox(player3);
            addObject(selectorBox3, 796, 655);
        }

        if (Greenfoot.isKeyDown(p4Controls[4]) && selectorBox4 == null) {
            removeObject(p4Start);
            if (confirmButton.equals(""))
                confirmButton = p4Controls[4];
            Player player4 = new Player(4);
            selectorBox4 = new SelectorBox(player4);
            addObject(selectorBox4, 1100, 655);
        }

        if (frame > 60) {
            if (Greenfoot.isKeyDown(confirmButton)){
                Random rand = new Random();
                switch(rand.nextInt(2)){
                    case 0:
                Greenfoot.setWorld(new Barnhouse());
                break;
                case 1:
                Greenfoot.setWorld(new Grassfield());
                break;
            }
            }
        } else if (!confirmButton.equals("")) {
            frame++;
        }
        
    }

    private void prepare(){
        addObject(p1Start, 172, 655);
        addObject(p2Start, 485, 655);
        addObject(p3Start, 796, 655);
        addObject(p4Start, 1108,655);
    }
}
