package tree;

public class Tree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums, 0, nums.length - 1);
    }

    public TreeNode traverse(int[] nums, int left, int right) {
        if (left > right) return null;

        int index = max(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);

        TreeNode leftNode = traverse(nums, left, index - 1);
        TreeNode rightNode = traverse(nums, index + 1, right);

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

    public int max(int[] nums, int left, int right) {
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[index]) index = i;
        }
        return index;
    }
}
