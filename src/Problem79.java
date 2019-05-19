import java.util.Deque;
import java.util.Stack;

public class Problem79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        if (m * n < word.length()) return false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int count) {
        if (count == word.length()) return true;
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
            return false;
        }
        if (board[i][j] != word.charAt(count)) {
            return false;
        }
        board[i][j] ^= 256;
        boolean exist = dfs(board, word, i - 1, j, count + 1) ||
                        dfs(board, word, i + 1, j, count + 1) ||
                        dfs(board, word, i, j + 1, count + 1) ||
                        dfs(board, word, i, j - 1, count + 1);
        board[i][j] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        Problem79 p = new Problem79();
        char[][] a = {{'A','B'}, {'C','E'}};
        System.out.println(p.exist(a, "ACEB"));
        System.out.println(p.exist(a, "SEE"));
        System.out.println(p.exist(a, "ABCB"));
    }
}
