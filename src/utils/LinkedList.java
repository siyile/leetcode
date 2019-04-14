package utils;

public class LinkedList {
    public LinkedList(int [] a){
        if (a.length == 0) return;
        head = new ListNode(a[0]);
        if (a.length == 1){
            return;
        }
        ListNode p = head;
        for (int i = 1; i < a.length - 1; i++){
            p.next = new ListNode(a[i]);
            p = p.next;
        }
        p.next = new ListNode(a[a.length - 1]);
    }
    public ListNode head;

    @Override
    public String toString(){
        ListNode p = head;
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
