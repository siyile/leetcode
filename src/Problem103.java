import utils.BinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        visit(ans, root, 0);
        for (int i = 1; i < ans.size(); i += 2) {
            Collections.reverse(ans.get(i));
        }
        return ans;
    }

    public void visit(List<List<Integer>> ans, TreeNode node, int height) {
        if (node == null) return;
        if (height == ans.size()) ans.add(new ArrayList<>());
        ans.get(height).add(node.val);
        visit(ans, node.left, height + 1);
        visit(ans, node.right, height + 1);
    }

    public static void main(String[] args) {
        Problem103 p = new Problem103();
        int[] a = {3,9,20,4,5,15,7};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.zigzagLevelOrder(t.root));
    }
}
