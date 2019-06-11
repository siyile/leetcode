import utils.BinaryTree;
import utils.TreeNode;

import java.util.Stack;

public class Problem101 {
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
        }
        return left == null && right == null;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root);
        s2.push(root);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();
            if (node1 == null && node2 == null) continue;
            if (node1 != null && node2 != null) {
                if (node1.val != node2.val) return false;
                s1.push(node1.right);
                s1.push(node1.left);
                s2.push(node2.left);
                s2.push(node2.right);
            } else {
                return false;
            }

        }
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        Problem101 p = new Problem101();
        int[] a = {1,2,2,0,3,0,3};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.isSymmetric(t.root));
    }
}
