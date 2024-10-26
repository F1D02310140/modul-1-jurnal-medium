public class Node {
    public String charName, standName, abilities;
    public char power, speed, range;
    public double rating;

    private Node next = null;
    private Node previous = null;
    protected Object data = null;

    public Node(String charName, String standName, String abilities, char power, char speed, char range, double rating) {
        this.charName = charName;
        this.standName = standName;
        this.abilities = abilities;
        this.power = power;
        this.speed = speed;
        this.range = range;
        this.rating = rating;
    }

    public String getName() {
        return charName;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node newNode) {
        this.next = newNode;
    }

    public Node getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node previousNode) {
        this.previous = previousNode;
    }
}
