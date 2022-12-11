import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class TextDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextDisplay extends Actor
{
    public TextDisplay(String s){
        GreenfootImage partDescText = new GreenfootImage(s, 80, Color.BLACK, null);
        setImage(partDescText);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
