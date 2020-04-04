public class Problem392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length()) {
            while (j < t.length() && s.charAt(i) != t.charAt(j)) {
                j++;
            }
            if (j == t.length()) {
                return false;
            }
            j++;
            i++;
        }

        return i == s.length();
    }
}
