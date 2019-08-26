import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem662 {
    Map<Integer, Integer> map = new HashMap<>();
    int width = 0;
    public int widthOfBinaryTree(TreeNode root) {
        inorder(root, 0, 0);
        return width;
    }

    private void inorder(TreeNode node, int x, int y) {
        if (node == null) return;
        inorder(node, x * 2 - 1, y);
        map.putIfAbsent(y, x);
        width = Math.max(x - map.get(y) + 1, width);
        inorder(node, x * 2, y);
    }
}
