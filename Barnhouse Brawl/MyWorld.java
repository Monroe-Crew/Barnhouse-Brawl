import greenfoot.*;
public class MyWorld extends World{
    public MyWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 960, 1); 
        prepare();
    }

    private void prepare(){
        Animal animal = new Animal(1, 1);
        addObject(animal, 669, 673);
        Animal animal2 = new Animal(1, 2);
        addObject(animal2, 316, 371);
        Animal animal3 = new Animal(3, 3);
        addObject(animal3, 700, 361);
        Animal animal4 = new Animal(5, 0);
        addObject(animal4, 1074, 360);
    }
}
