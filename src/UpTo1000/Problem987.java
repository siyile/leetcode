package UpTo1000;

import utils.TreeNode;

import java.util.*;

public class Problem987 {
    Queue<Integer> q = new PriorityQueue<>();
    Map<Integer, Queue<Point>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        preorder(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int x = q.poll();
            List<Integer> tmp = new ArrayList<>();
            Queue<Point> tmpQueue = map.get(x);
            while (!tmpQueue.isEmpty()) {
                tmp.add(tmpQueue.poll().val);
            }
            ans.add(tmp);
        }
        return ans;
    }

    private void preorder(TreeNode node, int x, int y) {
        if (node == null) return;
        Point point = new Point(x, y, node.val);
        Queue<Point> q;
        if (map.containsKey(x)) {
            q = map.get(x);
        } else {
            q = new PriorityQueue<>(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.y != o2.y) {
                        return o2.y - o1.y;
                    } else {
                        return o1.val - o2.val;
                    }
                }
            });
            map.put(x, q);
            this.q.add(x);
        }
        q.add(point);
        preorder(node.left, x - 1, y - 1);
        preorder(node.right, x + 1, y - 1);
    }

    private class Point {
        int x;
        int y;
        int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
