package UpTo1250;

public class Problem1224 {
    public int maxEqualFreq(int[] nums) {
        int[] group = new int[100001];
        int[] count = new int[100001];
        int max = 0;
        int ans = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count[num] += 1;
            int cnt = count[num];
            if (cnt != 1) {
                group[cnt - 1]--;
            } else {
                n++;
            }
            group[cnt]++;
            max = Math.max(cnt, max);
            if (group[max] == 1 && group[max - 1] == n - 1 || group[max] == n - 1 && group[1] == 1 || max == 1) {
                ans = i;
            }
        }
        return ans + 1;
    }
}
