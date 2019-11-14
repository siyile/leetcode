package UpTo200;

public class Problem161 {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() == t.length()) {
            int count = 0;
            for (int i = 0; i < s.length() && count < 2; i++) {
                if (s.charAt(i) != t.charAt(i)) count++;
            }
            return count == 1;
        } else if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        int i = 0;
        while (i < t.length() && s.charAt(i) == t.charAt(i)) i++;
        while (i < t.length() && s.charAt(i + 1) == t.charAt(i)) i++;
        return i == t.length();
    }
}
