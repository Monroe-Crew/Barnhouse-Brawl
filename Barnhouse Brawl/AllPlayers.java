import java.util.*;
public class AllPlayers  {
    private List<Player> players;
    public AllPlayers(){
        players = new ArrayList<Player>();
    }
    
    public void addPlayer(Player player){
        players.add(player);
    }
    
    public void removePlayer(Player player){
        players.remove(player);
    }
    
    public List<Player> getPlayers(){
        return players;
    }
}
