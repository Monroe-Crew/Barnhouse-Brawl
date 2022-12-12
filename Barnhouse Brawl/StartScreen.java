import greenfoot.*; 
public class StartScreen extends World
{
    boolean start = false;
    private ParticleEffect titleParticle;
    GreenfootSound titleMusic = new GreenfootSound("StartScreen.mp3");
    public Music music = new Music();
    TempImage bg = new StaticImage(new GreenfootImage("BigGrassTitle.png"));
    
    ParticleEffect goatParticle = new ParticleEffect(80,new Color(255, 255, 255,255));
    TempImage goat = new StaticImage(new GreenfootImage("goat.png"));
    
    int bgTimer = 0;
    
    int goatTimer = 0;
    int goatAppearanceTime;
    boolean goatAnimate = false;
    public StartScreen(){    
        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1, false);
        goatAppearanceTime = Greenfoot.getRandomNumber(500);
        prepare();
    }

    private void prepare(){
        goat.scale(goat.image.getWidth()*3, goat.image.getHeight()*3);

        titleParticle = new ParticleEffect(300,new Color(230, 136, 73,200));
        addObject(titleParticle,638,370);
        Title title = new Title();
        addObject(title,Constants.Settings.worldWidth/2,370);
        AllPlayers.reset();

        StartText startText = new StartText();
        addObject(startText,Constants.Settings.worldWidth/2,699);

        addObject(bg,(int)(bg.getImage().getWidth()/2),480);
        TempImage names = new StaticImage(new GreenfootImage("OLDNames.png"));
        addObject(names,170,810);

        setPaintOrder(Title.class,StartText.class,TempImage.class,Particle.class,StaticImage.class);
        
        AstroEasterEgg astroEasterEgg = new AstroEasterEgg();
        addObject(astroEasterEgg,1320,704);
    }

    public void act(){
        titleParticle.generateParticles(50);
        if(!start){
            music.playMusic(titleMusic);
        }
        bgTimer++;
        if(bgTimer < (int)(bg.getImage().getWidth()/2)){
            bg.move(-1);
        }else{
            bg.setLocation((int)(bg.getImage().getWidth()/2),480);
            bgTimer = 0;
        }
        
        goatTimer++;
        if(goatTimer % (500 + (goatAppearanceTime)) == 0){
            goatAnimate = true;
            int borderSize = 100;
            addObject(goat, (int)(-goat.getImage().getWidth()*3), Greenfoot.getRandomNumber(Constants.Settings.worldHeight - borderSize*2) + borderSize);
            addObject(goatParticle, goat.getX(), goat.getY());
            goat.setRotation(90);
        }
        if(goatAnimate){
            goatParticle.setLocation(goatParticle.getX()+3,goatParticle.getY());
            goatParticle.generateParticles(20);
            goat.setLocation(goatParticle.getX(), goatParticle.getY());
            if(goat.getX() > Constants.Settings.worldWidth + goat.getImage().getWidth()){
                goatAnimate = false;
                removeObject(goat);
                removeObject(goatParticle);
                goatTimer = 0;
                goatAppearanceTime = Greenfoot.getRandomNumber(500);
            }
        }
        
        if(Greenfoot.isKeyDown(Constants.PlayerControl.p1Controls[4]) ||Greenfoot.isKeyDown(Constants.PlayerControl.p2Controls[4])||Greenfoot.isKeyDown(Constants.PlayerControl.p3Controls[4])||Greenfoot.isKeyDown(Constants.PlayerControl.p4Controls[4])){
            Greenfoot.setWorld(new SelectionScreen());
        }
        start=true;
    }
}
