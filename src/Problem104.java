import utils.BinaryTree;
import utils.TreeNode;

public class Problem104 {
    public int maxDepth(TreeNode root) {
        return maxDepthRecursive(root, 0);
    }

    private int maxDepthRecursive(TreeNode node, int height) {
        if (node == null) return height;
        return Math.max(maxDepthRecursive(node.left, height + 1), maxDepthRecursive(node.right, height + 1));
    }

    public static void main(String[] args) {
        Problem104 p = new Problem104();
        int [] a = {3,9,20,0,0,15,7};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.maxDepth(t.root));
    }
}
