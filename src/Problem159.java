import java.util.HashSet;
import java.util.Set;

public class Problem159 {
    public static void main(String[] args) {
        Problem159 p = new Problem159();

        System.out.println(p.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> set = new HashSet<>();
        int[] pos = new int[128];
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            set.add(s.charAt(r));
            pos[s.charAt(r)] = r++;
            while (l < r && set.size() > 2) {
                if (l == pos[s.charAt(l)]) {
                    set.remove(s.charAt(l));
                }
                l++;
            }
            max = Math.max(max, r - l);
        }

        return max;
    }
}
