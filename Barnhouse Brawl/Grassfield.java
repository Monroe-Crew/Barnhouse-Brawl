import greenfoot.*;

public class Grassfield extends GameWorld {
    public Grassfield() {
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
                SpecialIndicator redCircle = new SpecialIndicator("RedCircle.png", animal);
                addObject(redCircle, 40,Constants.Settings.worldHeight - 60);
                addObject(animal, 200, Constants.Settings.worldHeight - 200);
                break;
                case 2:
                SpecialIndicator greenCircle = new SpecialIndicator("GreenCircle.png", animal);
                addObject(greenCircle, 40,60);
                addObject(animal, 200, 200);
                break;
                case 3:
                SpecialIndicator blueCircle = new SpecialIndicator("BlueCircle.png", animal);
                addObject(blueCircle, Constants.Settings.worldWidth - 40,60);
                addObject(animal, Constants.Settings.worldWidth - 200, 200);
                break;
                case 4:
                SpecialIndicator yellowCircle = new SpecialIndicator("YellowCircle.png", animal);
                addObject(yellowCircle, Constants.Settings.worldWidth - 40,Constants.Settings.worldHeight - 60);
                addObject(animal, Constants.Settings.worldWidth - 200, Constants.Settings.worldHeight - 200);
                break;
            }
        }
    }
}