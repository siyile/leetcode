package UpTo100;

public class Problem70 {
    public static void main(String[] args) {
        Problem70 p = new Problem70();
        System.out.println(p.climbStairs(22));
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }
        return memo[n - 1];
    }
}
