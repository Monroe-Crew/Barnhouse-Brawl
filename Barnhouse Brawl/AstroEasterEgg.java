import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AstroEasterEgg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AstroEasterEgg extends TempImage
{
    int frame = 0;
    boolean animating = false;
    int randomTime = Greenfoot.getRandomNumber(300);
    double rotation = 0;
    double xPos = 1320;
    boolean flip = false;

    public AstroEasterEgg(){
    getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);
    }
    
    public void prepare(){
    xPos = getX();
    }
    
    public void animate(){
        frame++;
        if(frame % (500 + (randomTime)) == 0){
            animating = true;
        }
        if(animating){
            if(rotation > -90 && !flip){
                rotation -= .5;
                xPos -= .3;
                setLocation((int)xPos, getY());
            } else if(rotation < 0){
                flip = true;
                rotation += .5;
                xPos += .3;
                setLocation((int)xPos, getY());
            } else{
                randomTime = Greenfoot.getRandomNumber(300);
                animating = false;
                flip = false;
                frame = 0;
                rotation = 0;
            }
            setRotation((int)rotation);
        }
    }
}
