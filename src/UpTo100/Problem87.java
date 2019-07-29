package UpTo100;

public class Problem87 {
    public static void main(String[] args) {
        Problem87 p = new Problem87();

        System.out.println(p.isScramble("abcd", "bdac"));
    }

    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;
        if (len1 < 4 && isPartitionable(s1, s2)) return true;
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            String s10 = s1.substring(0, i);
            String s20 = s2.substring(0, i);
            String s11 = s1.substring(i, len);
            String s21 = s2.substring(i, len);
            if (isPartitionable(s10, s20)
                    && isPartitionable(s11, s21))
                if (isScramble(s10, s20)
                        && isScramble(s11, s21))
                    return true;
            String s22 = s2.substring(len - i, len);
            String s23 = s2.substring(0, len - i);
            if (isPartitionable(s10, s22)
                    && isPartitionable(s23, s11))
                if (isScramble(s10, s22)
                        && isScramble(s11, s23))
                    return true;
        }
        return false;
    }

    public boolean isPartitionable(String s1, String s2) {
        int[] count = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int x :
                count) {
            if (x != 0)
                return false;
        }
        return true;
    }
}
