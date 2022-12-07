import greenfoot.*;

public class SelectionScreen extends World {
    private String confirmButton = "";
    private int frame = 0;
    private String joinSelectName = "JoinSelection.png";
    
    GreenfootSound selectMusic = new GreenfootSound("SelectionScreen.mp3");
    /*
     * Control order:
     * Index 0 - Join / Select
     * Index 1 - Left
     * Index 2 - Right
     */

    private String[] p1Controls = new String[] { "1", "A", "D" };
    private SelectorBox selectorBox1;
    private TempImage p1Start = new TempImage(joinSelectName);

    private String[] p2Controls = new String[] { "2", "LEFT", "RIGHT" };
    private SelectorBox selectorBox2;
    private TempImage p2Start = new TempImage(joinSelectName);

    private String[] p3Controls = new String[] { "3", "J", "L" };
    private SelectorBox selectorBox3;
    private TempImage p3Start = new TempImage(joinSelectName);

    private String[] p4Controls = new String[] { "4", "1", "3" };
    private SelectorBox selectorBox4;
    private TempImage p4Start = new TempImage(joinSelectName);

    public SelectionScreen() {
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        AllPlayers.reset();
        Music.playMusic(selectMusic);
        prepare();
    }

    public void act() {
        if (Greenfoot.isKeyDown(p1Controls[0]) && selectorBox1 == null) {
            removeObject(p1Start);
            if (confirmButton.equals(""))
                confirmButton = p1Controls[0];
            Player player1 = new Player(1, Player.Color.RED);
            selectorBox1 = new SelectorBox(player1, p1Controls);
            addObject(selectorBox1, 172, 655);
        }

        if (Greenfoot.isKeyDown(p2Controls[0]) && selectorBox2 == null) {
            removeObject(p2Start);
            if (confirmButton.equals(""))
                confirmButton = p2Controls[0];
            Player player2 = new Player(2,Player.Color.GREEN);
            selectorBox2 = new SelectorBox(player2, p2Controls);
            addObject(selectorBox2, 485, 655);
        }

        if (Greenfoot.isKeyDown(p3Controls[0]) && selectorBox3 == null) {
            removeObject(p3Start);
            if (confirmButton.equals(""))
                confirmButton = p3Controls[0];
            Player player3 = new Player(3,Player.Color.BLUE);
            selectorBox3 = new SelectorBox(player3, p3Controls);
            addObject(selectorBox3, 796, 655);
        }

        if (Greenfoot.isKeyDown(p4Controls[0]) && selectorBox4 == null) {
            removeObject(p4Start);
            if (confirmButton.equals(""))
                confirmButton = p4Controls[0];
            Player player4 = new Player(4,Player.Color.YELLOW);
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
        addObject(p1Start, 172, 655);
        addObject(p2Start, 485, 655);
        addObject(p3Start, 796, 655);
        addObject(p4Start, 1108,655);
    }
}
