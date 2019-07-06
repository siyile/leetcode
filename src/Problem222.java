import utils.TreeNode;

public class Problem222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode node = root;
        int d = 1;
        while (node.left != null) {
            d++;
            node = node.left;
        }

        node = root;
        int left = 1, right = (int)Math.pow(2, d - 1);
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (exist(pivot, d, root)) {
                left = pivot;
            } else {
                right = pivot - 1;
            }
        }

        return (int) Math.pow(2, d - 1) - 1 + left;
    }

    private boolean exist(int idx, int d, TreeNode root) {
        int l = 1, r = (int) Math.pow(2, d - 1);
        TreeNode node = root;
        for (int i = 0; i < d; i++) {
            int pivot = l + (r - l) / 2;
            if (pivot > idx) {
                r = pivot - 1;
                node = node.right;
            } else {
                l = pivot;
                node = node.left;
            }
        }
        return node != null;
    }
}
