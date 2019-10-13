package UpTo150;

import java.util.*;

public class Problem126 {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        // build graph
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> curLevel = new HashSet<>();
        curLevel.add(beginWord);
        boolean found = false;
        while (!found && !curLevel.isEmpty()) {
            dict.removeAll(curLevel);
            Set<String> nextLevel = new HashSet<>();
            for (String s :
                    curLevel) {
                graph.put(s, new ArrayList<>());
                char[] chs = s.toCharArray();
                for (int k = 0; k < beginWord.length(); k++) {
                    char x = chs[k];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[k] = c;
                        String tmp = new String(chs);
                        if (dict.contains(tmp)) {
                            graph.get(s).add(tmp);
                            nextLevel.add(tmp);
                            if (tmp.equals(endWord)) found = true;
                        }
                    }
                    chs[k] = x;
                }
            }
            curLevel = nextLevel;
        }

        if (!found) return ans;
        List<String> tmp = new ArrayList<>();
        tmp.add(beginWord);
        // build path
        dfs(beginWord, endWord, graph, tmp);
        return ans;
    }

    private void dfs(String node, String end, Map<String, List<String>> graph, List<String> tmp) {
        if (node.equals(end)) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (!graph.containsKey(node)) return;
        for (String nei :
                graph.get(node)) {
            tmp.add(nei);
            dfs(nei, end, graph, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem126 p = new Problem126();
        String[] word = {"hot","dot","dog","lot","log","cog"};
        List<String> words = new ArrayList<>();
        Collections.addAll(words, word);
        System.out.println(p.findLadders("hit", "cog", words));
    }
}
