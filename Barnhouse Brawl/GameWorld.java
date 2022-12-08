import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
public abstract class GameWorld extends World
{
    private GreenfootSound backgroundMusic;
    boolean start = false;
    List<Animal> animalList;
    private int startTime = 180;
    private int countdown = 3;
    private int index = 0;
    private boolean done = false;
    private String[] fileNames = {"Three.png","Two.png", "One.png", "Brawl.png"};
    //private String[] songNames = {"Countdown.mp3"
    public GameWorld(GreenfootSound backgroundMusic)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        this.backgroundMusic = backgroundMusic;
        animalList = new ArrayList<>();

        Animal.changeKnockbackMultiplier(Constants.Animal.defaultKnockback);
    }
    
    protected void prepare(){
        setPaintOrder(Moo.class, Animal.class, ParticleEffect.class);
    }
    
    public void act(){
        //if(!start){
        //   Music.playMusic(backgroundMusic);
        //}
        //start=true;
        if(startTime%60==0 && !done){
            Music.playMusic(null);
            GreenfootSound sound;
            if(startTime==0){
                done=true;
                sound = new GreenfootSound("GO.wav");
                Music.playMusic(backgroundMusic);
            }
            else{
                sound = new GreenfootSound("123.wav");
            }
            sound.setVolume(75);
            TempImage image = new CountDown(fileNames[index]); 
            index++;
            addObject(image,Constants.Settings.worldWidth/2, Constants.Settings.worldHeight/2);
            sound.play();
        }
        if(startTime!=0){startTime--;}
        List<Projectile> projectileList = getObjects(Projectile.class);
        for(Actor a : projectileList){
            if(a.getX()==0||a.getX()>=Constants.Settings.worldWidth-10){
                removeObject(a);
            }
            else if(a.getY()==0||a.getY()>=Constants.Settings.worldHeight-10){
                removeObject(a);
            }
        }
        if(getObjects(Animal.class).size() == 1){
            Music.playMusic(null);
            for(Animal animal : getObjects(Animal.class)){
                animal.setPlacement(1);
            }
            Greenfoot.setWorld(new EndScreen());
        }
    }
    
    public int getStartTime(){
        return startTime;
    }
}
