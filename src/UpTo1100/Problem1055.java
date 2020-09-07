package UpTo1100;

public class Problem1055 {
    public int shortestWay(String source, String target) {
        int ans = 0;
        int j = 0;
        char[] t = target.toCharArray();
        char[] s = source.toCharArray();
        while (j < t.length) {
            int i = 0;
            boolean notFound = true;
            while (i < s.length && j < t.length) {
                if (s[i] == t[j]) {
                    j++;
                    notFound = false;
                }
                i++;
            }
            if (notFound)
                return -1;
            ans++;
        }
        return ans;
    }

}
