import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class specialIndicator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialIndicator extends TempImage
{
    private int width;
    private int height;
    private Animal animal;
    private boolean redGrey = false;
    
    public SpecialIndicator(String name, Animal animal){
        super(name);
        width = getImage().getWidth();
        height = getImage().getHeight();
        this.animal=animal;
        changeImage(name);
    }
    
    public Animal getAnimal(){
        return animal;
    }
    
    public void act() 
    {
        super.act();
        //Optomize by creating a subclass to tempImage
        if(getAnimal().getAbilityTimer()<getAnimal().getSpecialCooldown() && !redGrey){
            redGrey=true;
            changeImage("GreyCircle.png");
            stopAnimation();
        }
        else if(getAnimal().getAbilityTimer()>getAnimal().getSpecialCooldown() && redGrey){
            redGrey=false;
            changeImage("RedCircle.png");
            startAnimation();
        }
    }    
}
