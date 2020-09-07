package UpTo900;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem871 {
    public static void main(String[] args) {
        Problem871 p = new Problem871();
        System.out.println(p.minRefuelStops(1000, 299, new int[][]{{13, 21}, {26, 115}, {100, 47}, {225, 99}, {299, 141}, {444, 198}, {608, 190}, {636, 157}, {647, 255}, {841, 123}}));
    }

    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[] dp = new int[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int t = i; t >= 0; t--) {
                if (dp[t] >= stations[i][0]) {
                    dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            if (dp[i] >= target)
                return i;
        }
        return -1;
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int prev = 0, tank = startFuel;
        int stop = 0;
        for (int i = 0; i < stations.length; i++) {
            int location = stations[i][0];
            int capacity = stations[i][1];
            tank -= (location - prev);
            prev = location;
            if (tank < 0 && !q.isEmpty()) {
                tank += q.poll();
                stop += 1;
            }
            if (tank < 0) return -1;
            q.add(capacity);
        }

        tank -= target - prev;
        if (tank < 0 && !q.isEmpty()) {
            tank += q.poll();
            stop += 1;
        }
        if (tank < 0) return -1;
        return stop;
    }
}
