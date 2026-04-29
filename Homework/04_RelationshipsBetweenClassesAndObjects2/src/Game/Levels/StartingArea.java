package Game.Levels;

import Activity.Choice;
import Activity.ChoiceBuilder;
import Activity.Node;
import Activity.NodeBuilder;
import Game.Instance;
import Game.Player;

public class StartingArea {

    private static Choice getEatBreadChoice() {
        return new ChoiceBuilder()
            .setPrompt("Eat bread")
            .setNextNode(getEatBreadNode())
            .build();
    }

    private static Choice getInspectBreadChoice() {
        return new ChoiceBuilder()
            .setPrompt("Inspect bread")
            .setNextNode(getInspectBreadNode())
            .build();
    }

    private static Choice getDontEatChoice() {
        return new ChoiceBuilder()
            .setPrompt("Put back the bread")
            .setNextNode(getAloneAtHomeNode())
            .build();
    }

    private static Node breakfastNode;
    private static Node getBreakfastNode() {
        if (breakfastNode == null) {
            NodeBuilder builder = new NodeBuilder().setPrompt("You go and grab some bread. You feel hungry.");
            breakfastNode = builder.build();

            builder.addChoice(getEatBreadChoice())
                   .addChoice(getInspectBreadChoice())
                   .addChoice(getDontEatChoice());
        }
        return breakfastNode;
    }

    public static Node getStartNode() {
        Choice getUp = new ChoiceBuilder()
                .setPrompt("Get up")
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

    private static Node getAloneAtHomeNode() {
        Choice goBackToBed = new ChoiceBuilder()
                .setPrompt("Go back to bed")
                .setNextNode(getGoBackToBedNode())
                .build();

        return new NodeBuilder()
                .setPrompt("You are alone at home. You feel bored.")
                .addChoice(goBackToBed)
                .build();
    }

    private static Node getEatBreadNode() {
        Choice takeDamage = new ChoiceBuilder()
                .setPrompt("You got yourself food poisoning! 🤢")
                .setNextNode(getAloneAtHomeNode())
                .setAction(() -> Player.loseHealth(10))
                .build();

        return new NodeBuilder()
                .setPrompt(
                        """
                        You eat the bread. As you start chewing you taste mold
                        
                        Yuck - you're nasty
                        """
                )
                .addChoice(takeDamage)
                .setIsMandatoryChoice()
                .build();
    }

    private static Node getInspectBreadNode() {

        Choice eatBreakfast = new ChoiceBuilder()
                .setPrompt("Go back")
                .setNextNode(getBreakfastNode())
                .build();

        return new NodeBuilder()
                .setPrompt(
                    """
                    You inspect the bread. On first glance it looks okay.
                    
                    You inspect it further and notice some mold on the bread.
                    """
                )
                .addChoice(eatBreakfast)
                .build();
    }

    private static Node getGoBackToBedNode() {
        Choice sleep = new ChoiceBuilder()
                .setPrompt("You died")
                .setAction(() -> {
                    Player.die();
                    Instance.end();
                })
                .build();

        return new NodeBuilder()
                .setPrompt(
                        """
                        You go back to bed, you start to feel very tired and fall asleep quickly.
                        
                        You never wake up.
                        """
                )
                .addChoice(sleep)
                .setIsMandatoryChoice()
                .build();
    }

    private static Node getWhoAreYouNode() {
        Choice eatBreakfast = new ChoiceBuilder()
                .setPrompt("Eat breakfast")
                .setNextNode(getBreakfastNode())
                .build();

        Choice goBackToBed = new ChoiceBuilder()
                .setPrompt("Go back to bed")
                .setNextNode(getGoBackToBedNode())
                .build();

        return new NodeBuilder()
                .setPrompt(
                        """
                        You: "Who are you?"
                        
                        Mysterious man: "I'm nothing more than a manifestation of your destiny."
                        
                        As the mysterious man says this, he starts to dissolve into smoke.
                        
                        You're very confused.
                        """
                )
                .addChoice(goBackToBed)
                .addChoice(eatBreakfast)
                .build();
    }

    private static Node getAttackNode() {
        return new NodeBuilder()
                .setPrompt("")
                .build();
    }

    private static Node getUpNode() {

        Choice whoAreYou = new ChoiceBuilder()
                .setPrompt("Ask him \"Who are you?\"")
                .setNextNode(getWhoAreYouNode())
                .build();

        Choice attack = new ChoiceBuilder()
                .setPrompt("Attack the mysterious man!")
                .setNextNode(getAttackNode())
                .build();

        return new NodeBuilder()
                .setPrompt("You get out of bed and look at the stranger")
                .addChoice(whoAreYou)
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
