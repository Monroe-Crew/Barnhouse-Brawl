import greenfoot.*;
public class SelectorBox extends Actor{
    private String[] controls;  
    private AnimalType[] animals;
    private TempImage preview;
    int iterate;
    int frame = 30;
    public SelectorBox(int playerID){
        /* Control order:
         * Index 0 - Join / Select
         * Index 1 - Left
         * Index 2 - Right
         */

        iterate=0;
        getImage().scale((int)(getImage().getWidth()*3.35), (int)(getImage().getHeight()*3.35));

        controls = new String[]{"-","-","-"};
        if(playerID==1) controls = new String[]{"1", "A","D"};
        if(playerID==2) controls = new String[]{"2","LEFT","RIGHT"};
        if(playerID==3) controls = new String[]{"3", "J","L"};
        if(playerID==4) controls = new String[]{"4","1","3"};

        animals = new AnimalType[]{AnimalType.PIG, AnimalType.COW, AnimalType.CHICKEN};
    }

    @Override
    public void addedToWorld(World world) {
        preview = new TempImage(animals[0]);
        getWorld().addObject(preview, getX(), getY());
    }

    public void act() {
        if(frame < 30) frame++;

        if(Greenfoot.isKeyDown(controls[2]) && frame == 30){
            iterate = (iterate + 1) % (animals.length);
            System.out.println(iterate);
            getWorld().removeObject(preview);
            preview = new TempImage(animals[iterate]);
            getWorld().addObject(preview, getX(), getY());
            frame = 0;
        }
    }
}
