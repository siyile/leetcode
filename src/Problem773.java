import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Problem773 {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start += board[i][j];
            }
        }

        Deque<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        q.add(start);
        seen.add(start);
        int move = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                start = q.poll();
                if (start.equals(target))
                    return move;
                int zero = start.indexOf('0');
                for (int j :
                        dirs[zero]) {
                    String tmp = swap(start, zero, j);
                    if (seen.add(tmp))
                        q.add(tmp);
                }
            }
            move++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, '0');
        return sb.toString();
    }
}
