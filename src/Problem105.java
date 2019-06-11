import utils.BinaryTree;
import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeRecursive(preorder, inorder, 0, preorder.length, 0, inMap);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int[] inorder, int start, int end, int preIndex, Map<Integer, Integer> inMap) {
        if (end - start == 0) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index = inMap.get(root.val);
        root.left = buildTreeRecursive(preorder, inorder, start, index, preIndex + 1, inMap);
        root.right = buildTreeRecursive(preorder, inorder, index + 1, end, preIndex + index - start + 1, inMap);
        return root;
    }

    public static void main(String[] args) {
        Problem105 p = new Problem105();
        int[] a = {3, 9, 2, 7, 20, 15, 11};
        int[] b = {2, 9, 7, 3, 15, 20, 11};
        BinaryTree.printNode(p.buildTree(a, b));
    }
}


