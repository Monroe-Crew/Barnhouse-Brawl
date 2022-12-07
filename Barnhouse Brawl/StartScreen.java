import greenfoot.*; 
public class StartScreen extends World
{
    boolean start = false;
    private ParticleEffect titleParticle;
    GreenfootSound titleMusic = new GreenfootSound("StartScreen.mp3");
    public Music music = new Music();
    public StartScreen(){    
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        prepare();
    }

    private void prepare(){
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
        
        if(Greenfoot.isKeyDown(Constants.PlayerControl.p1Controls[4]) ||Greenfoot.isKeyDown(Constants.PlayerControl.p2Controls[4])||Greenfoot.isKeyDown(Constants.PlayerControl.p3Controls[4])||Greenfoot.isKeyDown(Constants.PlayerControl.p4Controls[4])){
            Greenfoot.setWorld(new SelectionScreen());
        }
        start=true;
    }
}
