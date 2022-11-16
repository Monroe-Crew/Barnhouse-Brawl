
public class Player{
    private int playerID;
    private AnimalType animal;
    private int placement;
    
    public Player(int ID){
        this.playerID = ID;
        this.placement = Integer.MAX_VALUE;
    }
    
    public int getPlayerID(){
        return playerID;
    }
    
    public void setAnimal(AnimalType animal){
        this.animal = animal;
    }
    
    public void setPlacement(int placement){
        this.placement = placement;
    }
}
