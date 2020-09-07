package UpTo950;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem943 {
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                graph[i][j] = cal(A[i], A[j]);
//                System.out.println(i + "," + j + "," + graph[i][j]);
                graph[j][i] = cal(A[j], A[i]);
//                System.out.println(j + "," + i + "," + graph[j][i]);
            }
        }

        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        int min = Integer.MAX_VALUE, last = -1;
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    int prev = i - (1 << j);
                    if (prev == 0) {
                        dp[i][j] = A[j].length();
                    } else {
                        for (int k = 0; k < n; k++) {
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }

                if (i == (1 << n) - 1 && dp[i][j] < min) {
                    last = j;
                    min = dp[i][j];
                }
            }
        }

        // build path
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = (1 << n) - 1;
        while (cur > 0) {
            stack.push(last);
            int tmp = path[cur][last];
            cur -= (1 << last);
            last = tmp;
        }

        System.out.println(stack);

        // build results
        StringBuilder sb = new StringBuilder();
        last = stack.pop();
        sb.append(A[last]);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            sb.append(A[node].substring(A[node].length() - graph[last][node]));
            last = node;
        }

        return sb.toString();
    }

    // a is followed by b
    private int cal(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (b.startsWith(a.substring(i)))
                return b.length() - (a.length() - i);
        }
        return b.length();
    }

    public static void main(String[] args) {
        Problem943 p = new Problem943();

        System.out.println(p.shortestSuperstring(new String[]{"abcd", "cdfg", "bcdf"}));
    }
}
