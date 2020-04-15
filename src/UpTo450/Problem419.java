package UpTo450;

public class Problem419 {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    continue;
                if (i > 0 && board[i - 1][j] == 'X')
                    continue;
                if (j > 0 && board[j - 1][i] == 'X')
                    continue;
                cnt++;
            }
        }
        return cnt;
    }
}
