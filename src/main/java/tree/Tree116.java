package tree;

public class Tree116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) return null;
        doConnect(root.left, root.right);
        return root;
    }

    public void doConnect(Node left, Node right){
        if (left == null || right == null) return;

        left.next = right;

        doConnect(left.left, left.right);
        doConnect(right.left, right.right);
        doConnect(left.right, right.left);
    }
}
