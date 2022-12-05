import greenfoot.*;
public class TempImage extends Actor{
    private GreenfootImage animalImage;
    public TempImage(AnimalType animal){
        changeImage(animal);
    }  
    public TempImage(String name){
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
        animalImage.scale(animalImage.getWidth()*5, animalImage.getHeight()*5);
        setImage(animalImage);
    }
    
    public void changeImage(String name){
        animalImage = new GreenfootImage(name);
        animalImage.scale(animalImage.getWidth()*5, animalImage.getHeight()*5);
        setImage(animalImage);
    }
}
