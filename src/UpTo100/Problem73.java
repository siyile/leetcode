package UpTo100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;
        int memoRow = -1;
        int memoCol = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (!flag) {
                        flag = true;
                        memoRow = i;
                        memoCol = j;
                    } else {
                        matrix[memoRow][j] = 0;
                        matrix[i][memoCol] = 0;
                    }
                }
            }
        }
        if (!flag) return;
        for (int i = 0; i < m; i++) {
            if (matrix[i][memoCol] == 0  && memoRow != i) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[memoRow][i] == 0 && memoCol != i) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            matrix[i][memoCol] = 0;
        }
        for (int i = 0; i < n; i++) {
            matrix[memoRow][i] = 0;
        }
    }

    public static void main(String[] args) {
        Problem73 p = new Problem73();
        int[][] a = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        p.setZeroes(a);
        for (int[] x :
                a) {
            String sb = Arrays.stream(x).mapToObj(y -> y + " ").collect(Collectors.joining());
            System.out.println(sb);
        }
    }
}
