import utils.BinaryTree;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            level += 1;
            int levelNumber = q.size();
            for (int i = 0; i < levelNumber; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Problem111 p = new Problem111();
        int[] a = {3,9,20,0,0,15,7};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.minDepth(t.root));
    }
}
