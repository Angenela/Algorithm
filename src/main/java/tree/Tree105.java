package tree;

public class Tree105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traverse(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode traverse(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) return null;

        // 因为前序遍历第一个节点就是根节点，所以直接创建根节点
        TreeNode root = new TreeNode(preorder[preL]);

        // 根据中序遍历分割左右子树
        int index = inL;
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == preorder[preL]) {
                index = i;
                break;
            }
        }

        int leftSize = index - inL;

        // 创建左右子树
        TreeNode left = traverse(preorder, preL + 1, preR + leftSize, inorder, inL, index - 1);
        TreeNode right = traverse(preorder, preL + leftSize + 1, preR, inorder, index + 1, inR);

        root.left = left;
        root.right = right;

        return root;
    }
}
