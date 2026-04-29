package Activity;

public class Choice implements NodeTreeItem {
    private Node nextNode;
    private String prompt;
    private Runnable action;

    public Choice() {}

    protected Choice(Node nextNode) {
        this.nextNode = nextNode;
    }

    protected void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    protected void setAction(Runnable action) {
        this.action = action;
    }

    protected Node getNextNode() {
        return nextNode;
    }

    protected void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void pick() {
        if (action != null) {
            action.run();
        }

        if (nextNode != null) {
            nextNode.execute();
        }
    }
}
