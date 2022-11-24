import greenfoot.*; 
public class StartScreen extends World
{
    boolean start = false;
    private ParticleEffect titleParticle;
    static GreenfootSound titleMusic = new GreenfootSound("StartScreen.mp3");
    static public Music music = new Music();
    public StartScreen(){    
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        prepare();
    }

    private void prepare(){
        StartButton startButton = new StartButton();
        addObject(startButton,598,700);
        titleParticle = new ParticleEffect(300,new Color(230, 136, 73,200));
        addObject(titleParticle,638,370);
        Title title = new Title();
        addObject(title,638,370);
        AllPlayers.reset();
        
        setPaintOrder(Title.class,Particle.class);
    }

    public void act(){
        titleParticle.generateParticles(10);
        if(!start){
            music.playMusic(titleMusic);
        }
        start=true;
    }
}
