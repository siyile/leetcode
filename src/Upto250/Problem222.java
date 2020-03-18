package Upto250;

import utils.TreeNode;

public class Problem222 {
    public int countNodes1(TreeNode root) {
        TreeNode node = root;
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        int l = 0, r = (int) Math.pow(2, h - 1) - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (exists(root, m, h)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return (int) Math.pow(2, h - 1) + r;
    }

    private boolean exists(TreeNode root, int m, int d) {
        int l = 0, r = (int) Math.pow(2, d - 1) - 1;
        TreeNode node = root;
        for (int i = 0; i < d - 1; i++) {
            int pivot = (l + r) / 2;
            if (pivot > m) {
                r = pivot - 1;
                node = node.left;
            } else {
                l = pivot;
                node = node.right;
            }
        }
        return node != null;
    }

    private int height(TreeNode node) {
        return node == null ? -1 : height(node.left) + 1;
    }

    public int countNodes(TreeNode root) {
        int h = height(root);
        return height(root.right) == h - 1 ? countNodes(root.right) + (1 << h) : countNodes(root.left) + (1 << h - 1);
    }
}
