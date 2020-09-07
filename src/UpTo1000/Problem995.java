package UpTo1000;

import java.util.Arrays;

public class Problem995 {
    public static void main(String[] args) {
        Problem995 p = new Problem995();

        System.out.println(p.minKBitFlips(new int[]{0, 1, 1}, 2));
    }

    public int minKBitFlips(int[] A, int K) {
        A = Arrays.stream(A).map(operand -> operand ^ 1).toArray();
        int n = A.length;
        boolean[] flip = new boolean[n];
        int count = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((A[i] ^ (count % 2)) == 1) {
                if (i + K > n) {
                    return -1;
                }
                count++;
                ans++;
                flip[i] = true;
            }
            if (i >= K - 1 && flip[i - K + 1]) {
                count--;
            }
        }
        return ans;
    }
}
