import greenfoot.*;

public class Barnhouse extends GameWorld {
    public Barnhouse() {
        super(new GreenfootSound("mapBackground.mp3"));
        prepare();
    }

    protected void prepare() {
        super.prepare();

        for (Player player : AllPlayers.getPlayers()) {
            Animal animal = new Pig(player);
            switch (player.getAnimal()) {
                case COW:
                animal = new Cow(player);
                break;
                case CHICKEN:
                animal = new Chicken(player);
                break;
                case GOAT:
                animal = new Goat(player);
                break;
            }

            switch (player.getPlayerID()) {
                case 1:
                addObject(animal, 200, Constants.Settings.worldHeight - 200);
                break;
                case 2:
                addObject(animal, 200, 200);
                break;
                case 3:
                addObject(animal, Constants.Settings.worldWidth - 200, 200);
                break;
                case 4:
                addObject(animal, Constants.Settings.worldWidth - 200, Constants.Settings.worldHeight - 200);
                break;
            }
        }
        int fenceDistance = 80;

        int topHorizontalX = 324;
        int topHorizontalY = 218;
        Obstacle_FenceHorizontal obstacle_FenceHorizontal = new Obstacle_FenceHorizontal();
        addObject(obstacle_FenceHorizontal,topHorizontalX,topHorizontalY);
        Obstacle_FenceHorizontal obstacle_FenceHorizontal2 = new Obstacle_FenceHorizontal();
        addObject(obstacle_FenceHorizontal2,topHorizontalX+fenceDistance,topHorizontalY);

        Obstacle_FenceHorizontal obstacle_FenceHorizontalInv = new Obstacle_FenceHorizontal();
        addObject(obstacle_FenceHorizontalInv,topHorizontalX,topHorizontalY);
        reflectHorizontally(obstacle_FenceHorizontalInv);
        Obstacle_FenceHorizontal obstacle_FenceHorizontal2Inv = new Obstacle_FenceHorizontal();
        addObject(obstacle_FenceHorizontal2Inv,topHorizontalX+fenceDistance,topHorizontalY);
        reflectHorizontally(obstacle_FenceHorizontal2Inv);

        int topVerticalX = 284;
        int topVerticalY = 258;
        Obstacle_FenceVertical obstacle_FenceVertical = new Obstacle_FenceVertical();
        addObject(obstacle_FenceVertical,topVerticalX,topVerticalY);
        Obstacle_FenceVertical obstacle_FenceVertical2 = new Obstacle_FenceVertical();
        addObject(obstacle_FenceVertical2,topVerticalX,topVerticalY + fenceDistance);

        Obstacle_FenceVertical obstacle_FenceVerticalInv = new Obstacle_FenceVertical();
        addObject(obstacle_FenceVerticalInv,topVerticalX,topVerticalY);
        reflectHorizontally(obstacle_FenceVerticalInv);
        Obstacle_FenceVertical obstacle_FenceVertical2Inv = new Obstacle_FenceVertical();
        addObject(obstacle_FenceVertical2Inv,topVerticalX,topVerticalY + fenceDistance);
        reflectHorizontally(obstacle_FenceVertical2Inv);

        int bottomHorizontalX = 324;
        int bottomHorizontalY = 738;
        Obstacle_FenceHorizontal obstacle_FenceHorizontal3 = new Obstacle_FenceHorizontal();
        addObject(obstacle_FenceHorizontal3,bottomHorizontalX,bottomHorizontalY);
        Obstacle_FenceHorizontal obstacle_FenceHorizontal4 = new Obstacle_FenceHorizontal();
        addObject(obstacle_FenceHorizontal4,bottomHorizontalX + fenceDistance,bottomHorizontalY);

        Obstacle_FenceHorizontal obstacle_FenceHorizontal3Inv = new Obstacle_FenceHorizontal();
        addObject(obstacle_FenceHorizontal3Inv,bottomHorizontalX,bottomHorizontalY);
        reflectHorizontally(obstacle_FenceHorizontal3Inv);
        Obstacle_FenceHorizontal obstacle_FenceHorizontal4Inv = new Obstacle_FenceHorizontal();
        addObject(obstacle_FenceHorizontal4Inv,bottomHorizontalX + fenceDistance,bottomHorizontalY);
        reflectHorizontally(obstacle_FenceHorizontal4Inv);

        int bottomVericalX = 284;
        int bottomVericalY = 618;
        Obstacle_FenceVertical obstacle_FenceVertical3 = new Obstacle_FenceVertical();
        addObject(obstacle_FenceVertical3,bottomVericalX,bottomVericalY);
        Obstacle_FenceVertical obstacle_FenceVertical4 = new Obstacle_FenceVertical();
        addObject(obstacle_FenceVertical4,bottomVericalX,bottomVericalY + fenceDistance);

        Obstacle_FenceVertical obstacle_FenceVertical3Inv = new Obstacle_FenceVertical();
        addObject(obstacle_FenceVertical3Inv,bottomVericalX,bottomVericalY);
        reflectHorizontally(obstacle_FenceVertical3Inv);
        Obstacle_FenceVertical obstacle_FenceVertical4Inv = new Obstacle_FenceVertical();
        addObject(obstacle_FenceVertical4Inv,bottomVericalX,bottomVericalY + fenceDistance);
        reflectHorizontally(obstacle_FenceVertical4Inv);

        Obstacle_FenceHorizontal obstacle_FenceHorizontal9 = new Obstacle_FenceHorizontal();
        addObject(obstacle_FenceHorizontal9,Constants.Settings.worldWidth/2, Constants.Settings.worldHeight/2);
        Obstacle_FenceVertical obstacle_FenceVertical9 = new Obstacle_FenceVertical();
        addObject(obstacle_FenceVertical9,Constants.Settings.worldWidth/2, Constants.Settings.worldHeight/2);
    }
    
    public void reflectHorizontally(Actor actor){
        actor.setLocation(Constants.Settings.worldWidth-actor.getX(), actor.getY());
    }
}
