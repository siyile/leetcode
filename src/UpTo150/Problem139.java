package UpTo150;

import java.util.*;

public class Problem139 {
    public static void main(String[] args) {
        Problem139 p = new Problem139();
        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict, "cats", "dog", "sand", "and", "cat");
        System.out.println(p.wordBreak("catsandog", wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] memo = new boolean[s.length() + 1];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String str :
                dict) {
            max = Math.max(max, str.length());
            min = Math.min(min, str.length());
        }
        memo[0] = true;
        for (int i = min; i <= s.length(); i++) {
            boolean flag = false;
            for (int j = min; j <= max && i - j >= 0; j++) {
                flag = dict.contains(s.substring(i - j, i)) && memo[i - j];
                if (flag)
                    break;
            }
            memo[i] = flag;
        }
        return memo[s.length()];
    }
}
