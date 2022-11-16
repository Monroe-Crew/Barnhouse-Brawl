import java.util.*;
import greenfoot.*;
public class Music  {
    private static List<GreenfootSound> music= new ArrayList<GreenfootSound>();
    
    public static void addSound(GreenfootSound sound){
        music.add(sound);
        sound.setVolume(30);
        sound.playLoop();
    }
    
    public static void changeWorld(){
        for(GreenfootSound sound : music){
            sound.stop();
        }
        music = new ArrayList<GreenfootSound>();
    }
}
