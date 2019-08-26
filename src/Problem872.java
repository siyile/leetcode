import utils.TreeNode;

import java.util.Stack;

public class Problem872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (preOrder(s1) != preOrder(s2)) return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }

    private int preOrder(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.left != null) s.push(node.left);
            if (node.right != null) s.push(node.right);
            if (node.left == null && node.right == null) return node.val;
        }
    }
}
