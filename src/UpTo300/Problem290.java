package UpTo300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem290 {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strings[i])) {
                    return false;
                }
            } else {
                if (!set.add(strings[i])) {
                    return false;
                }
                map.put(ch, strings[i]);
            }
        }
        return true;
    }
}
