package UpTo350;

import utils.TreeNode;

public class Problem333 {
    int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        int[] arr = new int[2];
        isBST(root, arr);
        return res;
    }

    private int isBST(TreeNode root, int[] arr) {
        if (root == null) {
            arr[0] = Integer.MAX_VALUE;
            arr[1] = Integer.MIN_VALUE;
            return 0;
        }
        int count = 1;
        int left = isBST(root.left, arr);
        int leftLow = arr[0];
        int leftHigh = arr[1];
        int right = isBST(root.right, arr);
        int rightLow = arr[0];
        int rightHigh = arr[1];
        if (left == -1 || right == -1 || left != 0 && root.val <= leftHigh || right != 0 && root.val >= rightLow) {
            return -1;
        }
        arr[1] = Math.max(rightHigh, root.val);
        arr[0] = Math.min(leftLow, root.val);
        count += left + right;
        res = Math.max(res, count);
        return count;
    }
}