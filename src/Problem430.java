public class Problem430 {
    public Node flatten(Node head) {
        if (head.next == null) return head;
        if (head.child == null) {
            return flatten(head.next);
        } else {
            Node node;
            node = flatten(head.child);
            head.next.prev = node;
            head.next = head.child;
            head.child = null;
            return node;
        }
    }



    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
