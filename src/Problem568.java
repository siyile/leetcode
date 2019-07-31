import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int k = days[0].length;
        int n = flights.length;

        // init graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            graph.get(i).add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flights[i][j] == 1)
                    graph.get(i).add(j);
            }
        }

        int[][] dp = new int[k][n];

        for (int[] a :
                dp) {
            Arrays.fill(a, Integer.MIN_VALUE);
        }

        for (int i = 0; i < n; i++) {
            if (flights[0][i] == 1)
                dp[0][i] = days[i][0];
        }
        dp[0][0] = days[0][0];

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] == Integer.MIN_VALUE) continue;
                for (int m :
                        graph.get(j)) {
                    dp[i][m] = Math.max(dp[i - 1][j] + days[m][i], dp[i][m]);
                }
            }
        }

        int ans = 0;
        for (int x :
                dp[k - 1]) {
            if (x > ans)
                ans = x;
        }
        return ans;
    }
}
