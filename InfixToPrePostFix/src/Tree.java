class Tree {

    String input = new String();
    Node root;
    int totalNodes = 0;
    int maxHeight = 0;

    Tree() {
        root = null;
    }

    public int getHeight(Node t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + max(getHeight(t.left), getHeight(t.right));
        }
    }

    public int max(int a, int b){
        if (a > b){
            return a;
        }else{
            return b;
        }
    }

    public void getPosition(){
        int depth = 1;
        inorderTraversal(root, depth);
    }

    public void inorderTraversal(Node t, int depth){
        if (t != null){
            inorderTraversal(t.left, depth + 1);
            t.xpos = totalNodes ++;
            t.ypos = depth;
            inorderTraversal(t.right, depth + 1);
        }
    }

    public Node insert(Node root, String s){
        if (root == null){
            root = new Node(s, null, null);
            return root;
        }else{
            if (s.compareTo((String)(root.data)) == 0) {
                return root;
            }else{
                if (s.compareTo((String)(root.data)) < 0){
                    root.left = insert(root.left, s);
                }else{
                    root.right = insert(root.right, s);
                }
                return root;
            }
        }

    }

}

class Node {

    Object data;
    Node left, right;
    int xpos, ypos;

    Node(String x, Node l, Node r) {
        left = l;
        right = r;
        data = x;
    }
}