package UpTo300;

import java.util.*;

public class Problem288 {
    public static void main(String[] args) {
        Problem288 p = new Problem288();
        p.wrapper();
    }

    public void wrapper() {
        ValidWordAbbr v = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(v.isUnique("dear"));
        System.out.println(v.isUnique("cart"));
        System.out.println(v.isUnique("cane"));
        System.out.println(v.isUnique("make"));
    }

    class ValidWordAbbr {
        private final Map<String, Boolean> map = new HashMap<>();
        private final Set<String> dict;

        public ValidWordAbbr(String[] dictionary) {
            dict = new HashSet<>(Arrays.asList(dictionary));
            for (String word :
                    dict) {
                String abbr = toAbbr(word);
                map.put(abbr, !map.containsKey(abbr));
            }
        }

        public boolean isUnique(String word) {
            String abbr = toAbbr(word);
            if (!map.containsKey(abbr))
                return true;
            return abbr == null || (map.get(abbr) && dict.contains(abbr));
        }

        public String toAbbr(String word) {
            int n = word.length();
            if (n < 3) return word;
            return word.charAt(0) + Integer.toString(n) + word.charAt(n - 1);
        }
    }
}
