package UpTo750;

public class Problem730 {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10000];
        for (int n :
                nums) {
            arr[n] += n;
        }

        int cur = 0, prev = 0;
        for (int i = 0; i < 10000; i++) {
            int tmp = cur;
            cur = Math.max(cur, arr[i] + prev);
            prev = tmp;
        }

        return cur;
    }
}
