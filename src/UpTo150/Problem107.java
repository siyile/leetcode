package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        visit(ans, root, 0);
        return ans;
    }

    public void visit(List<List<Integer>> ans, TreeNode node, int height) {
        if (node == null) return;
        if (height == ans.size()) ans.add(0, new ArrayList<>());
        ans.get(ans.size() - height - 1).add(node.val);
        visit(ans, node.left, height + 1);
        visit(ans, node.right, height + 1);
    }

    public static void main(String[] args) {
        Problem107 p = new Problem107();
        int[] a = {3,9,20,0,0,15,7};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.levelOrderBottom(t.root));
    }
}
