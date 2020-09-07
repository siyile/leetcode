package UpTo650;

import java.util.*;

public class Problem642 {
    public static void main(String[] args) {
        Problem642 p = new Problem642();
        AutocompleteSystem a = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        System.out.println(a.input('i'));
        System.out.println(a.input(' '));
        System.out.println(a.input('a'));
        System.out.println(a.input('#'));
    }

    private static class AutocompleteSystem {
        Trie root = new Trie();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        Trie node = root;

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                add(sentences[i], times[i]);
            }
        }

        public List<String> input(char c) {
            List<String> ans = new ArrayList<>();
            if (c == '#') {
                add(sb.toString(), 1);
                sb = new StringBuilder();
                node = root;
                return ans;
            }
            sb.append(c);
            if (node.next.containsKey(c))
                node = node.next.get(c);
            else {
                node = null;
                return ans;
            }
            Queue<String> q = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (map.get(o2) - map.get(o1) != 0)
                        return map.get(o2) - map.get(o1);
                    else return o1.compareTo(o2);
                }
            });
            dfs(node, q);
            for (int i = 0; i < 3 && !q.isEmpty(); i++) {
                ans.add(q.poll());
            }
            return ans;
        }

        private void dfs(Trie node, Queue<String> q) {
            if (node.times != 0)
                q.add(sb.toString());
            for (char c :
                    node.next.keySet()) {
                sb.append(c);
                dfs(node.next.get(c), q);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        private void add(String s, int t) {
            map.put(s, map.getOrDefault(s, 0) + t);
            Trie node = root;
            for (char c :
                    s.toCharArray()) {
                node.next.putIfAbsent(c, new Trie());
                node = node.next.get(c);
            }
            node.times += t;
        }

        class Trie {
            Map<Character, Trie> next;
            int times;

            Trie() {
                times = 0;
                next = new HashMap<>();
            }
        }
    }
}
