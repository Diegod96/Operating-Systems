import java.util.Iterator;
import java.util.Stack;

/**
 * Binary Search Tree
 */
public class DDBinarySearchTree<E extends Comparable<E>> extends DDBinaryTree implements Iterable<E> {
    static final int COUNT = 5;

    /**
     * Searches tree for target.
     *
     * @param target The element to look for.
     * @return true if in tree, and false otherwise
     */
    public boolean contains(E target) {
        return contains(root, target);
    }

    /**
     * Adds target to tree if it doesn't already exist.
     *
     * @param target The element to add.
     * @return true if target added and false otherwise.
     */
    public boolean add(E target) {
        if (root == null) {
            root = new Node<E>(target);
            return true;
        }
        return add(root, target);
    }

    /**
     * Output contents in order.
     */
    public void printOrderedData() {
        inOrderTraversal(new ProcessData<E>() {
            @Override
            public void process(E data) {
                System.out.print(data + " ");
            }
        });
    }

    private boolean contains(Node<E> subtreeRoot, E target) {
        if (subtreeRoot == null) return false;
        if (target.compareTo(subtreeRoot.data) == 0) return true;
        else if (target.compareTo(subtreeRoot.data) < 0)
            return contains(subtreeRoot.left, target);
        else
            return contains(subtreeRoot.right, target);
    }


    private boolean add(Node<E> subtreeRoot, E target) {
        if (target.compareTo(subtreeRoot.data) == 0) return false;
        else if (target.compareTo(subtreeRoot.data) < 0) {
            if (subtreeRoot.left == null) {
                subtreeRoot.left = new Node<E>(target);
                return true;
            }
            return add(subtreeRoot.left, target);
        } else {
            if (subtreeRoot.right == null) {
                subtreeRoot.right = new Node<E>(target);
                return true;
            }
            return add(subtreeRoot.right, target);
        }
    }






    public Iterator<E> iterator(){


        /**
         * Returns new iterator
         */
        return new Iterator<E>() {

            Stack<Node> theStack = new Stack<Node>();
            Node<E> current = root;

            /**
             * Check if:
             * 1.Stack is empty
             * 2.Current node doesn't exist
             */
            @Override
            public boolean hasNext() {
                return (!theStack.isEmpty() || current != null);
            }


            /**
             * Goes down the left path of the tree
             * Every node it goes to, pops into stack
             * Updates current
             */

            @Override
            public E next() {
                E item = null;
                while (hasNext()) {
                    if (current != null) {
                        theStack.push(current);
                        current = current.left;
                    } else {
                        current = theStack.pop();
                        item = current.data;
                        current = current.right;
                        break;
                    }
                }
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            public E specialMethod() {
                while (hasNext()) {

                    if (current.right != null) {
                        theStack.push(current);
                        current = current.right;
                    }

                    if (current.left != null) {
                        theStack.push(current);
                        current = current.left;
                    }
                    Node topNode = theStack.peek();
                    while (!theStack.isEmpty() && current.right == topNode) {
                        current = topNode;
                        Node temp = theStack.pop();
                    }
                    if (theStack.isEmpty()) {
                        current = null;
                    } else {
                        current = topNode;
                        Node temp = theStack.pop();
                    }


                }
                return current.data;
            }
        };
    }
}


