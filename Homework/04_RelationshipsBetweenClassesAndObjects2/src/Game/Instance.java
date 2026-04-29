package Game;

import Activity.Choice;
import Activity.ChoiceBuilder;
import Activity.Node;
import Activity.NodeBuilder;
import Game.Levels.StartingArea;

public class Instance {
    private static boolean isRunning = true;

    public static void start() {
        System.out.println("Game starting...");
        StartingArea.getStartNode().execute();
    }

    public static boolean isRunning() {
        return isRunning;
    }

    public static void end() {
        isRunning = false;
        System.out.println();
        System.out.println("=======================================");
        System.out.println("Game has ended");
    }
}
