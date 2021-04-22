package SecondTask;

public class Node {

    private int key;
    private Node left, right, parent;
    private String color;


    public Node(){}

    public Node(String color){
        this.color = color;
    }

    public int getKey() {
        return key;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public Node getParent() {
        return parent;
    }
    public String getColor() {
        return color;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        Node other = (Node) obj;
        if(other.color == this.color && other.key == this.key){
            return true;
        }
        else {
            return false;
        }

    }
}