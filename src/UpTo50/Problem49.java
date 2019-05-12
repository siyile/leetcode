package UpTo50;

import java.util.*;

public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return null;
        HashMap<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int value : count) {
                sb.append('#');
                sb.append(value);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Math.pow(1.1, -2);
    }
}
