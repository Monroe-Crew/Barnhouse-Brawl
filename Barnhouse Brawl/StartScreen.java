import greenfoot.*; 


public class StartScreen extends World
{

    public StartScreen()
    {    

        super(Constants.Settings.worldWidth, Constants.Settings.worldHeight, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        StartButton startButton = new StartButton();
        addObject(startButton,598,589);
        Title title = new Title();
        addObject(title,634,697);
    }
}
