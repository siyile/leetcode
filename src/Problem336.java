import java.util.*;

public class Problem336 {
    Map<String, Integer> map = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String str1 = word.substring(0, j);
                String str2 = word.substring(j);
                process(str1, str2, i, false);
                process(str2, str1, i, true);
            }
        }
        return ans;
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--))
                return false;
        }
        return true;
    }

    private void process(String str1, String str2, int i, boolean reverse) {
        if (isPalindrome(str1)) {
            String str2rev = new StringBuilder(str2).reverse().toString();
            if (map.getOrDefault(str2rev, i) != i) {
                if (!reverse)
                    ans.add(Arrays.asList(map.get(str2rev), i));
                else if (str1.length() != 0)
                    ans.add(Arrays.asList(i, map.get(str2rev)));
            }
        }
    }
}
