package UpTo100;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem99 {
    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, node = root;

        while (node != null) {
            if (node.left != null) {
                TreeNode predecessor = node.left;
                while (predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = node;
                    node = node.left;
                } else {
                    if (pred != null && pred.val > node.val) {
                        y = node;
                        if (x == null) x = pred;
                    }

                    pred = node;
                    predecessor.right = null;
                    node = node.right;
                }
            } else {
                if (pred != null && pred.val > node.val) {
                    y = node;
                    if (x == null) x = pred;
                }

                pred = node;
                node = node.right;
            }
        }
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        if (x != y) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    public static void main(String[] args) {
        Problem99 p = new Problem99();
        int[] a = {1,3,0,0,2};
        BinaryTree t = new BinaryTree(a);
        p.recoverTree(t.root);
        BinaryTree.printNode(t.root);
    }
}
