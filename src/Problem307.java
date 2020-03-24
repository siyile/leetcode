public class Problem307 {
    private class NumArray {
        Node root;

        class Node {
            int start;
            int end;
            int sum;

            Node left;
            Node right;

            Node(int start, int end) {
                this.start = start;
                this.end = end;
                sum = 0;
            }
        }

        private Node build(int start, int end, int[] arr) {
            if (end < start) return null;
            Node node = new Node(start, end);
            if (start == end) {
                node.sum = arr[start];
            } else {
                int mid = (end + start) / 2;
                node.left = build(start, mid, arr);
                node.right = build(mid + 1, end, arr);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }

        private int rangeSum(Node node, int start, int end) {
            if (node.start == start && node.end == end) {
                return node.sum;
            }
            int mid = (node.end + node.start) / 2;
            if (start > mid) {
                return rangeSum(node.right, start, end);
            } else if (end <= mid) {
                return rangeSum(node.left, start, end);
            } else {
                return rangeSum(node.left, start, mid) + rangeSum(node.right, mid + 1, end);
            }
        }

        private void update(Node node, int pos, int val) {
            if (node.start == node.end) {
                node.sum = val;
            } else {
                int mid = (node.start + node.end) / 2;
                if (pos <= mid) {
                    update(node.left, pos, val);
                } else {
                    update(node.right, pos, val);
                }
                node.sum = node.left.sum + node.right.sum;
            }
        }

        public NumArray(int[] nums) {
            root = build(0, nums.length - 1, nums);
        }

        public void update(int i, int val) {
            update(root, i, val);
        }

        public int sumRange(int i, int j) {
            return rangeSum(root, i, j);
        }
    }
}
