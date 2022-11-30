public class Constants  
{
    public static final class Settings{
        public static final boolean debugMode = false;
        public static final int worldWidth = 1280;
        public static final int worldHeight = 960;
        public static final int volume = 30;
    }
    
    public static final class Title{
        public static final double titleSpinSpeed = .1;
    }
    
    public static final class SelectorScreen{
        public static final double arrowFrequency = 10;
        public static final double arrowAmplitude = .25;
    }
    
    public static final class Animal{
        public static final double pushCooldown = .5;
        public static final double friction = .9;
        public static final double movementSpeed = .75;
        
        public static final double defaultKnockback = 1;
        public static final double lowTimeKnockback = 1.5;
    }
    
    public static final class Chicken{
        public static final int weight = 1;
        public static final double specialCooldown = .5;
    }
    
    public static final class Pig{
        public static final int weight = 2;
        public static final double slideLength = 3;
        public static final double specialCooldown = 5; // Includes slide length
    }
    
    public static final class Cow{
        public static final int weight = 3;
        public static final double mooLength = 0.1;
        public static final double specialCooldown = 10;
    }
}
