package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, Map<Integer, Integer> map, int pl, int pr, int il, int ir) {
        if (pl < pr) return null;
        if (pl == pr) return new TreeNode(pre[pl]);
        int mi = map.get(pre[pl]);
        TreeNode node = new TreeNode(pre[pl]);
        node.left = buildTree(pre, map, pl + 1, pl + mi - il, il, mi - 1);
        node.right = buildTree(pre, map, pl + mi - il + 1, pr, mi + 1, ir);
        return node;
    }

    public static void main(String[] args) {
        Problem105 p = new Problem105();
        int[] a = {3, 9, 2, 7, 20, 15, 11};
        int[] b = {2, 9, 7, 3, 15, 20, 11};
        BinaryTree.printNode(p.buildTree(a, b));
    }
}


