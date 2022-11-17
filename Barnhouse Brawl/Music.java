import java.util.*;
import greenfoot.*;
public class Music  {
    private static GreenfootSound currentlyPlaying;
    public static void playMusic(GreenfootSound sound){
        if(currentlyPlaying != null) currentlyPlaying.stop();
        
        if(sound != null){
            currentlyPlaying = sound;
            currentlyPlaying.play();
            currentlyPlaying.setVolume(Constants.Settings.volume);
            currentlyPlaying.playLoop();
        } else{
            currentlyPlaying.setVolume(0);
        }
    }
}
