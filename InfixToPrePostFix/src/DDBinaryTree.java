import java.util.Iterator;
import java.util.Stack;

/**
 * Binary Tree.
 */


public class DDBinaryTree<E>{

    protected Node<E> root;

    /**
     * Constructs an empty binary tree.
     */
    public DDBinaryTree() {

    }

    /**
     * Constructs a binary tree with given data in the root and the specified left and right
     * subtrees.
     *
     * @param data The data to store in root.
     * @param leftTree The left subtree.
     * @param rightTree The right subtree.
     */
    public DDBinaryTree(E data, DDBinaryTree<E> leftTree, DDBinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree!=null) {
            root.left = leftTree.root;
        }
        if (rightTree!=null) {
            root.right = rightTree.root;
        }
    }

    /**
     * Constructs a binary tree with a given node as its root.
     * @param root The root of the binary tree.
     */
    protected DDBinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Gets the left subtree of this tree.
     * @return The left subtree, or null if it doesn't exist.
     */
    public DDBinaryTree<E> getLeftSubtree() {
        if (root!=null && root.left!=null) return new DDBinaryTree<E>(root.left);
        else return null;
    }

    /**
     * Gets the right subtree of this tree.
     * @return The right subtree, or null if it doesn't exist.
     */
    public DDBinaryTree<E> getRightSubtree() {
        if (root!=null && root.right!=null) return new DDBinaryTree<E>(root.right);
        else return null;
    }

    /**
     * Gets the data from the root node.
     * @return The data from the root, or null if tree is empty.
     */
    public E getData() {
        if (root!=null) return root.data;
        else return null;
    }

    /**
     * Checks if tree is empty
     * @return true if root is null, and false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Checks if tree is a leaf.
     * @return true if this tree is a leaf, and false otherwise.
     */
    public boolean isLeaf() {
        return root != null && root.left == null && root.right == null;
    }

    /**
     * Performs a preorder traversal, executing the specified operation
     * on the data in each node it visits.
     *
     * @param visitOperation An operation to apply to the data of each visited node.
     */
    protected void preOrderTraversal(ProcessData<E> visitOperation) {
        preOrderTraversal(root, visitOperation);
    }

    private void preOrderTraversal(Node<E> node, ProcessData<E> visitOperation) {
        if (node==null) return;
        visitOperation.process(node.data);
        preOrderTraversal(node.left, visitOperation);
        preOrderTraversal(node.right, visitOperation);
    }

    /**
     * Performs a postorder traversal, executing the specified operation
     * on the data in each node it visits.
     *
     * @param visitOperation An operation to apply to the data of each visited node.
     */
    protected void postOrderTraversal(ProcessData<E> visitOperation) {
        postOrderTraversal(root, visitOperation);
    }

    private void postOrderTraversal(Node<E> node, ProcessData<E> visitOperation) {
        if (node==null) return;
        postOrderTraversal(node.left, visitOperation);
        postOrderTraversal(node.right, visitOperation);
        visitOperation.process(node.data);
    }

    /**
     * Performs a inorder traversal, executing the specified operation
     * on the data in each node it visits.
     *
     * @param visitOperation An operation to apply to the data of each visited node.
     */
    protected void inOrderTraversal(ProcessData<E> visitOperation) {
        inOrderTraversal(root, visitOperation);
    }

    private void inOrderTraversal(Node<E> node, ProcessData<E> visitOperation) {
        if (node==null) return;
        if (node.left != null && visitOperation instanceof PrePostProcess){
            ((PrePostProcess<E>)visitOperation).pre();

        }

        inOrderTraversal(node.left, visitOperation);
        visitOperation.process(node.data);
        inOrderTraversal(node.right, visitOperation);

        if (node.right != null && visitOperation instanceof PrePostProcess){
            ((PrePostProcess<E>)visitOperation).post();
        }
    }

    protected interface ProcessData<E> {
        void process(E data);
    }

    protected interface PrePostProcess<E> extends ProcessData<E> {
        void pre();
        void post();
    }

    protected static class Node<E> {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        /**
         * Constructs a Node containing the given data.
         * @param data Data to store in node
         */
        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}

