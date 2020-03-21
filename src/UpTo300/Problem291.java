package UpTo300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem291 {
    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Problem291 p = new Problem291();

        System.out.println(p.wordPatternMatch("aaaa", "asdasdasdasd"));
    }

    public boolean wordPatternMatch(String pattern, String str) {
        return isMatch(str, pattern, 0, 0);
    }

    private boolean isMatch(String str, String pattern, int i, int j) {
        if (i == str.length() && j == pattern.length()) return true;
        if (i == str.length() || j == pattern.length()) return false;

        char ch = pattern.charAt(j);
        if (map.containsKey(ch)) {
            if (str.startsWith(map.get(ch), i)) {
                return isMatch(str, pattern, map.get(ch).length() + i, j + 1);
            } else return false;
        } else {
            for (int k = i + 1; k <= str.length(); k++) {
                String p = str.substring(i, k);

                if (set.contains(p)) continue;

                set.add(p);
                map.put(ch, p);

                if (isMatch(str, pattern, k, j + 1)) return true;

                set.remove(p);
                map.remove(ch);
            }
        }

        return false;
    }
}
