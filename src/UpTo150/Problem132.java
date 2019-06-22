package UpTo150;

import java.util.stream.IntStream;

public class Problem132 {
    public int minCut(String s) {
        if (s.length() < 1) return 0;
        int n = s.length();
        int[] memo = IntStream.range(0, n).toArray();

        // important! key step!!!
        for (int mid = 1; mid < n; mid++) {
            for (int start = mid, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++) {
                int cut = start == 0 ? 0 : memo[start - 1] + 1;
                memo[end] = Math.min(cut, memo[end]);
            }
            for (int start = mid - 1, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++) {
                int cut = start == 0 ? 0 : memo[start - 1] + 1;
                memo[end] = Math.min(cut, memo[end]);
            }
        }

        return memo[n - 1];
    }
    public static void main(String[] args) {
        Problem132 p = new Problem132();
        System.out.println(p.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }
}
