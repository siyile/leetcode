package UpTo850;

import java.util.ArrayList;
import java.util.List;

public class Problem838 {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        List<Integer> r = new ArrayList<>();


        int dis = 0;
        boolean left = true;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                dis = 0;
                left = false;
            } else if (dominoes.charAt(i) == 'L')
                left = true;
            if (left) {
                r.add(n);
            } else {
                r.add(dis++);
            }
        }

        dis = 0;
        boolean right = true;

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                dis = 0;
                right = false;
            } else if (dominoes.charAt(i) == 'R')
                right = true;

            int cur;
            if (right) {
                cur = n;
            } else {
                cur = dis++;
            }

            if (cur < r.get(i))
                sb.append('L');
            else if (cur > r.get(i))
                sb.append('R');
            else
                sb.append('.');
        }

        return sb.reverse().toString();
    }
}
