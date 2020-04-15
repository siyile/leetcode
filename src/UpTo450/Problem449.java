package UpTo450;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem449 {
    private class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorder(root, sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0) return null;
            String[] strings = data.split("#");
            Deque<Integer> q = new ArrayDeque<>();
            for (String s :
                    strings) {
                q.add(Integer.parseInt(s));
            }
            return construct(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode construct(Deque<Integer> q, int low, int high) {
            if (q.isEmpty()) return null;
            int val = q.peek();
            if (val < low || val > high) return null;
            q.poll();
            TreeNode node = new TreeNode(val);
            node.left = construct(q, low, val);
            node.right = construct(q, val, high);
            return node;
        }

        private void preorder(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val);
            sb.append("#");
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
    }

}
