import greenfoot.*;

public class Barnhouse extends GameWorld {
    public Barnhouse() {
        super(new GreenfootSound("mapBackground.mp3"));
        prepare();
    }

    protected void prepare() {
        super.prepare();
        MudBubble mudBubble = new MudBubble();
        addObject(mudBubble,1222,146);
        MudBubble mudBubble2 = new MudBubble();
        addObject(mudBubble2,966,886);
        MudBubble mudBubble3 = new MudBubble();
        addObject(mudBubble3,366,927);
        MudBubble mudBubble4 = new MudBubble();
        addObject(mudBubble4,28,377);
        MudBubble mudBubble5 = new MudBubble();
        addObject(mudBubble5,60,200);
        MudBubble mudBubble6 = new MudBubble();
        addObject(mudBubble6,169,62);
        MudBubble mudBubble7 = new MudBubble();
        addObject(mudBubble7,648,38);
        MudBubble mudBubble8 = new MudBubble();
        addObject(mudBubble8,1165,38);
        MudBubble mudBubble9 = new MudBubble();
        addObject(mudBubble9,1248,284);
        MudBubble mudBubble10 = new MudBubble();
        addObject(mudBubble10,1207,693);
        MudBubble mudBubble11 = new MudBubble();
        addObject(mudBubble11,1260,895);
        MudBubble mudBubble12 = new MudBubble();
        addObject(mudBubble12,1012,911);
        MudBubble mudBubble13 = new MudBubble();
        addObject(mudBubble13,651,906);
        MudBubble mudBubble14 = new MudBubble();
        addObject(mudBubble14,458,880);
        MudBubble mudBubble15 = new MudBubble();
        addObject(mudBubble15,60,768);
        MudBubble mudBubble16 = new MudBubble();
        addObject(mudBubble16,65,618);
        MudBubble mudBubble17 = new MudBubble();
        addObject(mudBubble17,27,554);
        MudBubble mudBubble18 = new MudBubble();
        addObject(mudBubble18,60,462);
        MudBubble mudBubble19 = new MudBubble();
        addObject(mudBubble19,290,68);
        MudBubble mudBubble20 = new MudBubble();
        addObject(mudBubble20,456,32);
        MudBubble mudBubble21 = new MudBubble();
        addObject(mudBubble21,859,52);
        MudBubble mudBubble22 = new MudBubble();
        addObject(mudBubble22,1249,505);
        MudBubble mudBubble23 = new MudBubble();
        addObject(mudBubble23,36,70);
        MudBubble mudBubble24 = new MudBubble();
        addObject(mudBubble24,779,947);
        mudBubble2.setLocation(893,893);
        MudBubble mudBubble25 = new MudBubble();
        addObject(mudBubble25,1204,401);
        MudBubble mudBubble26 = new MudBubble();
        addObject(mudBubble26,74,857);
        MudBubble mudBubble27 = new MudBubble();
        addObject(mudBubble27,221,887);
        MudBubble mudBubble28 = new MudBubble();
        addObject(mudBubble28,417,79);
        MudBubble mudBubble29 = new MudBubble();
        addObject(mudBubble29,769,881);
        MudBubble mudBubble30 = new MudBubble();
        addObject(mudBubble30,1028,77);
        MudBubble mudBubble31 = new MudBubble();
        addObject(mudBubble31,122,936);
        MudBubble mudBubble32 = new MudBubble();
        addObject(mudBubble32,959,12);
        
        for (Player player : AllPlayers.getPlayers()) {
            Animal animal = new Pig(player);
            switch (player.getAnimal()) {
                case COW:
                animal = new Cow(player);
                break;
                case CHICKEN:
                animal = new Chicken(player);
                break;
                case GOAT:
                animal = new Goat(player);
                break;
            }

            switch (player.getPlayerID()) {
                case 1:
                SpecialIndicator redCircle = new SpecialIndicator(animal);
                addObject(redCircle, 40, 60);
                addObject(animal, 200, 200);

                break;
                case 2:
                SpecialIndicator greenCircle = new SpecialIndicator(animal);
                addObject(greenCircle, 40, Constants.Settings.worldHeight - 60);
                addObject(animal, 200, Constants.Settings.worldHeight - 200);
                break;
                case 3:
                SpecialIndicator blueCircle = new SpecialIndicator(animal);
                addObject(blueCircle, Constants.Settings.worldWidth - 40, Constants.Settings.worldHeight - 60);
                addObject(animal, Constants.Settings.worldWidth - 200, Constants.Settings.worldHeight - 200);
                break;
                case 4:
                SpecialIndicator yellowCircle = new SpecialIndicator(animal);
                addObject(yellowCircle, Constants.Settings.worldWidth - 40, 60);
                addObject(animal, Constants.Settings.worldWidth - 200, 200);
                break;
            }
        }
    }

    public void reflectHorizontally(Actor actor) {
        actor.setLocation(Constants.Settings.worldWidth - actor.getX(), actor.getY());
    }

}
