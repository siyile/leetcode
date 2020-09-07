package UpTo850;

import java.util.Arrays;

public class Problem828 {
    public int uniqueLetterString(String S) {
        int[][] index = new int[26][2];
        int ans = 0, MOD = 1_000_000_007;
        int N = S.length();
        Arrays.fill(index, new int[]{-1, -1});
        for (int i = 0; i < N; i++) {
            int j = S.charAt(i) - 'A';
            ans = (ans + (index[j][1] - index[j][0]) * (i - index[j][1]) % MOD) % MOD;
            index[j] = new int[]{index[j][1], i};
        }
        for (int i = 0; i < 26; i++) {
            ans = (ans + (N - index[i][1]) * (index[i][1] - index[i][0]) % MOD) % MOD;
        }
        return ans;
    }
}
