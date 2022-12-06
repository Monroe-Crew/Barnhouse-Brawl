import java.util.List;
import java.util.ArrayList;
public class AllPlayers  {
    private static List<Player> players = new ArrayList<Player>();
    public static void addPlayer(Player player){
        players.add(player);
    }
    
    public static void removePlayer(Player player){
        players.remove(player);
    }
    
    public static List<Player> getPlayers(){
        return players;
    }
    
    public static void reset(){
    players = new ArrayList<Player>();
    }
}
