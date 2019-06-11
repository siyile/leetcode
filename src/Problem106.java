import utils.BinaryTree;
import utils.TreeNode;

import java.util.*;

public class Problem106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeRecursive(postorder, inorder, 0, postorder.length, postorder.length - 1, inMap);
    }

    private TreeNode buildTreeRecursive(int[] postorder, int[] inorder, int start, int end, int postIndex, Map<Integer, Integer> inMap) {
        if (end - start == 0) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = inMap.get(root.val);
        root.right = buildTreeRecursive(postorder, inorder, index + 1, end, postIndex - 1, inMap);
        root.left = buildTreeRecursive(postorder, inorder, start, index, postIndex - (end - index), inMap);
        return root;
    }

    public static void main(String[] args) {
        Problem106 p = new Problem106();
        int[] a = {9,3,15,20,7, 5};
        int[] b = {9,15,7,5,20,3};
        BinaryTree.printNode(p.buildTree(a, b));
    }
}
