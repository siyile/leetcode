package UpTo150;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> roots = new Stack<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (node.left == null && node.right == null) {
                ans.add(node.val);
            } else if (roots.isEmpty() || roots.peek() != node) {
                nodes.push(node);
                roots.push(node);
                if (node.right != null) {
                    nodes.push(node.right);
                }
                if (node.left != null) {
                    nodes.push(node.left);
                }
            } else {
                ans.add(roots.pop().val);
            }
        }
        return ans;
    }
}
