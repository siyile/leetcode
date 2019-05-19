import utils.LinkedList;
import utils.ListNode;

public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        ListNode p = head;
        int count = 1;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        k %= count;
        if (k == 0) return head;
        p.next = head;
        for (int i = 0; i < count - k; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        p.next = null;
        return q;
    }

    public static void main(String[] args) {
        Problem61 p = new Problem61();
        int[] a = {1,2,3,4,5};
        LinkedList l = new LinkedList(a);
        System.out.println(p.rotateRight(l.head, 3));
    }
}
