import utils.TreeNode;

public class Problem979 {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        distribute(root);
        return ans;
    }

    public int distribute(TreeNode root) {
        if (root == null) return 1;
        int left = distribute(root.left);
        int right = distribute(root.right);
        ans += Math.abs(1 - left) + Math.abs(1 - right);
        return left - 1 + right - 1 + root.val;
    }
}
