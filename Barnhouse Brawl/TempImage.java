import greenfoot.*;
public class TempImage extends Actor{
    private GreenfootImage animalImage;
    public TempImage(AnimalType animal){
        changeImage(animal);
    }  

    public void changeImage(AnimalType animal){
        switch(animal){
            case PIG : 
            animalImage = new GreenfootImage("Pig.png");
            break;
            case COW : 
            animalImage = new GreenfootImage("Cow - Copy.png");
            break;
            case CHICKEN :
            animalImage = new GreenfootImage("Chicken.png");
            break;
        }
        animalImage.scale(animalImage.getWidth()*5, animalImage.getHeight()*5);
        setImage(animalImage);
    }
}
