import java.util.*;

public class Problem480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        boolean odd = k % 2 == 1;
        Map<Integer, Integer> count = new HashMap<>();
        Queue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()), hi = new PriorityQueue<>();
        // init low
        for (int i = 0; i < k; i++)
            lo.add(nums[i]);
        // init hi
        for (int i = 0; i < k / 2; i++)
            hi.add(lo.poll());

        double[] ans = new double[n - k + 1];
        for (int i = k; i < n; i++) {
            ans[i - k] = (k & 1) == 1 ? lo.peek() : ((double) lo.peek() + (double) hi.peek()) * 0.5;

            int outNum = nums[i - k], inNum = nums[i], balance = 0;

            balance += (outNum <= lo.peek() ? -1 : 1);
            count.put(outNum, count.getOrDefault(outNum, 0) + 1);

            if (!lo.isEmpty() && inNum <= lo.peek()) {
                balance++;
                lo.add(inNum);
            } else {
                balance--;
                hi.add(inNum);
            }

            if (balance < 0) {
                lo.add(hi.poll());
                balance++;
            }

            if (balance > 0) {
                hi.add(lo.poll());
                balance--;
            }

            while (count.getOrDefault(lo.peek(), 0) != 0) {
                count.put(lo.peek(), count.get(lo.peek()) - 1);
                lo.poll();
            }
            while (!hi.isEmpty() && count.getOrDefault(hi.peek(), 0) != 0) {
                count.put(hi.peek(), count.get(hi.peek()) - 1);
                hi.poll();
            }
        }

        ans[n - k] = (k & 1) == 1 ? lo.peek() : ((double) lo.peek() + (double) hi.peek()) * 0.5;

        return ans;
    }
}
