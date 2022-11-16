import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Timer extends Actor{
    int frame = 0;
    int seconds;
    int minutes;
    GreenfootImage image;
    public Timer(int m, int s) {
        seconds=s;
        minutes=m;
        updateImage();
    }

    public void updateImage() {
        image = new GreenfootImage(200,100);
        image.setColor(new Color(255,255,255));
        image.setFont(new Font("Arial", true, false, 50));
        String s = minutes+":";
        if(seconds<10){
            s += "0"+seconds;
        }
        else{
            s+=seconds;
        }
        if(seconds==-1){
            seconds=59;
            minutes--;
            s = minutes+":";
            s+=seconds;
        }
        if(minutes==-1){
            MyWorld.music.changeWorld();
            Greenfoot.setWorld((new EndScreen()));
        }
        image.drawString(s, 5, 100);
        setImage(image);
    }

    public void act(){
        frame++;
        if(frame % 60 == 0) {
            seconds--;
            updateImage();
        }
    }    
}
