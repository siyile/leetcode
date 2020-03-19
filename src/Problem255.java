import java.util.ArrayDeque;
import java.util.Deque;

public class Problem255 {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int lo = Integer.MIN_VALUE;
        for (int val :
                preorder) {
            if (lo > val) return false;
            while (!stack.isEmpty() && stack.peek() < val) {
                lo = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }
}
