import java.util.ArrayList;
import java.util.List;

public class Problem296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);

        return minDis(rows) + minDis(cols);
    }

    private List<Integer> collectRows(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) ans.add(i);
            }
        }
        return ans;
    }

    private List<Integer> collectCols(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) ans.add(i);
            }
        }
        return ans;
    }

    private int minDis(List<Integer> points) {
        int i = 0, j = points.size() - 1, ans = 0;
        while (i < j) ans += points.get(j--) - points.get(i++);
        return ans;
    }
}
