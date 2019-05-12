package UpTo50;

public class Problem48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j ++) {
                temp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[-j + n][i] = temp[i][j];
            }
        }
    }

    public static void main(String[] args) {

    }
}
