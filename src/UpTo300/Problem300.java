package UpTo300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem300 {
    public static void main(String[] args) {
        Problem300 p = new Problem300();

        System.out.println(p.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num :
                nums) {
            int i = Collections.binarySearch(list, num);
            if (i < 0) {
                i = ~i;
                if (i == list.size()) list.add(num);
                else list.set(i, num);
            }
        }
        return list.size();
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
