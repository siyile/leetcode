import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Problem764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Pair<Integer, Integer>> banned = new HashSet<>();
        for (int[] mine :
                mines)
            banned.add(new Pair<>(mine[0], mine[1]));

        int max = 0;
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                cnt = banned.contains(new Pair<>(i, j)) ? 0 : cnt + 1;
                dp[i][j] = cnt;
            }

            cnt = 0;
            for (int j = N - 1; j >= 0; j--) {
                cnt = banned.contains(new Pair<>(i, j)) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
        }

        for (int j = 0; j < N; j++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt = banned.contains(new Pair<>(i, j)) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }

            cnt = 0;
            for (int i = N - 1; i >= 0; i--) {
                cnt = banned.contains(new Pair<>(i, j)) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
