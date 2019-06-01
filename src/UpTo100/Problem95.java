package UpTo100;

import utils.BinaryTree;
import utils.TreeNode;

import java.util.*;

public class Problem95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] results = new List[n + 1];
        results[0] = new ArrayList<>();
        if (n == 0)
            return results[0];
        results[0].add(null);

        for (int len = 1; len < n + 1; len++) {
            results[len] = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                for (TreeNode lnode :
                        results[i]) {
                    for (TreeNode rnode :
                            results[len - i - 1]) {
                        TreeNode root = new TreeNode(i + 1);
                        root.left = lnode;
                        root.right = clone(rnode, i + 1);
                        results[len].add(root);
                    }
                }
            }
        }
        return results[n];
    }

    private TreeNode clone(TreeNode node, int offset) {
        if (node == null)
            return null;
        TreeNode root = new TreeNode(node.val + offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }

    public static void main(String[] args) {
        Problem95 p = new Problem95();
        List<TreeNode> l = p.generateTrees(3);
        System.out.println(l.size());
        for (TreeNode x :
                l) {
            BinaryTree.printNode(x);
        }
    }
}
