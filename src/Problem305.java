import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem305 {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] root = new int[m * n];
        Arrays.fill(root, -1);
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for (int[] pos : positions) {
            int hash = pos[0] * n + pos[1];
            if (root[hash] != -1) {
                ans.add(count);
                continue;
            }
            count += 1;
            root[hash] = hash;
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0], y = pos[1] + dir[1];
                if (x >= m || x < 0 || y >= n || y < 0 || root[x * n + y] == -1) {
                    continue;
                }
                int rootNei = find(x * n + y, root);
                int rootSelf = find(hash, root);
                if (rootNei != rootSelf) {
                    root[rootSelf] = rootNei;
                    count--;
                }
            }
            ans.add(count);
        }

        return ans;
    }

    private int find(int x, int[] root) {
        if (x != root[x]) {
            root[x] = find(root[x], root);
        }
        return root[x];
    }
}
