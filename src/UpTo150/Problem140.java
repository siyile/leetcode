package UpTo150;

import java.util.*;

public class Problem140 {
    HashMap<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        Problem140 p = new Problem140();
        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict, "cat", "cats", "and", "sand", "dog");
        System.out.println(p.wordBreak("catsanddog", wordDict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s))
            return map.get(s);

        List<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word :
                wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = wordBreak(s.substring(word.length()), wordDict);
                for (String sub :
                        sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
