package UpTo450;

public class Problem427 {
    int[][] grid;

    public Node construct(int[][] grid) {
        this.grid = grid;
        return construct(0, 0, grid.length);
    }

    private Node construct(int x, int y, int n) {
        if (n == 0) return null;
        int color = scan(x, y, n);
        Node node = new Node();
        if (color != -1) {
            node.val = 1 == color;
            node.isLeaf = true;
            return node;
        } else {
            node.isLeaf = false;
            node.topLeft = construct(x, y, n / 2);
            node.topRight = construct(x, y + n / 2, n / 2);
            node.bottomLeft = construct(x + n / 2, y, n / 2);
            node.bottomRight = construct(x + n / 2, y + n / 2, n / 2);
        }
        return node;
    }

    private int scan(int x, int y, int n) {
        int color = grid[x][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[x + i][y + j] != color) return -1;
            }
        }
        return color;
    }

    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

}
