import utils.BinaryTree;
import utils.TreeNode;

public class Problem112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSumRecursive(root, sum);
    }

    public boolean hasPathSumRecursive(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum == root.val) return true;
        return hasPathSumRecursive(root.left, sum - root.val) || hasPathSumRecursive(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Problem112 p = new Problem112();
        int[] a = {1,2};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.hasPathSum(t.root, 1));
    }
}
