package Google;

import utils.BinaryTree;
import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class btSum {
    Map<TreeNode, Integer> taken = new HashMap<>();
    Map<TreeNode, Integer> noTaken = new HashMap<>();

    public static void main(String[] args) {
        btSum p = new btSum();
        int[] a = {1, -1, -2, -3, -4, -5, 6, 2, 3, 0, 0, 0, 0, 3, 4};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.sum(t.root));
    }

    public int sum(TreeNode root) {
        return Math.max(dfs(root, true), dfs(root, false));
    }

    private int dfs(TreeNode node, boolean take) {
        if (node == null) return 0;
        Map<TreeNode, Integer> map;
        if (take) map = taken;
        else map = noTaken;
        if (map.containsKey(node))
            return map.get(node);
        int sum = take ? node.val : 0;
        int max = 0;

        if (!take) {
            max = Math.max(dfs(node.left, true) + dfs(node.right, true), max);
            max = Math.max(dfs(node.left, false) + dfs(node.right, true), max);
            max = Math.max(dfs(node.left, true) + dfs(node.right, false), max);
        }
        max = Math.max(dfs(node.left, false) + dfs(node.right, false), max);
        sum += max;
        map.put(node, sum);
        return sum;
    }
}
