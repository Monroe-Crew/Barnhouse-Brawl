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

        players = AllPlayers.getPlayers();
        for(Player player : players){
            TempImage image = new StaticImage(new GreenfootImage("Cow.png"));
            switch(player.getAnimal()){
                case GOAT:
                image = new StaticImage(new GreenfootImage("Goat.png"));
                break;
                case COW :
                image = new StaticImage(new GreenfootImage("Cow.png"));
                break;
                case PIG : 
                image = new StaticImage(new GreenfootImage("Pig.png"));
                break;
                case CHICKEN :
                image = new StaticImage(new GreenfootImage("Chicken.png"));
                break;
            }
            image.scale(image.getImage().getWidth()*2,image.getImage().getHeight()*2);
            switch(player.getPlacement()){
                case 1 :
                addObject(image, 400,310);
                break;
                case 2 :
                addObject(image, 900,385);
                break;
                case 3 :
                addObject(image, 400,475);
                break;
                case 4 : 
                addObject(image, 900,550);
                break;
            }
        }
    }

        
    public List<Player> sortList(List<Player> list){
        for(int i=0; i<list.size(); i++){
            for(int s=i+1; s<list.size(); s++){
                if(list.get(s).getPlacement()<list.get(i).getPlacement()){
                    list.add(i,list.get(s));
                    list.set(s+1, list.get(i));
                    list.remove(i+1);
                    i--;
                }
            }
        }
        return list;
    }
    
    public void act(){
        if(!start){
            Music.playMusic(endMusic1);
        }
        start=true;
    }
}
