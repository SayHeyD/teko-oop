package Activity;

public class NodeBuilder implements Builder {
    private final Node node;

    public NodeBuilder() {
        node = new Node();
    }

    public NodeBuilder setParentNode(Node parent) {
        node.setParentNode(parent);
        return this;
    }

    public NodeBuilder addChoice(Choice choice) {
        Choice[] choices = node.getChoices();

        Choice[] newChoices = new Choice[choices.length + 1];
        System.arraycopy(choices, 0, newChoices, 0, choices.length);
        newChoices[choices.length] = choice;
        node.setChoices(newChoices);

        return this;
    }

    public NodeBuilder setPrompt(String prompt) {
        node.setPrompt(prompt);
        return this;
    }

    public Node build() {
        return node;
    }
}
