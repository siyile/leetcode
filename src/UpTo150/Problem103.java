package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        q.add(root);
        boolean reverse = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (reverse) tmp.add(0, node.val);
                else tmp.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(tmp);
            reverse = !reverse;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem103 p = new Problem103();
        int[] a = {3,9,20,4,5,15,7};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.zigzagLevelOrder(t.root));
    }
}
