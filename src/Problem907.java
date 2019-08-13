import javafx.util.Pair;

import java.util.Stack;

public class Problem907 {
    public static void main(String[] args) {
        Problem907 p = new Problem907();

        System.out.println(p.sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    public int sumSubarrayMins(int[] A) {
        Stack<Pair<Integer, Integer>> s1 = new Stack<>(), s2 = new Stack<>();
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int MOD = 1_000_000_007;
        long ans = 0;

        for (int i = 0; i < A.length; i++) {
            // left
            while (!s1.isEmpty() && A[i] < s1.peek().getKey()) {
                s1.pop();
            }
            left[i] = s1.isEmpty() ? i + 1 : i - s1.peek().getValue();
            s1.push(new Pair<>(A[i], i));

            // right
            while (!s2.isEmpty() && A[i] < s2.peek().getKey()) {
                Integer value = s2.pop().getValue();
                right[value] = i - value;
            }
            s2.push(new Pair<>(A[i], i));
        }

        while (!s2.isEmpty()) {
            Integer value = s2.pop().getValue();
            right[value] = A.length - value;
        }

        for (int i = 0; i < A.length; i++) {
            ans += left[i] * right[i] * A[i];
            ans %= MOD;
        }

        return (int) ans;
    }
}
