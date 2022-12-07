import greenfoot.*;
public class TempImage extends Actor{
    private GreenfootImage animalImage;
    private int frame;
    private int time;
    private int width;
    private int height;
    private boolean animate = true;
    public TempImage(AnimalType animal){
        width = getImage().getWidth();
        height = getImage().getHeight();
        changeImage(animal);
    }  

    public TempImage(String name){
        width = getImage().getWidth();
        height = getImage().getHeight();
        changeImage(name);
    }

    public void changeImage(AnimalType animal){
        switch(animal){
            case PIG : 
            animalImage = new GreenfootImage("Pig.png");
            break;
            case COW : 
            animalImage = new GreenfootImage("Cow.png");
            break;
            case CHICKEN :
            animalImage = new GreenfootImage("Chicken.png");
            break;
        }
        animalImage.scale(animalImage.getWidth()*4, animalImage.getHeight()*4);
        setImage(animalImage);
    }

    public void act(){
        time++;
        if(animate){animate();}
    }

    public void changeImage(String name){
        animalImage = new GreenfootImage(name);
        animalImage.scale(animalImage.getWidth()*4, animalImage.getHeight()*4);
        setImage(animalImage);
    }

    public void animate(){
        frame++;
        GreenfootImage placeholder = new GreenfootImage(animalImage);
        double tempW = animalImage.getWidth() + 1*Math.abs(width * Math.sin(time/10.0));
        double tempH = animalImage.getHeight() + 1*Math.abs(height * Math.sin(time/10.0));
        placeholder.scale((int)tempW, (int)tempH);
        setImage(placeholder);
        frame = 0;
        if(frame == Integer.MAX_VALUE) frame = 0;
    }

    public void stopAnimation(){
        animate=false;
    }
    
    public void startAnimation(){
        animate=true;
    }
}
