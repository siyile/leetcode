package UpTo100;

public class Problem96 {
    public static void main(String[] args) {
        Problem96 p = new Problem96();

        System.out.println(p.numTrees(4));
    }

    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                memo[i] += memo[j] * memo[i - j - 1];
            }
        }
        return memo[n];
    }
}
