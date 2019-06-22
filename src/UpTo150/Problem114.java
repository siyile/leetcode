package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode node = root, temp;
        while (node.left != null || node.right != null) {
            if (node.left != null) {
                if (node.right != null) {
                    temp = node.left;
                    while (temp.right != null) { // temp is now target place for place right.node
                        temp = temp.right;
                    }
                    temp.right = node.right;
                }
                node.right = node.left;
                node.left = null;
                node = node.right;
            } else {
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        Problem114 p = new Problem114();
        int[] a = {1,2,5,3,4,0,6};
        BinaryTree t = new BinaryTree(a);
        p.flatten(t.root);
        BinaryTree.printNode(t.root);
    }
}
