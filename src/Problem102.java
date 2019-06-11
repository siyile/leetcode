import utils.BinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node;
        int start = 0, end = 1;
        int cur = 0;
        while (!q.isEmpty()) {
            if (cur == start) {
                ans.add(new ArrayList<>());
                start = end;
            }
            node = q.poll();
            cur++;
            ans.get(ans.size() - 1).add(node.val);
            if (node.left != null) {
                q.add(node.left);
                end += 1;
            }
            if (node.right != null) {
                q.add(node.right);
                end += 1;
            }
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
