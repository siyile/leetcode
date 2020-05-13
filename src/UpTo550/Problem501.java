package UpTo550;

import utils.TreeNode;

public class Problem501 {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        currVal = root.val;
        inorder(root);
        modes = new int[modesCount];
        modesCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    int modesCount = 0;
    int maxCount = 0;
    int currCount = 0;
    int currVal = 0;

    int[] modes;

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        handle(node.val);
        inorder(node.right);
    }

    private void handle(int val) {
        if (currVal != val) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modesCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null) {
                modes[modesCount] = val;
            }
            modesCount++;
        }
    }
}
