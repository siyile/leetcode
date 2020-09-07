package UpTo950;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem907 {
    public static void main(String[] args) {
        Problem907 p = new Problem907();

        System.out.println(p.sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    public int sumSubarrayMins(int[] A) {
        int n = A.length, ans = 0, MODULE = 1_000_000_007;
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        int[] dp = new int[n];
        s1.push(-1);
        for (int i = 0; i < n; i++) {
            while (s1.size() > 1 && A[s1.peek()] >= A[i])
                s1.pop();
            dp[i] = s1.peek();
            s1.push(i);
        }
        s2.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (s2.size() > 1 && A[s2.peek()] > A[i])
                s2.pop();
            ans = (ans + ((s2.peek() - i) * A[i] % MODULE * (i - dp[i]))) % MODULE;
            s2.push(i);
        }

        return ans;
    }
}
