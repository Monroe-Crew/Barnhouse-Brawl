import greenfoot.*; 
import java.util.*;
/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    private GreenfootSound endMusic1;
    boolean start = false;
    List<Player> players;
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen(){    
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);

        endMusic1 = new GreenfootSound("EndScreen.mp3");

        prepare();
    }

    private void prepare(){
        EndScreen_Leaderboard endScreen_Leaderboard = new EndScreen_Leaderboard();
        addObject(endScreen_Leaderboard,Constants.Settings.worldWidth/2,(int)(Constants.Settings.worldHeight/2.5));
        
        players = endScreen_Leaderboard.getSortedList();
        int iterate = 1;
        for(Player player : players){
            StaticImage image = new StaticImage(new GreenfootImage("Cow.png"));
            switch(player.getAnimal()){
                case COW :
                image = new StaticImage(new GreenfootImage("Cow.png"));
                break;
                case PIG : 
                image = new StaticImage(new GreenfootImage("Pig.png"));
                break;
                case GOAT:
                image = new StaticImage(new GreenfootImage("Goat.png"));
                break;
                case CHICKEN :
                image = new StaticImage(new GreenfootImage("Chicken.png"));
                break;
            }
            //sacle image
            switch(iterate){
                case 1 :
                addObject(image, 50,50);
                break;
                case 2 :
                addObject(image, 100,100);
                break;
                case 3 :
                addObject(image, 150,150);
                break;
                case 4 : 
                addObject(image, 200,200);
                break;
            }
            iterate++;
        }
    }

    public void act(){
        if(!start){
            Music.playMusic(endMusic1);
        }
        start=true;
    }
}
