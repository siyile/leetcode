package UpTo900;

import java.util.Arrays;

public class Problem893 {
    public int mincostTickets(int[] days, int[] costs) {
        int amount = days.length * costs[0] + 1;
        int[] period = new int[]{1, 7, 30};
        int[] dp = new int[days.length + 1];
        Arrays.fill(dp, amount);
        dp[0] = 0;
        for (int j = 0; j < days.length; j++) {
            for (int i = 0; i < 3; i++) {
                int idx = Arrays.binarySearch(days, days[j] - period[i]);
                if (idx < 0) idx = ~idx;
                dp[j + 1] = Math.min(dp[j + 1], dp[idx + 1] + costs[i]);
            }
        }
        return days[days.length - 1];
    }
}
