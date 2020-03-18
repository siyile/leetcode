package Upto250;

import utils.TreeNode;

public class Problem250 {
    private class Node {
        int value;
        boolean isUnival;
        int count;

        Node(int value, boolean isUnival, int count) {
            this.value = value;
            this.isUnival = isUnival;
            this.count = count;
        }
    }

    public int countUnivalSubtrees(TreeNode root) {
        return dfs(root, 0).count;
    }

    private Node dfs(TreeNode root, int parentValue) {
        if (root == null) {
            return new Node(parentValue, true, 0);
        }
        Node left = dfs(root.left, root.val);
        Node right = dfs(root.right, root.val);

        if (left.isUnival && right.isUnival && left.value == right.value && left.value == root.val) {
            return new Node(left.value, true, left.count + right.count + 1);
        } else {
            return new Node(0, false, left.count + right.count);
        }
    }
}
