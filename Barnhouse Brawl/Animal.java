import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Animal extends Actor {
    private int weight;
    private int playerID;

    public Animal(int weight, int playerID) {
    }

    enum AnimalType {
        CHICKEN,
        PIG
    }

    public void act() {
        // Add your action code here.
    }

    public void basicPush() {
        // Universal for all characters
    }

    public void movement() {
        // Physics: The heavier the slower you are
    }
}
