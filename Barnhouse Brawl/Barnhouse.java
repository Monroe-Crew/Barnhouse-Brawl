import greenfoot.*;
import java.util.*;

public class Barnhouse extends GameWorld {
    public Barnhouse() {
        super(new GreenfootSound("mapBackground.mp3"));
        prepare();
    }

    protected void prepare() {
        super.prepare();

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
                    addObject(animal, 200, Constants.Settings.worldHeight - 200);
                    break;
                case 2:
                    addObject(animal, 200, 200);
                    break;
                case 3:
                    addObject(animal, Constants.Settings.worldWidth - 200, 200);
                    break;
                case 4:
                    addObject(animal, Constants.Settings.worldWidth - 200, Constants.Settings.worldHeight - 200);
                    break;
            }
        }
    }
}
