package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Tree652 {
    private HashMap<String, Integer> map = new HashMap<>();
    private List<TreeNode> result = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    public String traverse(TreeNode root) {
        if (root == null) return "*";

        String left = traverse(root.left);
        String right = traverse(root.right);
        String key = left + "," + right + "," + root.val;

        Integer count = map.getOrDefault(key, 0);
        if (count == 1) result.add(root);
        map.put(key, count + 1);

        return key;
    }
}
