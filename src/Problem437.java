import utils.TreeNode;

public class Problem437 {
    int s;
    public int pathSum(TreeNode root, int sum) {
        s = sum;
        return path(root, s);
    }

    public int path(TreeNode root, int sum) {
        return root == null ? 0 : (sum - root.val == 0 ? 0 : 1) + path(root.left, sum - root.val) + path(root.right, sum - root.val) + path(root.left, s) + path(root.right, s);
    }
}
