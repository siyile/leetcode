package UpTo100;

import utils.BinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (node != null || !s.empty()) {
            while (node != null) {
                s.add(node);
                node = node.left;
            }
            node = s.pop();
            ans.add(node.val);
            node = node.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem94 p = new Problem94();
        int[] a = {1,3,4,1,7,4};
        BinaryTree tree = new BinaryTree(a);
        BinaryTree.printNode(tree.root);
        System.out.println(p.inorderTraversal(tree.root));
    }
}
