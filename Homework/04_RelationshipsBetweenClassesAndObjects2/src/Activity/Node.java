package Activity;

import Game.Player;

import java.util.Scanner;

public class Node implements NodeTreeItem {
    private Node parent;
    private Choice[] choices;
    private String prompt;
    private boolean mandatoryChoice = false;

    protected Node() {}

    protected void setParentNode(Node parent) {
        this.parent = parent;
    }

    protected Node getParentNode() {
        return parent;
    }

    protected void setIsMandatoryChoice(boolean mandatoryChoice) {
        if (choices != null && choices.length > 1 && mandatoryChoice) {
            throw new IllegalStateException("Mandatory nodes cannot have more than one choice.");
        }

        this.mandatoryChoice = mandatoryChoice;
    }

    public boolean isMandatoryChoice() {
        return mandatoryChoice;
    }

    protected void setChoices(Choice[] choices) {
        if (isMandatoryChoice() && choices.length > 1) {
            throw new IllegalStateException("Mandatory nodes cannot have more than one choice.");
        }

        this.choices = choices;
    }

    protected void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Choice[] getChoices() {

        if (choices == null) {
            return new Choice[0];
        }

        return choices;
    }

    private Choice receiveChoice() {
        boolean awaitingValidChoice = true;
        int choice = 0;

        if (isMandatoryChoice()) {
            System.out.println(choices[0].getPrompt());
            return choices[0];
        }

        do {
            for(int i = 0; i < choices.length; i++) {
                System.out.printf("%d. - %s\n", i + 1, choices[i].getPrompt());
            }

            System.out.print("Enter your choice: ");

            Scanner inputScanner = new Scanner(System.in);
            String input = inputScanner.nextLine();

            try {
                choice = Integer.parseInt(input);
                awaitingValidChoice = choice < 1 || choice > choices.length;
            } catch (NumberFormatException e) {
                System.out.printf("'%s' is not a valid choice. Please enter a number.\n", input);
            }

        } while (awaitingValidChoice);

        return choices[choice - 1];
    }

    public void execute() {
        System.out.println(Player.getStats());
        System.out.println();
        System.out.println(prompt);
        System.out.println();
        Choice choice = receiveChoice();
        choice.pick();
    }
}
