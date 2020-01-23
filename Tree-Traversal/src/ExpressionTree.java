import java.util.*;

public class ExpressionTree {

    private class Node {
        private String data;
        private Node left;
        private Node right;

        private boolean isLeaf() {
            return (left == null && right == null);
        }
    }

    private Node root;
    private Scanner userInput;

    public ExpressionTree() {
        root = null;
        userInput = new Scanner(System.in);

    }


}