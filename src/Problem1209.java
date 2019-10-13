import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1209 {
    public String removeDuplicates(String s, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // stack is empty, just push
            if (stack.isEmpty()) {
                stack.push(new Node(ch, 1));
            } else {
                // when stack top is ch
                if (stack.peek().v == ch) {
                    int cnt = stack.peek().cnt;
                    // if ch appear k - 1 times, remove them all
                    if (cnt == k - 1) for (int j = 0; j < k - 1; j++) stack.pop();
                        // put ch with count 1
                    else stack.push(new Node(ch, cnt + 1));
                    // not stack top is not ch, push it with count 1
                } else {
                    stack.push(new Node(ch, 1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.poll().v);
        }
        return sb.reverse().toString();
    }

    class Node {
        char v;
        int cnt;

        Node(char v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }
}
