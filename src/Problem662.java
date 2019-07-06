import utils.TreeNode;

import java.util.*;

public class Problem662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Deque<Integer> store = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        store.add(-1);
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Integer start = store.peekFirst();
            Integer last = store.peekLast();
            ans = Math.max(ans, last - start + 1);
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                int x = store.pollFirst();
                if (tmp.left != null) {
                    q.add(tmp.left);
                    store.add(2 * x);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                    store.add(2 * x + 1);
                }
            }
        }
        return ans;
    }

}
