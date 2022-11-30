import greenfoot.*;
public class TempImage extends Actor{
    private GreenfootImage animalImage;
    public TempImage(AnimalType animal){
        changeImage(animal);
    }  

    public void changeImage(AnimalType animal){
        switch(animal){
            case PIG : 
            System.out.println("sdas");
            animalImage = new GreenfootImage("Pig.png");
            case COW : animalImage = new GreenfootImage("Cow - Copy.png");
            case CHICKEN :
            animalImage = new GreenfootImage("Chicken.png");
        }
        animalImage.scale(animalImage.getWidth()*5, animalImage.getHeight()*5);
        setImage(animalImage);
    }
}
