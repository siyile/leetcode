package UpTo900;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Problem854 {
    public int kSimilarity(String A, String B) {
        Queue<String> q = new ArrayDeque<>();
        q.add(A);
        int cnt = 0;
        Set<String> seen = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                A = q.poll();
                if (A.equals(B)) return cnt;
                int i = 0;
                while (A.charAt(i) == B.charAt(i)) i++;
                for (int j = i + 1; j < B.length(); j++) {
                    if (A.charAt(i) != B.charAt(j)) continue;
                    String tmp = swap(i, j, B);
                    if (seen.add(tmp)) q.add(tmp);
                }
            }
            cnt++;
        }
        return -1;
    }

    private String swap(int i, int j, String s) {
        char[] chs = s.toCharArray();
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
        return new String(chs);
    }
}
