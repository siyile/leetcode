package UpTo150;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            ans.add(node.val);
            while (node != null) {
                if (node.left != null) ans.add(node.left.val);
                if (node.right != null) s.push(node.right);
                node = node.left;
            }
        }
        return ans;
    }
}
