package UpTo950;

import java.util.ArrayList;
import java.util.List;

public class Problem936 {
    public int[] movesToStamp(String stamp, String target) {
        char[] T = target.toCharArray();
        char[] S = stamp.toCharArray();
        boolean[] v = new boolean[target.length()];
        int stars = 0;
        List<Integer> res = new ArrayList<>();
        while (stars < target.length()) {
            boolean doneReplace = false;
            for (int i = 0; i <= T.length - S.length; i++) {
                if (!v[i] && canReplace(T, i, S)) {
                    stars = doReplace(T, i, S, stars);
                    doneReplace = true;
                    res.add(i);
                    v[i] = true;
                    if (stars == target.length()) {
                        break;
                    }
                }
            }
            if (!doneReplace) {
                return new int[]{};
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0, j = res.size() - 1; j >= 0; i++, j--) {
            ans[i] = res.get(j);
        }
        return ans;
    }

    private boolean canReplace(char[] T, int s, char[] S) {
        for (int i = 0; i < S.length; i++) {
            if (T[i+s] != '*' && T[i+s] != S[i]) {
                return false;
            }
        }
        return true;
    }

    private int doReplace(char[] T, int s, char[] S, int count) {
        for (int i = 0; i < S.length; i++) {
            if (T[i+s] != '*') {
                count += 1;
                T[i+s] = '*';
            }
        }
        return count;
    }
}
