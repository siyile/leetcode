import utils.TreeNode;

import java.util.*;

public class Problem863 {
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        preOrder(root, null);

        Deque<TreeNode> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.add(target);
        visited.add(target.val);
        while (K-- > 0) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.right != null && !visited.contains(node.right.val)) {
                    q.add(node.right);
                    visited.add(node.right.val);
                }
                if (node.left != null && !visited.contains(node.left.val)) {
                    q.add(node.left);
                    visited.add(node.left.val);
                }

                TreeNode prev = map.get(node);
                if (prev != null && !visited.contains(prev.val)) {
                    q.add(prev);
                    visited.add(prev.val);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) ans.add(q.poll().val);

        return ans;
    }


    public void preOrder(TreeNode node, TreeNode prev) {
        if (node == null) return;
        map.put(node, prev);
        preOrder(node.left, node);
        preOrder(node.right, node);
    }
}