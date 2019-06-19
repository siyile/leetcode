public class Problem130 {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                check(board, i, 0, m, n);
            }
            if (board[i][n - 1] == 'O') {
                check(board, i, m - 1, m, n);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                check(board, 0, j, m, n);
            }
            if (board[m - 1][j] == 'O') {
                check(board, n - 1, j, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void check(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) return;
        if (board[i][j] == 'O') {
            board[i][j] = 'W';
            check(board, i + 1, j, m, n);
            check(board, i - 1, j, m, n);
            check(board, i, j + 1, m, n);
            check(board, i, j - 1, m, n);
        }
    }
}
