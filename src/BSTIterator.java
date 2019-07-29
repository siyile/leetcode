import utils.TreeNode;

import java.util.Stack;

public class BSTIterator {

    TreeNode root;
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        this.root = root;
        s = new Stack<>();
        while (root != null) {
            s.add(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!s.isEmpty()) {
            TreeNode node = s.peek();
            TreeNode temp = node;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    s.add(node);
                    node = node.left;
                }
            }
            return temp.val;
        } else {
            return -1;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return s.isEmpty();
    }
    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}
