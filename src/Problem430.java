import java.util.Stack;

public class Problem430 {
    public Node flatten2(Node head) {
        flattenTail(head);
        return head;
    }

    public Node flattenTail(Node head) {
        if (head == null) return null;
        if (head.child == null) {
            // no next no child
            if (head.next == null) return head;
            // next no child
            return flattenTail(head.next);
        } else {
            Node tail = flattenTail(head.child);
            tail.next = head.next;
            if (head.next != null) head.next.prev = tail;
            head.next = head.child;
            head.child.prev = head;
            head.child = null;
            if (tail.next == null) return tail;
            return flattenTail(tail.next);
        }
    }

    public Node flatten3(Node head) {
        if (head == null) return null;
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }
            Node tmp = p.child;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = p.next;
            if (p.next != null)
                p.next.prev = tmp;
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        Node dummy = new Node(0, null, head, null);
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node prev = dummy;
        while (!stack.isEmpty()) {
            Node root = stack.pop();

            root.prev = prev;
            prev.next = root;

            if (root.next != null) {
                stack.push(root.next);
                root.next = null;
            }
            if (root.child != null) {
                stack.push(root.child);
                root.child = null;
            }
            prev = root;
        }

        dummy.next.prev = null;
        return dummy.next;
    }


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
