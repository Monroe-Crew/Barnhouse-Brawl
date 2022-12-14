import greenfoot.*;
//import java.util.*;
import java.util.List;
import java.util.EnumSet;
import java.util.ArrayList;

public class SelectorBox extends Actor {
    private String[] controls;
    private List<AnimalType> animals;
    private LeftArrow leftArrow;
    private RightArrow rightArrow;
    private GreenfootSound swap;
    private int iterate;
    private int frame = 30;
    private Player player;

    public SelectorBox(Player player) {
        this.player = player;
        this.controls = player.getControls();

        animals = new ArrayList<AnimalType>(EnumSet.allOf(AnimalType.class));
        iterate = 0;
        changeImage(animals.get(iterate));

        swap = new GreenfootSound("shuffle.wav");
        leftArrow = new LeftArrow();
        rightArrow = new RightArrow();
    }

    @Override
    public void addedToWorld(World world) {
        getWorld().addObject(leftArrow, (int) (getX() - 110), getY());
        getWorld().addObject(rightArrow, (int) (getX() + 110), getY());
    }

    public void act() {
        if (frame < 30)
            frame++;

        if (Greenfoot.isKeyDown(controls[1]) && frame > 15) {
            iterate = iterate == 0 ? animals.size() - 1 : iterate - 1;
            swap.play();
            changeImage(animals.get(iterate));
            frame = 0;
            leftArrow.changeArrow();
        }

        if (Greenfoot.isKeyDown(controls[3]) && frame > 15) {
            iterate = (iterate + 1) % (animals.size());
            swap.play();
            changeImage(animals.get(iterate));
            frame = 0;
            rightArrow.changeArrow();
        }
    }

    private void changeImage(AnimalType animal) {
        switch (animals.get(iterate)) {
            case PIG:
            player.setAnimal(AnimalType.PIG);
                setImage(new GreenfootImage("PigSelection.png"));
                getImage().scale((int) (getImage().getWidth() * 3.35), (int) (getImage().getHeight() * 3.35));
                break;
            case COW:
            player.setAnimal(AnimalType.COW);
                setImage(new GreenfootImage("CowSelection.png"));
                getImage().scale((int) (getImage().getWidth() * 3.35), (int) (getImage().getHeight() * 3.35));
                break;
            case CHICKEN:
            player.setAnimal(AnimalType.CHICKEN);
                setImage(new GreenfootImage("ChickenSelection.png"));
                getImage().scale((int) (getImage().getWidth() * 3.35), (int) (getImage().getHeight() * 3.35));
                break;
            case GOAT:
            player.setAnimal(AnimalType.GOAT);
                setImage(new GreenfootImage("GoatSelection.png"));
                getImage().scale((int) (getImage().getWidth() * 3.35), (int) (getImage().getHeight() * 3.35));
                break;
        }
    }

}
