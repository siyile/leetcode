package UpTo50;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Problem30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int len = s.length();
        int cnt = words.length;
        if (len <= 0 || cnt <= 0) {
            return ans;
        }
        int wl = words[0].length();
        HashMap<String, Integer> dict = new HashMap<>();
        HashMap<String, Integer> tdict = new HashMap<>();
        for (String word : words) {
            if (dict.containsKey(word)) dict.put(word, dict.get(word) + 1);
            else {
                dict.put(word, 1);
                tdict.put(word, 0);
            }
        }
        int count, curCount;
        for (int j = 0; j < wl; j++){
            curCount = 0;
            count = 0;
            tdict.replaceAll((k, v) -> 0);
            for (int i = j; i <= len - wl; i += wl) {
                String cword = s.substring(i, i + wl);
                if (curCount < cnt) {
                    if (!tdict.containsKey(cword)){
                        tdict.replaceAll((k, v) -> 0);
                        count = 0;
                        curCount = 0;
                        continue;
                    }
                    else if (tdict.get(cword) < dict.get(cword)) {
                        count++;
                    }
                    tdict.put(cword, tdict.get(cword) + 1);
                    curCount++;
                } else if (!tdict.containsKey(cword)){
                    tdict.replaceAll((k, v) -> 0);
                    count = 0;
                    curCount = 0;
                } else {
                    if (tdict.get(cword) < dict.get(cword)) count++;
                    tdict.put(cword, tdict.get(cword) + 1);
                    String fword = s.substring(i - wl * cnt, i - wl * cnt + wl);
                    if (tdict.get(fword) <= dict.get(fword)) count--;
                    tdict.put(fword, tdict.get(fword) - 1);
                }
                if (count == cnt) {
                    ans.add(i - cnt * wl + wl);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaa";
        String[] words = {"aa","aa","aa"};
        Problem30 p = new Problem30();
        System.out.println(p.findSubstring(s, words));
    }
}
