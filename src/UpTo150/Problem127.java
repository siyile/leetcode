package UpTo150;

import java.util.*;

public class Problem127 {
    public static void main(String[] args) {
        Problem127 p = new Problem127();
        String[] a = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> words = new ArrayList<>();
        Collections.addAll(words, a);
        System.out.println(p.ladderLength("hit", "cog", words));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> tmp = new HashSet<>();
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            set.removeAll(beginSet);
            len++;
            for (String s :
                    beginSet) {
                // transform
                char[] chs = s.toCharArray();
                for (int k = 0; k < s.length(); k++) {
                    char ch = chs[k];
                    for (char i = 'a'; i <= 'z'; i++) {
                        chs[k] = i;
                        String str = String.valueOf(chs);
                        if (!visited.contains(str) && set.contains(str)) {
                            tmp.add(str);
                            visited.add(str);
                        }
                    }
                    chs[k] = ch;
                }
            }

            beginSet = tmp;
        }
        return 0;
    }
}
