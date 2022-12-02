import greenfoot.*;
import java.util.*;
public class Barnhouse extends GameWorld{
    public Barnhouse(){
        super(new GreenfootSound("mapBackground.mp3"));
        prepare();
    }

    protected void prepare(){
        super.prepare();
        
        Player player1 = new Player(1);
        Chicken animal1 = new Chicken(player1);
        player1.setAnimal(AnimalType.CHICKEN);
        addObject(animal1, 200, Constants.Settings.worldHeight-200);
        
        Player player2 = new Player(2);
        Pig animal2 = new Pig(player2);
        player2.setAnimal(AnimalType.PIG);
        addObject(animal2, 200, 200);

        Player player3 = new Player(3);
        Cow animal3 = new Cow(player3);
        player3.setAnimal(AnimalType.COW);
        addObject(animal3, Constants.Settings.worldWidth-200, 200);

        Player player4 = new Player(4);
        Goat animal4 = new Goat(player4);
        player4.setAnimal(AnimalType.GOAT);
        addObject(animal4, Constants.Settings.worldWidth-200, Constants.Settings.worldHeight-200);

        Timer timer = new Timer(2,0);
        addObject(timer, Constants.Settings.worldWidth/2+50, 12);
    }
}
