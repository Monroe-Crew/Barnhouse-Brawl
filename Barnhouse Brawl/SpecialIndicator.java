import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class specialIndicator here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class SpecialIndicator extends BobbingImage {
    private Animal animal;
    private boolean redGrey = false;
    GreenfootImage greyCircle = new GreenfootImage("GreyCircle.png");
    GreenfootImage activeCircle;

    public SpecialIndicator(Animal animal) {
        super(1, 10);
        switch(animal.getPlayer().getColor()){
            case RED :
                activeCircle = new GreenfootImage("RedCircle.png");
                break;
            case BLUE :
                activeCircle = new GreenfootImage("BlueCircle.png");
                break;
            case YELLOW :
                activeCircle = new GreenfootImage("YellowCircle.png");
                break;
            case GREEN :
                activeCircle = new GreenfootImage("GreenCircle.png");
                break;
        }
        greyCircle.scale(greyCircle.getWidth() * 4, greyCircle.getHeight() * 4);
        activeCircle.scale(activeCircle.getWidth() * 4, activeCircle.getHeight() * 4);
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void act() {
        super.act();
        // Optomize by creating a subclass to tempImage
        if (getAnimal().getAbilityTimer() < getAnimal().getSpecialCooldown() && !redGrey) {
            redGrey = true;
            changeImage(new GreenfootImage(greyCircle));
            stopAnimation();
        } else if (getAnimal().getAbilityTimer() > getAnimal().getSpecialCooldown() && redGrey) {
            redGrey = false;
            changeImage(new GreenfootImage(activeCircle));
            startAnimation();
        }
        if (animal.getDead()) {
            getWorld().removeObject(this);
        }
    }
}
