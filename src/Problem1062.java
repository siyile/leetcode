import java.util.HashSet;
import java.util.Set;

public class Problem1062 {
    long MODULE = (long) Math.pow(2, 24);
    int base = 26;

    public int longestRepeatingSubstring(String S) {
        // init
        int[] nums = new int[S.length()];
        for (int i = 0; i < S.length(); i++) nums[i] = S.charAt(i) - 'a';

        int l = 1, r = S.length();
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (search(nums, m))
                l = m + 1;
            else
                r = m - 1;
        }
        return l - 1;
    }

    private boolean search(int[] nums, int L) {
        long hash = 0;
        for (int i = 0; i < L; i++) hash = (hash * base + nums[i]) % MODULE;

        long baseL = 1;
        for (int i = 0; i < L; i++) baseL = baseL * base % MODULE;

        Set<Long> seen = new HashSet<>();
        seen.add(hash);

        for (int i = 0; i < nums.length - L; i++) {
            hash = (hash * base - nums[i] * baseL % MODULE + MODULE) % MODULE;
            hash = (hash + nums[i + L]) % MODULE;
            if (!seen.add(hash)) return true;
        }
        return false;
    }
}
