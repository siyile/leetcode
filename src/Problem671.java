import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return visit(root, root.val);
    }

    public int visit(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return -1;
        int left = visit(root.left, min);
        int right = visit(root.right, min);
        return left == -1 || right == -1 ? Math.max(left, right) : Math.min(left, right);
    }
}
