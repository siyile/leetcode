package UpTo550;

public class Problem529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        return updateBoard(board, click, visited);
    }

    public char[][] updateBoard(char[][] board, int[] click, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        int x = click[0];
        int y = click[1];

        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || (board[x][y] != 'E' && board[x][y] != 'M'))
            return board;

        visited[x][y] = true;

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        } else {
            int cnt = check(board, x, y);
            if (cnt == 0) {
                board[x][y] = 'B';
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        updateBoard(board, new int[]{x + i, y + j}, visited);
                    }
                }
            } else {
                board[x][y] = (char) (cnt + '0');
            }
        }
        return board;
    }

    private int check(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        int cnt = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i < 0 || x + i >= m || y + j < 0 || y + j >= n) {
                    continue;
                }
                if (board[x + i][y + j] == 'M')
                    cnt++;
            }
        }
        return cnt;
    }

}
