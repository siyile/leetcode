package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem114 {
    public static void main(String[] args) {
        Problem114 p = new Problem114();
        int[] a = {1,2,5,3,4,0,6};
        BinaryTree t = new BinaryTree(a);
        p.flatten1(t.root);
        BinaryTree.printNode(t.root);
    }

    public void flatten1(TreeNode root) {
        flatten1(root, null);
    }

    private TreeNode flatten1(TreeNode node, TreeNode prev) {
        if (node == null) return prev;
        prev = flatten1(node.right, prev);
        prev = flatten1(node.left, prev);
        node.right = prev;
        node.left = null;
        prev = node;
        return prev;
    }

    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                node = node.right;
            } else {
                TreeNode tmp = node.left;
                while (tmp.right != null)
                    tmp = tmp.right;
                tmp.right = node.right;
                node.right = node.left;
                node.left = null;
                node = node.right;
            }

        }
    }
}
