package UpTo400;

import utils.TreeNode;

import java.util.*;

public class Problem366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        height(root, ans);
        return ans;
    }

    private int height(TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return -1;
        }

        int level = 1 + Math.max(height(root.left, ans), height(root.right, ans));
        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        return level;
    }
}
