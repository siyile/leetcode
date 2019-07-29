package UpTo150;

import java.util.*;

public class Problem127 {
    public static void main(String[] args) {
        Problem127 p = new Problem127();
        String[] a = {"a", "b", "c"};
        List<String> words = new ArrayList<>();
        Collections.addAll(words, a);
        System.out.println(p.ladderLength("a", "c", words));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            wordList.removeAll(beginSet);
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char old = chs[i];
                        chs[i] = ch;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) return level + 1;
                        if (!visited.contains(target) && wordList.contains(target)) {
                            visited.add(target);
                            temp.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            level++;
        }
        return 0;
    }
}
