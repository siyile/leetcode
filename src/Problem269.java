import java.util.*;

public class Problem269 {
    public static void main(String[] args) {
        Problem269 p = new Problem269();

        System.out.println(p.alienOrder(new String[]{"z", "x", "z"}));
    }

    public String alienOrder(String[] words) {
        int[] degree = new int[26];
        Arrays.fill(degree, -1);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        int maxLen = 0;
        for (String s :
                words) {
            for (int i = 0; i < s.length(); i++) {
                degree[s.charAt(i) - 'a'] = 0;
            }
            maxLen = Math.max(maxLen, s.length());
        }

        for (int i = 0; i < maxLen; i++) {
            int j = 0;
            while (j < words.length && words[j].length() < i + 1) j++;
            String prev = words[j++];
            for (; j < words.length; j++) {
                String word = words[j];
                if (word.length() > i) {
                    if (validate(word, prev, i)) {
                        degree[prev.charAt(i) - 'a']++;
                        graph.get(word.charAt(i) - 'a').add(prev.charAt(i) - 'a');

                    }
                    prev = word;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append((char) (node + 'a'));
            for (int nei :
                    graph.get(node)) {
                if (--degree[nei] == 0)
                    q.add(nei);
            }
        }

        for (int x :
                degree) {
            if (x > 0) return "";
        }

        return sb.reverse().toString();
    }

    private boolean validate(String word, String prev, int i) {
        if (prev.charAt(i) == word.charAt(i)) return false;
        if (i == 0) return true;
        for (int j = 0; j < i; j++) {
            if (prev.charAt(j) != word.charAt(j)) return false;
        }
        return true;
    }
}
