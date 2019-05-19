import java.util.*;

public class Problem76 {
    public String minWindow2(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> tDict = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = tDict.getOrDefault(c, 0);
            tDict.put(c, count + 1);
        }

        int required = tDict.size();

        Map<Character, Integer> windowCounts = new HashMap<>();

        int formed = 0;
        int[] ans = {-1, 0, 0};
        int l = 0, r = 0;

        while (r < s.length()) {
            char rc = s.charAt(r);
            int count = windowCounts.getOrDefault(rc, 0);
            windowCounts.put(rc, count + 1);

            if (tDict.containsKey(rc) && windowCounts.get(rc).intValue() == tDict.get(rc).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                char lc = s.charAt(l);
                windowCounts.put(lc, windowCounts.get(lc) - 1);
                if (tDict.containsKey(lc) && (windowCounts.get(lc) < tDict.get(lc))) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for(int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }
        int begin = 0, num = 0, start = 0, len = Integer.MAX_VALUE;
        for(int end = 0; end < s.length(); end++) {
            if(count[s.charAt(end)] > 0) num++;
            count[s.charAt(end)]--;
            while(num == t.length()) {
                if(end - begin + 1 < len) {
                    len = end - begin + 1;
                    start = begin;
                }
                if(count[s.charAt(begin)] >= 0) num--;
                count[s.charAt(begin)]++;
                begin++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }

    public static void main(String[] args) {
        Problem76 p = new Problem76();

        System.out.println(p.minWindow("ABBBBC", "ABCB"));
    }
}
