import java.util.HashSet;
import java.util.Set;

public class Problem348 {
    private class TicTacToe {

        int n, d1 = 0, d2 = 0;
        int[] rows, cols;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int adds = player == 0 ? 1 : -1;

            rows[row] += adds;
            cols[col] += adds;
            if (row == col) d1 += adds;
            if (row + col == n - 1) d2 += adds;

            if (Math.abs(d1) == n || Math.abs(d2) == n || Math.abs(rows[row]) == n ||  Math.abs(cols[col]) == n) return player;
            return 0;
        }
    }
}
