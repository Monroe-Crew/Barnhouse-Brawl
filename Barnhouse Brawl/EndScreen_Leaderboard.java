import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * Write a description of class EndScreen_Leaderboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen_Leaderboard extends Actor
{
    GreenfootImage image;
    public EndScreen_Leaderboard(){
        List<Player> players = AllPlayers.getPlayers();
        Set<String> playerStrings = new TreeSet<>();
        String leaderboard = "Leaderboard \n";
        for(Player player : players){
            playerStrings.add(player.getPlacement() + ": Player " + player.getPlayerID());
        }
        
        for(String playerString : playerStrings){
            leaderboard += playerString + "\n";
        }
        
        GreenfootImage partDescText = new GreenfootImage(leaderboard, 80, Color.BLACK, null);
        setImage(partDescText);
    }
    public void act() 
    {
        if(Greenfoot.isKeyDown("1") ||Greenfoot.isKeyDown("2")||Greenfoot.isKeyDown("3")||Greenfoot.isKeyDown("4")){
            Greenfoot.setWorld(new SelectionScreen());
        }
    }    
}
