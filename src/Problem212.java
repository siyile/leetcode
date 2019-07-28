import java.util.*;

public class Problem212 {
    Node root;
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        Node node;
        int m = board.length, n = board[0].length;
        for (String word :
                words) {
            node = root;
            for (int i = 0; i < word.length(); i++) {
                int currentChar = word.charAt(i) - 'a';
                if (node.children[currentChar] == null) {
                    node.children[currentChar] = new Node();
                }
                node = node.children[currentChar];
            }
            node.end = true;
        }
        visited = new boolean[m][n];
        Set<String> set = new HashSet<>();
        Stack<Node> s = new Stack<>();
        s.push(root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = board[i][j] - 'a';
                if (root.children[idx] != null) {
                    s.push(root.children[idx]);
                    sb.append(board[i][j]);
                    visited[i][j] = true;
                    dfs(i, j, set, s, board, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    s.pop();
                    visited[i][j] = false;
                }

            }
        }
        List<String> ans = new ArrayList<>(set);
        return ans;
    }

    public void dfs(int p, int q, Set<String> set, Stack<Node> s, char[][] board, StringBuilder sb) {
        if (s.peek().end)
            set.add(sb.toString());
        int m = board.length, n = board[0].length;
        Node node = s.peek();
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int[] dir :
                dirs) {
            int x = p + dir[0];
            int y = q + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y])
                continue;
            int idx = board[x][y] - 'a';
            if (node.children[idx] != null) {
                s.push(node.children[idx]);
                sb.append(board[x][y]);
                visited[x][y] = true;
                dfs(x, y, set, s, board, sb);
                visited[x][y] = false;
                sb.deleteCharAt(sb.length() - 1);
                s.pop();
            }
        }
    }


    class Node {
        Node[] children;
        boolean end;

        public Node() {
            children = new Node[26];
            end = false;
        }
    }
}
