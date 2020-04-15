package UpTo450;

import java.util.ArrayList;
import java.util.List;

public class Problem411 {
    int candidate, minLen, abbr, bn, n;
    List<Integer> dict = new ArrayList<>();
    public String minAbbreviation(String target, String[] dictionary) {
        n = target.length();
        bn = 1 << n;
        minLen = n + 1;

        for (String str :
                dictionary) {
            if (str.length() != n) {
                continue;
            }
            int word = 0;
            for (int i = 0; i < n; i++) {

                if (target.charAt(i) != str.charAt(i)) {
                    word |= 1 << i;
                }
            }
            dict.add(word);
            candidate |= word;
        }

        dfs(1, 0);

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            if ((abbr & (1 << i)) != 0) {
                sb.append(target.charAt(i++));
            } else {
                int j = i;
                while (i <= n) {
                    if (i == n || (abbr & (1 << i)) > 0) {
                        sb.append(i - j);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        return sb.toString();
    }

    private void dfs(int bit, int mask) {
        int len = abbr(mask);
        if (len >= minLen) {
            return;
        }
        boolean match = true;
        for (Integer word :
                dict) {
            if ((mask & word) == 0) {
                match = false;
                break;
            }
        }

        if (match) {
            minLen = len;
            abbr = mask;
        } else {
            for (int b = bit; b < bn; b <<= 1) {
                if ((candidate & b) != 0) {
                    dfs(b << 1, mask + b);
                }
            }
        }
    }

    private int abbr(int mask) {
        int len = n;
        for (int b = 3; b < bn; b <<= 1) {
            if ((mask & b) == 0) {
                len--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Problem411 p = new Problem411();

        System.out.println(p.minAbbreviation("abcdef", new String[]{"ablade", "xxxxef", "abdefi"}));
    }
}
