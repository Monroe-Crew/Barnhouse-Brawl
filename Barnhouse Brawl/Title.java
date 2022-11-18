import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    double rotation = 0;
    public void act() 
    {
        setRotation((int)((Math.sin(rotation)*100)/30));
        rotation += (Constants.Title.titleSpinSpeed);
        //if(rotation == 1) rotation = -1;
    }    
}
