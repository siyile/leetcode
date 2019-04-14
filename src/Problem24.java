import utils.LinkedList;
import utils.ListNode;

public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q, r, s;
        head = head.next;
        q = head;
        while (true){
            if (q.next != null) r = q.next;
            else {
                p.next = null;
                q.next = p;
                return head;
            }
            if (r.next != null) s = r.next;
            else {
                p.next = r;
                q.next = p;
                return head;
            }
            p.next = s;
            q.next = p;

            p = r;
            q = s;
        }
    }

    public static void main(String[] args) {
        Problem24 p = new Problem24();
        int [] a = {1, 2, 3};
        LinkedList l1 = new LinkedList(a);
        System.out.println(p.swapPairs(l1.head));
    }
}
