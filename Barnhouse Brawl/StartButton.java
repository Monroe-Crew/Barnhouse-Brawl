import greenfoot.*; 
public class StartButton extends Actor{
    public void act(){
        if(Greenfoot.isKeyDown("1") ||Greenfoot.isKeyDown("2")||Greenfoot.isKeyDown("3")||Greenfoot.isKeyDown("4")){
            StartScreen.music.changeWorld();
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
