import utils.TreeNode;

public class Problem450 {
    public int successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {
            if (root.right == null && root.left == null) return null;
            else if (root.right == null) {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            } else {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
}
