package utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        ListNode p = this;
        StringBuilder s = new StringBuilder();
        int count = 0;
        while (p.next != null && count++ < 10){
            s.append(p.val);
            s.append("->");
            p = p.next;
        }
        s.append(p.val);
        return s.toString();
    }
}
