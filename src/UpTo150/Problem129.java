package UpTo150;

import utils.TreeNode;

public class Problem129 {
    int ans;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        base(root);
        return ans;
    }

    private int base(TreeNode root) {
        if (root == null) return 0;
        int base = (base(root.left) + base(root.right)) * 10;
        base = base == 0 ? 1 : base;
        ans += root.val * base;
        return base;
    }
}
