package Activity;

public class Choice implements NodeTreeItem {
    private Node nextNode;
    private String prompt;
    // TODO: implement custom actions for choices

    public Choice() {}

    protected Choice(Node nextNode) {
        this.nextNode = nextNode;
    }

    protected void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
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
        nextNode.execute();
    }
}
