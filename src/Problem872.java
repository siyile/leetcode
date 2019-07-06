import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem872 {
    Queue<Integer> leaves = new LinkedList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        traverse(root1);
        return valid(root2);
    }

    public void traverse(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        } else {
            traverse(node.left);
            traverse(node.right);
        }
    }

    public boolean valid(TreeNode node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) {
            if (leaves.isEmpty()) {
                return false;
            } else {
                return leaves.poll() == node.val;
            }
        } else {
            return valid(node.left) && valid(node.right);
        }
    }
}
