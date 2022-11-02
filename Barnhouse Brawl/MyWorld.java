import greenfoot.*;
public class MyWorld extends World{
    public MyWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 960, 1); 
        prepare();
    }

    private void prepare(){
        Animal animal = new Animal(1, 0);
        addObject(animal,612,617);
        Animal animal2 = new Animal(1, 1);
        addObject(animal2,244,366);
        Animal animal3 = new Animal(3, 2);
        addObject(animal3,646,369);
        Animal animal4 = new Animal(5, 3);
        addObject(animal4,1066,379);
    }
}
