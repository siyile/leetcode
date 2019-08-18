package UpTo100;

import java.util.ArrayList;
import java.util.List;

public class Problem93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restore(new StringBuilder(), s, 0, res, 0);
        return res;
    }

    private void restore(StringBuilder sb, String s, int level, List<String> res, int l) {
        if (l == s.length() || level == 4) {
            if (l == s.length() && level == 4)
                res.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (l + i > s.length()) break;
            int v = Integer.parseInt(s.substring(l, l + i));
            if (i == 1 || i == 2 && v >= 10 && v <= 99 || i == 3 && v >= 100 && v <= 255) {
                sb.append(v);
                if (level < 3) sb.append('.');
                restore(sb, s, level + 1, res, l + i);
                if (level < 3) sb.deleteCharAt(sb.length() - 1);
                sb.delete(sb.length() - i, sb.length());
            }
        }

    }

    public static void main(String[] args) {
        Problem93 p = new Problem93();
        System.out.println(p.restoreIpAddresses("19216811"));
    }
}
