package UpTo200;

import java.util.Arrays;

public class Problem172 {
    public static void main(String[] args) {
        Problem172 p = new Problem172();

        System.out.println(p.calculateMinimumHP(new int[][]{{-1, 1}}));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE >> 1);
        memo[n - 1] = 1;
        int need;
        for (int i = m - 1; i >= 0; i--) {
            need = memo[n - 1] - dungeon[i][n - 1];
            memo[n - 1] = need <= 0 ? 1 : need;
            for (int j = n - 2; j >= 0; j--) {
                need = Math.min(memo[j], memo[j + 1]) - dungeon[i][j];
                memo[j] = need <= 0 ? 1 : need;
            }
        }
        return memo[0];
    }
}
