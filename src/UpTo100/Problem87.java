package UpTo100;

public class Problem87 {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;
        if (len1 < 4 && isPartitionable(s1, s2)) return true;
        int len = s1.length();
        for (int i = 1; i < len - 1; i++) {
            if (isPartitionable(s1.substring(0, i), s2.substring(0, i))
                    && isPartitionable(s1.substring(i, len), s2.substring(i, len)))
                return isScramble(s1.substring(0, i), s2.substring(0, i))
                        && isScramble(s1.substring(i, len), s2.substring(i, len));
            if (isPartitionable(s1.substring(0, i), s2.substring(len - i, len))
                && isPartitionable(s2.substring(0, i), s1.substring(len - i, len)))
                return isScramble(s1.substring(0, i), s2.substring(len - i, len))
                && isScramble(s1.substring(len - i, len), s2.substring(0, i));
        }
        return false;
    }

    public boolean isPartitionable(String s1, String s2) {
        int[] count = new int[128];
        int len = s1.length();
        int total = 0;
        for (int i = 0; i < len; i++) {
            if (count[s1.charAt(i)]++ == 0)
                total++;
        }
        for (int i = 0; i < len; i++) {
            if (--count[s2.charAt(i)] == 0) {
                total--;
            }
        }
        return total == 0;
    }

    public static void main(String[] args) {
        Problem87 p = new Problem87();
        System.out.println(p.isScramble("abab","aabb"));
    }
}
