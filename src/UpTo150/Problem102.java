package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            ans.add(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem102 p = new Problem102();
        int[] a = {1,2,0,3,0,4,0,5};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.levelOrder(t.root));
    }
}
