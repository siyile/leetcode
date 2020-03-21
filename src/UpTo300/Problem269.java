package UpTo300;

import java.util.*;

public class Problem269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] degree = new int[26];
        Arrays.fill(degree, -1);

        for (String word :
                words) {
            for (int i = 0; i < word.length(); i++) {
                degree[word.charAt(i) - 'a'] = 0;
            }
        }

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i], w2 = words[i - 1];
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w2.charAt(j), c2 = w1.charAt(j);
                if (c1 != c2) {
                    if (!map.containsKey(c1)) {
                        map.put(c1, new HashSet<>());
                    }
                    Set<Character> set = map.get(c1);
                    if (set.add(c2)) {
                        degree[c2 - 'a']++;
                    }
                    break;
                }
            }
        }

        Deque<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) {
                q.add((char) (i + 'a'));
            }
            if (degree[i] != -1) {
                cnt++;
            }
        }

        while (!q.isEmpty()) {
            char c = q.poll();
            cnt--;
            sb.append(c);
            if (map.containsKey(c)) {
                for (char nei :
                        map.get(c)) {
                    if (degree[nei - 'a']-- == 1) {
                        q.add(nei);
                    }
                }
            }
        }
        return cnt == 0 ? sb.toString() : "";
    }
}
