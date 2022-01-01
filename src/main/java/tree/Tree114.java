package tree;

public class Tree114 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        // 拉平两端
        flatten(root.left);
        flatten(root.right);

        // 两端已经是一个链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 接成一条链表
        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) p = p.right;
        p.right = right;
    }
}
