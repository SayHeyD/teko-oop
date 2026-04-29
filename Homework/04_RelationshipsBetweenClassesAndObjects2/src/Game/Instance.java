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
        System.out.println();
        System.out.println("=======================================");
        System.out.println("Game has ended");
    }

    private static Node getStartNode() {

        Choice getUp = new ChoiceBuilder()
                .setPrompt("Get up and explore the world!")
                .setNextNode(getUpNode())
                .build();

        Choice stayInBed = new ChoiceBuilder()
                .setPrompt("Stay in bed and sleep...")
                .setNextNode(getStayInBedNode())
                .build();

        return new NodeBuilder()
                .setPrompt("Mysterious man: \"Wake up adventurer, it's time to find some treasure!\"")
                .addChoice(getUp)
                .addChoice(stayInBed)
                .build();
    }

    private static Node getUpNode() {
        return new NodeBuilder()
                .setPrompt("You are standing on the ground. You can't see anything.")
                .build();
    }

    private static Node getStayInBedNode() {

        String prompt =
                """
                You fall back into a deep slumber...
                
                The mysterious man is quite annoyed by this. He stabs you in your sleep.
                """;

        Choice die = new ChoiceBuilder()
                .setPrompt("You die")
                .setAction(() -> { Player.die(); Instance.end(); })
                .build();

        return new NodeBuilder()
                .setPrompt(prompt)
                .setIsMandatoryChoice()
                .addChoice(die)
                .build();
    }
}
