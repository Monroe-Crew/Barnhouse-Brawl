public class Constants  
{
    public static final class Settings{
        public static final boolean debugMode = false;
        public static final int worldWidth = 1280;
        public static final int worldHeight = 960;
        public static final int volume = 30;
    }

    public static final class PlayerControl{
        /*
         * Control order:
         * Index 0 - UP
         * Index 1 - LEFT
         * Index 2 - DOWN
         * Index 3 - RIGHT
         * Index 4 - WHITE / START
         * Index 5 - RED
         * Index 6 - BLUE
         * Index 7 - YELLOW
         */
        
        public static final String[] p1Controls = new String[] { "W", "A", "S", "D", "1", "E", "R", "C" };

        public static final String[] p2Controls = new String[] { "T", "F", "G", "H", "2", "Y", "U", "N" };

        public static final String[] p3Controls = new String[] { "I", "J", "K", "L", "3", "O", "P", "." };

        public static final String[] p4Controls = new String[] { "UP", "LEFT", "DOWN", "RIGHT", "4", "7", "8", "9" };
    }

    public static final class Title{
        public static final double titleSpinSpeed = .1;
    }

    public static final class SelectorScreen{
        public static final double arrowFrequency = 20;
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
        public static final double specialCooldown = .75;
        public static final double eggStrength = 10;
    }

    public static final class Pig{
        public static final int weight = 2;
        public static final double slideLength = 3;
        public static final double specialCooldown = 5; // Includes slide length
    }

    public static final class Cow{
        public static final int weight = 3;
        public static final double mooLength = 0.1;
        public static final double mooStrength = 8;
        public static final double specialCooldown = 5;
    }

    public static final class Goat{
        public static final int weight = 2;
        public static final double dashLength = .75;
        public static final double specialCooldown = 4;
    }
}
