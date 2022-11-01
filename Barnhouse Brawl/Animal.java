import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Animal extends Actor {
    private int weight;
    private int playerID;

    public Animal(int weight, int playerID) {
        this.weight = weight;
        this.playerID = playerID;
    }

    enum AnimalType {
        CHICKEN,
        PIG
    }
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public void act() {
        if(playerID==1){
            //Player 1 controls
            if(Greenfoot.isKeyDown("W")){
                movement(Direction.UP);
            }
            if(Greenfoot.isKeyDown("A")){
                movement(Direction.LEFT);
            }
            if(Greenfoot.isKeyDown("S")){
                movement(Direction.DOWN);
            }
            if(Greenfoot.isKeyDown("D")){
                movement(Direction.RIGHT);
            }
        }
        if(playerID==2){
            //Player 2 controls
            if(Greenfoot.isKeyDown("U")){
                movement(Direction.UP);
            }
            if(Greenfoot.isKeyDown("H")){
                movement(Direction.LEFT);
            }
            if(Greenfoot.isKeyDown("J")){
                movement(Direction.DOWN);
            }
            if(Greenfoot.isKeyDown("K")){
                movement(Direction.RIGHT);
            }
        }
    }

    public void basicPush() {
        // Universal for all characters
    }

    public void movement(Direction direction) {
        // Physics: The heavier the slower you are
        int change = 5/weight;
        switch(direction){
            case UP: 
            setLocation(getX(), getY()-change);
            while(this.isTouching(Animal.class)) {
                setLocation(getX(), getY()+1);
            }
            break;

            case DOWN: 
            setLocation(getX(), getY()+change);
            while(this.isTouching(Animal.class)) {
                setLocation(getX(), getY()-1);
            }
            break;

            case LEFT: 
            setLocation(getX()-change, getY());
            while(this.isTouching(Animal.class)) {
                setLocation(getX()+1, getY());
            }
            break;

            case RIGHT: 
            setLocation(getX()+change, getY());
            while(this.isTouching(Animal.class)){ 
                setLocation(getX()-1, getY());
            }
            break;
        }
    }
}
