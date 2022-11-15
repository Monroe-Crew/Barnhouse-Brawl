
public class Player{
    private int playerID;
    private AnimalType animal;
    
    public Player(int ID){
        this.playerID = ID;
    }
    
    public int getPlayerID(){
        return playerID;
    }
    
    public void setAnimal(AnimalType animal){
        this.animal = animal;
    }
}
