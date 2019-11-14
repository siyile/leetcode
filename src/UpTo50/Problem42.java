package UpTo50;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(height[i - 1], dp[i - 1]);
        }

        int cur = 0, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += Math.max(Math.min(cur, dp[i]) - height[i], 0);
            cur = Math.max(cur, height[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem42 p = new Problem42();
        int[] a = {4,2,3};
        System.out.println(p.trap(a));
    }
}
