package Game;

import Activity.Choice;
import Activity.ChoiceBuilder;
import Activity.Node;
import Activity.NodeBuilder;

public class Instance {
    private static boolean isRunning = true;

    public static void start() {
        System.out.println("Game starting...");
        Instance.getStartNode().execute();
    }

    public static boolean isRunning() {
        return isRunning;
    }

    public static void end() {
        isRunning = false;
        System.out.println("Game has ended");
    }

    private static Node getStartNode() {

        Choice getUp = new ChoiceBuilder()
                .setPrompt("Get up and explore the world!")
                .setNextNode(getExploreNode())
                .build();

        Choice stayInBed = new ChoiceBuilder()
                .setPrompt("Stay in bed and sleep...")
                .setNextNode(getStayInBedNode())
                .build();

        Node start = new NodeBuilder()
                .setPrompt("Mysterious man: \"Wake up adventurer, it's time to find some treasure!\"")
                .addChoice(stayInBed)
                .build();

        return start;
    }

    private static Node getStayInBedNode() {
        StringBuilder prompt = new StringBuilder("You fall back into a deep slumber...\n");

        prompt.append("\n");
        prompt.append("The mysterious man is quite annoyed by this. He stabs you in your sleep and you die.");

        return new NodeBuilder()
                .setPrompt(prompt.toString())
                .build();
    }
}
