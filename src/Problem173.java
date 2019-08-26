import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem173 {
    class BSTIterator {

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node;

        public BSTIterator(TreeNode root) {
            node = root;
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode ans;
            node = deque.pop();
            ans = node;
            node = node.right;
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            return ans.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }

}
