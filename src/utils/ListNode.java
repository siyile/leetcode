package utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        ListNode p = this;
        StringBuilder s = new StringBuilder();
        while (p.next != null){
            s.append(p.val);
            s.append("->");
            p = p.next;
        }
        s.append(p.val);
        return s.toString();
    }
}
