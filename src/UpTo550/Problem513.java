package UpTo550;

import utils.TreeNode;

public class Problem513 {
    int level = -1;
    int ans = -1;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int curLevel) {
        if (root == null) {
            return;
        }
        if (curLevel > level) {
            ans = root.val;
            level = curLevel;
        }
        helper(root.left, curLevel + 1);
        helper(root.right, curLevel + 1);
    }
}
