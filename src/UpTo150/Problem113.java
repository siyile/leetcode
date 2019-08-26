package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        sum(root, sum, new ArrayList<>());
        return ans;
    }

    private void sum(TreeNode node, int sum, List<Integer> tmp) {
        if (sum <= 0) return;
        if (node == null) return;
        sum -= node.val;
        tmp.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0) ans.add(new ArrayList<>(tmp));
        } else {
            sum(node.left, sum, tmp);
            sum(node.right, sum, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        Problem113 p = new Problem113();
        int[] a = {5,4,8,11,0,13,4,7,2,0,0,5,1};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.pathSum(t.root, 22));
    }
}
