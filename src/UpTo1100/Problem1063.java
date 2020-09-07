package UpTo1100;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1063 {
    public int validSubarrays(int[] nums) {
        Deque<Integer> s = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
                ans += i - s.poll();
            }
            s.push(nums[i]);
        }
        while (!s.isEmpty()) {
            ans += nums.length - s.poll();
        }
        return ans;
    }
}
