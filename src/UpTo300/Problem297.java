package UpTo300;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem297 {
    private class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("None,");
                return;
            }
            sb.append(root.val);
            sb.append(',');
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strings = data.split(",");
            List<String> l = new ArrayList<>(Arrays.asList(strings));
            return deserialize(l);
        }

        private TreeNode deserialize(List<String> l) {
            if (l.size() == 0) return null;
            String str = l.get(0);
            l.remove(0);
            if (str.equals("None"))
                return null;
            else {
                TreeNode node = new TreeNode(Integer.parseInt(str));
                node.left = deserialize(l);
                node.right = deserialize(l);
                return node;
            }
        }
    }
}

