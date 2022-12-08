import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class specialIndicator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialIndicator extends BobbingImage
{
    private Animal animal;
    private boolean redGrey = false;
    GreenfootImage greyCircle = new GreenfootImage("GreyCircle.png");
    GreenfootImage redCircle = new GreenfootImage("RedCircle.png");
    
    public SpecialIndicator(Animal animal){
        super(1, 10);
        greyCircle.scale(greyCircle.getWidth()*4, greyCircle.getHeight()*4);
        redCircle.scale(redCircle.getWidth()*4, redCircle.getHeight()*4);
        this.animal=animal;
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
            changeImage(new GreenfootImage(greyCircle));
            stopAnimation();
        }
        else if(getAnimal().getAbilityTimer()>getAnimal().getSpecialCooldown() && redGrey){
            redGrey=false;
            changeImage(new GreenfootImage(redCircle));
            startAnimation();
        }
    }    
}
