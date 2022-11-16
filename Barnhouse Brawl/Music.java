import java.util.*;
import greenfoot.*;
public class Music  {
    private List<GreenfootSound> music;
    public Music(){
        music = new ArrayList<GreenfootSound>();
    }
    
    public void addSound(GreenfootSound sound){
        music.add(sound);
        sound.setVolume(30);
        sound.playLoop();
    }
    
    public void changeWorld(){
        for(GreenfootSound sound : music){
            sound.stop();
        }
        music = new ArrayList<GreenfootSound>();
    }
}
