package Activity;

public class ChoiceBuilder implements Builder {
    private final Choice choice;

    public ChoiceBuilder() {
        choice = new Choice();
    }

    public ChoiceBuilder setNextNode(Node nextNode) {
        choice.setNextNode(nextNode);
        return this;
    }

    public ChoiceBuilder setPrompt(String prompt) {
        choice.setPrompt(prompt);
        return this;
    }

    public ChoiceBuilder setAction(Runnable action) {
        choice.setAction(action);
        return this;
    }

    public Choice build() {
        return choice;
    }
}
