import java.util.ArrayList;
import java.util.List;

public class Problem51 {
    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        set(board, 0, 0, ans);
        return ans;
    }

    private void set(boolean[][] board, int row, int column, List<List<String>> ans) {
        int n = board[0].length;
        if (row > 0) {
            for (int i = 0; i < n; i++) {
                if (row - 1 != i && board[i][column]) return;
                if (i > 0 && row - 1 - i >=0 && column + i < n && board[row - 1 - i][column + i]) return;
                if (i > 0 && row - 1 - i >=0 && column - i >=0 && board[row - 1 - i][column - i]) return;
            }
        }
        if (row == n) {
            ans.add(generateBoard(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            board[row][i] = true;
            row++;
            set(board, row, i, ans);
            row--;
            board[row][i] = false;
        }
    }

    private List<String> generateBoard(boolean[][] board) {
        List<String> solution = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean x : row) {
                if (x) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            solution.add(sb.toString());
        }
        return solution;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] flag = new boolean[5 * n - 2];
        boolean[][] board = new boolean[n][n];
        check(flag, n, 0, ans, board);
        return ans;
    }

    public void check(boolean[] flag, int n, int row, List<List<String>> ans, boolean[][] board) {
        if (row == n) {
            ans.add(generateBoard(board));
            return;
        }
        for (int column = 0; column < n; column++) {
            final int i = n - column + row + 2 * n - 2 + n;
            if (!flag[column] && !flag[column + row + n] && !flag[i]) {
                flag[column] = true;
                flag[column + row + n] = true;
                flag[i] = true;
                board[row][column] = true;
                check(flag, n, row + 1, ans, board);
                board[row][column] = false;
                flag[column] = false;
                flag[column + row + n] = false;
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Problem51 p = new Problem51();
        System.out.println(p.solveNQueens(5));
    }
}
