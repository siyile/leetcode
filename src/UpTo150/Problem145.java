package UpTo150;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem145 {
    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> output = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            output.push(node.val);
            if (node.left != null)
                deque.push(node.left);
            if (node.right != null)
                deque.push(node.right);
        }
        return new ArrayList<>(output);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        TreeNode node = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty() || node != null) {
            while (!isLeaf(node)) {
                deque.push(node);
                node = node.left;
            }

            if (node != null) ans.add(node.val);

            while (!deque.isEmpty() && node == deque.peek().right) {
                node = deque.pop();
                ans.add(node.val);
            }

            if (deque.isEmpty()) node = null;
            else node = deque.peek().right;
        }
        return ans;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) return true;
        return node.left == null && node.right == null;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur, prev = null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        deque.push(root);
        while (!deque.isEmpty()) {
            cur = deque.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    deque.push(cur.left);
                } else if (cur.right != null) {
                    deque.push(cur.right);
                } else {
                    ans.add(deque.pop().val);
                }
            } else if (cur.left == prev) {
                if (cur.right != null)
                    deque.push(cur.right);
                else {
                    ans.add(deque.pop().val);
                }
            } else if (cur.right == prev) {
                ans.add(deque.pop().val);
            }
            prev = cur;
        }
        return ans;
    }
}
