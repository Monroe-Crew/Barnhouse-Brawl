import greenfoot.*;
import java.awt.Graphics; 
import java.awt.Font;
import java.awt.FontMetrics; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class TempText extends Actor{
    private String text;
    private int opacity;
    private int scale;
    public TempText(String text){
        this.text = text;
        opacity=255;
        scale=100;
        //scale means intxXint inamge
    }

    public void act(){
        //Makes pic
        scale+=4;
        opacity-=5;
        GreenfootImage image = new GreenfootImage(scale,scale);
        greenfoot.Font fontG = new greenfoot.Font("Arial", scale);
        
        java.awt.Font font = new java.awt.Font("Arial", Font.PLAIN, scale);
        Graphics g = image.getAwtImage().getGraphics();
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics();
        int x = (scale - metrics.stringWidth(text)) / 2;
        int y = (metrics.getAscent() + (scale - (metrics.getAscent() + metrics.getDescent())) / 2);
        
        image.setFont(fontG);
        image.setColor(new Color(0,0,0, opacity));
        image.drawString(text, x, y); //Text dispalying
        setImage(image);
        if(opacity==0){
            getWorld().removeObject(this);
        }
    }

    public void addedToWorld(World world){
        act();
    }
}
