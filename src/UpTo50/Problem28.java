package UpTo50;

import java.util.Arrays;

public class Problem28 {
    public int strStr(String haystack, String needle) {
        int[] lps = getLPS(needle);
        System.out.println(Arrays.toString(lps));

        int N = haystack.length();
        int M = needle.length();

        int i = 0, j = 0;

        while (i < N) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == M) {
                return i - j;
            } else if (i < N && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i += 1;
            }
        }
        return -1;
    }

    private int[] getLPS(String pattern) {
        int len = 0;
        int[] lps = new int[pattern.length()];
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }

    public static void main(String [] args) {
        Problem28 p = new Problem28();
        System.out.println(p.strStr("mississippi", "issi"));
    }
}
