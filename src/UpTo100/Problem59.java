package UpTo100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        boolean[][] seen = new boolean[n][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int row = 0, col = -1;
        int dir = 0;
        for (int i = 0; i < n * n; i++) {
            int tempRow = row + dr[dir];
            int tempCol = col + dc[dir];
            if (tempRow >= n || tempRow < 0 || tempCol >= n || tempCol <0 || seen[tempRow][tempCol]) {
                dir = (dir + 1) % 4;
            }
            row += dr[dir];
            col += dc[dir];
            seen[row][col] = true;
            ans[row][col] = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem59 p = new Problem59();
        for (int[] x : p.generateMatrix(9)) {
            String sb = Arrays.stream(x).mapToObj(y -> y + " ").collect(Collectors.joining());
            System.out.println(sb);
        }
    }
}
