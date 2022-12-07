import greenfoot.*;

public class Barnhouse extends GameWorld {
    private TempImage redCircle;
    private boolean redGrey = false;
    public Barnhouse() {
        super(new GreenfootSound("mapBackground.mp3"));
        prepare();
    }

    protected void prepare() {
        super.prepare();
        for (Player player : AllPlayers.getPlayers()) {
            Animal animal = new Pig(player);
            switch (player.getAnimal()) {
                case COW:
                animal = new Cow(player);
                break;
                case CHICKEN:
                animal = new Chicken(player);
                break;
                case GOAT:
                animal = new Goat(player);
                break;
            }

            switch (player.getPlayerID()) {
                case 1:
                redCircle = new TempImage("RedCircle.png", animal);
                addObject(redCircle, 40,Constants.Settings.worldHeight - 60);
                addObject(animal, 200, Constants.Settings.worldHeight - 200);
                break;
                case 2:
                //add a blue circle
                addObject(animal, 200, 200);
                break;
                case 3:
                //add a yellow circle
                addObject(animal, Constants.Settings.worldWidth - 200, 200);
                break;
                case 4:
                //add a green circle
                addObject(animal, Constants.Settings.worldWidth - 200, Constants.Settings.worldHeight - 200);
                break;
            }
        }
    }

    public void reflectHorizontally(Actor actor){
        actor.setLocation(Constants.Settings.worldWidth-actor.getX(), actor.getY());
    }
    
    public void act(){
        super.act();
        //Optomize by creating a subclass to tempImage
        if(redCircle.getAnimal().getAbilityTimer()<redCircle.getAnimal().getSpecialCooldown() && !redGrey){
            redGrey=true;
            redCircle.changeImage("GreyCircle.png");
            redCircle.stopAnimation();
        }
        else if(redCircle.getAnimal().getAbilityTimer()>redCircle.getAnimal().getSpecialCooldown() && redGrey){
            redGrey=false;
            redCircle.changeImage("RedCircle.png");
            redCircle.startAnimation();
        }
    }
}
