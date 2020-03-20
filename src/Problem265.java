import java.util.Arrays;

public class Problem265 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        int min1 = 0, min2 = 0, minIndex = -1;
        for (int[] ints : costs) {
            int curMin1 = Integer.MAX_VALUE, curMin2 = Integer.MAX_VALUE, curMinIndex = 0;
            for (int j = 0; j < k; j++) {
                int cost = ints[j] + (j == minIndex ? min2 : min1);
                if (cost < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = cost;
                    curMinIndex = j;
                } else if (cost < curMin2) {
                    curMin2 = cost;
                }
            }
            min1 = curMin1;
            min2 = curMin2;
            minIndex = curMinIndex;
        }
        return min1;
    }
}
