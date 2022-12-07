
public class Player{
    private int playerID;
    private Color color;
    private AnimalType animal;
    private int placement;
    private String[] controls;

    public enum Color {
        RED,
        GREEN,
        BLUE,
        YELLOW
    }

    public Player(int ID){
        this.playerID = ID;
        this.placement = Integer.MAX_VALUE;

        switch(playerID){
            case 1: 
            this.color = Color.RED;
            this.controls = Constants.PlayerControl.p1Controls;
            break;
            case 2: 
            this.color = Color.GREEN;
            this.controls = Constants.PlayerControl.p2Controls;
            break;
            case 3: 
            this.color = Color.BLUE;
            this.controls = Constants.PlayerControl.p3Controls;
            break;
            case 4: 
            this.color = Color.YELLOW;
            this.controls = Constants.PlayerControl.p4Controls;
            break;
        }

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

    public String[] getControls(){
        return this.controls;
    }
}
