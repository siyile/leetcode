import utils.BinaryTree;
import utils.LinkedList;
import utils.ListNode;
import utils.TreeNode;

public class Problem109 {
    private ListNode head;

    private int findSize(ListNode node) {
        int s = 0;
        while (node != null) {
            node = node.next;
            s++;
        }
        return s;
    }

    private TreeNode create(int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        TreeNode left = create(start, mid - 1);
        TreeNode node = new TreeNode(head.val);
        head = head.next;
        node.left = left;
        node.right = create(mid + 1, end);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = findSize(head);
        this.head = head;
        return create(0, size - 1);
    }

    public static void main(String[] args) {
        Problem109 p = new Problem109();
        int[] a = {1,2,3,5,9};
        LinkedList l = new LinkedList(a);
        BinaryTree.printNode(p.sortedListToBST(l.head));
    }
}
