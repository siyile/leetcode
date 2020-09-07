package UpTo1000;

public class Problem964 {
    public int leastOpsExpressTarget(int x, int target) {
        if (target < x) {
            return Math.min(target * 2 - 1, (x - target) * 2);
        }
        if (target == x) {
            return 0;
        }
        int times = 0;
        long sum = x;
        while (sum < target) {
            sum *= x;
            times += 1;
        }

        if (sum == target) {
            return times;
        }
        int l = Integer.MAX_VALUE, r;
        if (sum - target < target) {
            l = leastOpsExpressTarget(x, (int) (sum - target)) + times;
        }
        r = leastOpsExpressTarget(x, (int) (target - (sum / x))) + times - 1;
        return Math.min(l, r) + 1;
    }
}
