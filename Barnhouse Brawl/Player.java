
public class Player{
    private int playerID;
    private Color color;
    private AnimalType animal;
    private int placement;

    public enum Color {
        RED,
        GREEN,
        BLUE,
        YELLOW
    }
    
    public Player(int ID, Color color){
        this.playerID = ID;
        this.color = color;
        this.placement = Integer.MAX_VALUE;

        AllPlayers.addPlayer(this);
    }

    public int getPlayerID(){
        return playerID;
    }
    
    public Color getColor(){
        return color;
    }

    public void setAnimal(AnimalType animal){
        this.animal = animal;
    }

    public AnimalType getAnimal(){
        return animal;
    }

    public void setPlacement(int placement){
        this.placement = placement;
    }

    public int getPlacement(){
        return this.placement;
    }
}
