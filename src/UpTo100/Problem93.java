package UpTo100;

import java.util.ArrayList;
import java.util.List;

public class Problem93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() > 12) {
            return ans;
        }
        ipBT(ans, s, 0, new StringBuilder(), 0);
        return ans;
    }

    private void ipBT(List<String> ans, String s, int n, StringBuilder sb, int count) {
        if (count == 4) {
            if (n != s.length()) return;
            ans.add(sb.deleteCharAt(sb.length() - 1).toString());
            sb.append('.');
            return;
        }
        if (count == 3 && s.length() - n > 3) return;
        for (int i = 1; i < 4 && n + i <= s.length(); i++) {
            String digitString = s.substring(n, n + i);
            int digit = Integer.parseInt(digitString);
            if ((digitString.startsWith("0") && digitString.length()>1) || (i==3 && Integer.parseInt(digitString) >= 256)) continue;
            if (digit < 256 && digit > -1) {
                sb.append(digitString);
                sb.append(".");
                ipBT(ans, s, n + i, sb, count + 1);
                sb.delete(sb.length() - i - 1, sb.length());
            }
        }
    }

    public static void main(String[] args) {
        Problem93 p = new Problem93();
        System.out.println(p.restoreIpAddresses("19216811"));
    }
}
