package UpTo50;

public class Problem28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int alen = haystack.length();
        int blen = needle.length();
        if (alen < blen) return -1;
        char [] a = haystack.toCharArray();
        char [] b = needle.toCharArray();

        for (int i = 0; i < alen - blen + 1; i++) {
            int j = 0;
            int p = i;
            while (j < blen && a[p++] == b[j++]) {
                if (j == blen) {
                    return p - j;
                }
            }
        }
        return -1;
    }

    public static void main(String [] args) {
        Problem28 p = new Problem28();
        System.out.println(p.strStr("mississippi", "issi"));
    }
}
