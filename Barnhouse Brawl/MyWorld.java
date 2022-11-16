import greenfoot.*;
import java.util.*;
public class MyWorld extends World{
    private GreenfootSound sound = new GreenfootSound("mapBackground.mp3");
    boolean start = false;
    List<Animal> animalList;
    static public Music music = new Music();
    public MyWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        animalList = new ArrayList<>();
        prepare();
    }

    private void prepare(){
        Player player1 = new Player(1);
        Chicken animal = new Chicken(player1);
        player1.setAnimal(AnimalType.CHICKEN);
        addObject(animal, 200, Constants.Settings.worldHeight-200);

        Player player2 = new Player(2);
        Pig animal2 = new Pig(player2);
        player2.setAnimal(AnimalType.PIG);
        addObject(animal2, 200, 200);

        Player player3 = new Player(3);
        Chicken animal3 = new Chicken(player3);
        player3.setAnimal(AnimalType.CHICKEN);
        addObject(animal3, Constants.Settings.worldWidth-200, 200);

        Player player4 = new Player(4);
        Pig animal4 = new Pig(player4);
        player4.setAnimal(AnimalType.PIG);
        addObject(animal4, Constants.Settings.worldWidth-200, Constants.Settings.worldHeight-200);

        Timer timer = new Timer(2,0);
        addObject(timer, Constants.Settings.worldWidth/2+50, 12);
    }

    public void act(){
        if(!start){
            music.addSound(sound);
        }
        start=true;
        List<Projectile> projectileList = getObjects(Projectile.class);
        for(Actor a : projectileList){
            if(a.getX()==0||a.getX()>=Constants.Settings.worldWidth-10){
                removeObject(a);
            }
            else if(a.getY()==0||a.getY()>=Constants.Settings.worldHeight-10){
                removeObject(a);
            }
        }
        if(animalList.size()==3){
            //update list of names
            music.changeWorld();
            //change world
        }
    }
}
