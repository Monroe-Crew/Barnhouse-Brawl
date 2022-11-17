import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
        
        GreenfootImage descBg = new GreenfootImage(1000, 500);
        descBg.setColor(new Color(75, 75, 75, 200));
        descBg.fillRect(0, 0, 1000, 500);
        GreenfootImage partDescText = new GreenfootImage(leaderboard, 80, Color.BLACK, null);
        setImage(partDescText);
    }
    public void act() 
    {
    }    
}
