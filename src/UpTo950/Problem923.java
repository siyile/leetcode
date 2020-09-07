package UpTo950;

import java.util.ArrayList;
import java.util.List;

public class Problem923 {
    public int threeSumMulti(int[] A, int target) {
        long ans = 0;
        long[] cnt = new long[101];
        List<Integer> nums = new ArrayList<>();
        for (int x :
                A) {
            cnt[x]++;
        }
        for (int i = 0; i < 101; i++) {
            if (cnt[i] != 0) nums.add(i);
        }
        for (int i = 0; i < nums.size(); i++) {
            int l = i + 1, r = nums.size() - 1;
            while (l < r) {
                int x = nums.get(i), y = nums.get(l), z = nums.get(r);
                if (x + y + z == target) {
                    ans += cnt[x] * cnt[y] * cnt[z];
                    l++;
                    r--;
                } else if (x + y + z < target) {
                    l++;
                } else {
                    r--;
                }
            }

            int x = nums.get(i);
            if (cnt[x] > 2 && nums.get(i) * 3 == target) {
                ans += cnt[x] * (cnt[x] - 1) * (cnt[x] - 2) / 6;
            } else if (cnt[x] > 1) {
                int y = target - 2 * x;
                if (x != y && y >= 0 && y < 101 && cnt[y] > 0)
                    ans += cnt[y] * cnt[x] * (cnt[x] - 1) / 2;
            }
        }

        return (int) (ans % (1e9 + 7));
    }
}
