package UpTo100;

public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int start = 0;
        int end = m - 1;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            int value = matrix[mid][0];
            if (value == target) return true;
            if (value > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        int row = start;
        if (matrix[row][0] > target && row > 0) row--;
        start = 0;
        end = n - 1;
        while (start < end) {
            mid = (start + end) / 2;
            int value = matrix[row][mid];
            if (value == target) return true;
            if (value < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return matrix[row][start] == target;
    }



    public static void main(String[] args) {
        Problem74 p = new Problem74();
        int[][] a = {{1}};
        System.out.println(p.searchMatrix(a, 0));
    }
}
