import greenfoot.*;
import java.util.Random;

public class SelectionScreen extends World {
    private String confirmButton = "";
    private int frame = 0;
    private boolean start = false;

    private GreenfootSound selectMusic = new GreenfootSound("SelectionScreen.mp3");

    private GreenfootImage joinSelectImage = new GreenfootImage("JoinSelection.png");
    private double joinSelectAmplitude = .2;
    private double joinSelectFrequency = 10;

    private String[] p1Controls = Constants.PlayerControl.p1Controls;
    private SelectorBox selectorBox1;
    private BobbingImage p1Start = new BobbingImage(new GreenfootImage(joinSelectImage), joinSelectAmplitude,
            joinSelectFrequency);

    private String[] p2Controls = Constants.PlayerControl.p2Controls;
    private SelectorBox selectorBox2;
    private BobbingImage p2Start = new BobbingImage(new GreenfootImage(joinSelectImage), joinSelectAmplitude,
            joinSelectFrequency);

    private String[] p3Controls = Constants.PlayerControl.p3Controls;
    private SelectorBox selectorBox3;
    private BobbingImage p3Start = new BobbingImage(new GreenfootImage(joinSelectImage), joinSelectAmplitude,
            joinSelectFrequency);

    private String[] p4Controls = Constants.PlayerControl.p4Controls;
    private SelectorBox selectorBox4;
    private BobbingImage p4Start = new BobbingImage(new GreenfootImage(joinSelectImage), joinSelectAmplitude,
            joinSelectFrequency);

    public SelectionScreen() {
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        AllPlayers.reset();
        prepare();
    }

    public void act() {
        if (!start) {
            Music.playMusic(selectMusic);
            start = true;
        }

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
            addObject(selectorBox4, 1108, 655);
        }

        if (frame > 60) {
            if (Greenfoot.isKeyDown(confirmButton)) {
                Random rand = new Random();
                switch (rand.nextInt(2)) {
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

    private void prepare() {
        double scale = 3.5;

        addObject(p1Start, 172, 655);
        p1Start.scale((int) (joinSelectImage.getWidth() * scale), (int) (joinSelectImage.getHeight() * scale));

        addObject(p2Start, 485, 655);
        p2Start.scale((int) (joinSelectImage.getWidth() * scale), (int) (joinSelectImage.getHeight() * scale));

        addObject(p3Start, 796, 655);
        p3Start.scale((int) (joinSelectImage.getWidth() * scale), (int) (joinSelectImage.getHeight() * scale));

        addObject(p4Start, 1108, 655);
        p4Start.scale((int) (joinSelectImage.getWidth() * scale), (int) (joinSelectImage.getHeight() * scale));
    }
}
