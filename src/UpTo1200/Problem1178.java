package UpTo1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (String word :
                words) {
            int mask = 0;
            for (char c :
                    word.toCharArray()) {
                mask |= 1 << c - 'a';
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        for (String puzzle :
                puzzles) {
            int mask = 0;
            for (char c :
                    puzzle.toCharArray()) {
                mask |= 1 << c - 'a';
            }
            int sub = mask;
            int first = 1 << puzzle.charAt(0) - 'a';
            int total = 0;
            while (sub > 0) {
                if ((sub & first) == first) {
                    total += map.getOrDefault(sub, 0);
                }
                sub = (sub - 1) & mask;
            }
            ans.add(total);
        }
        return ans;
    }
}
