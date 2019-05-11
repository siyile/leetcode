import java.util.ArrayList;
import java.util.List;

public class Problem52 {
    public int totalNQueens(int n) {
        boolean[] flag = new boolean[5 * n - 2];
        return check(flag, n, 0, 0);
    }

    public int check(boolean[] flag, int n, int row, int ans) {
        if (row == n) {
            return ++ans;
        }
        for (int column = 0; column < n; column++) {
            final int i = n - column + row + 2 * n - 2 + n;
            if (!flag[column] && !flag[column + row + n] && !flag[i]) {
                flag[column] = true;
                flag[column + row + n] = true;
                flag[i] = true;
                ans = check(flag, n, row + 1, ans);
                flag[column] = false;
                flag[column + row + n] = false;
                flag[i] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem52 p = new Problem52();
        System.out.println(p.totalNQueens(4));
    }
}
