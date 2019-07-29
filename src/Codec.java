import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append('x');
                } else {
                    sb.append(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
                sb.append(',');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] ser = data.split(",");
        int i = 0;
        int curLevel;
        int nextLevel = 1;
        TreeNode[] t = new TreeNode[ser.length];
        for (int j = 0; j < ser.length; j++) {
            if (ser[j].charAt(0) == 'x') {
                t[j] = null;
            } else {
                t[j] = new TreeNode(Integer.valueOf(ser[j]));
            }
        }
        while (i < ser.length) {
            curLevel = nextLevel;
            nextLevel = 0;
            int amount = i;
            for (int j = 0; j < curLevel; j++) {
                if (t[i] != null) {
                    t[i].left = t[amount + curLevel + nextLevel];
                    nextLevel++;
                    t[i].right = t[amount + curLevel + nextLevel];
                    nextLevel++;
                }
                i++;
            }
        }
        return t[0];
    }
}

