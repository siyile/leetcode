import java.util.*;

public class Problem239 {
    Deque<Integer> q = new LinkedList<>();
    int[] nums;

    public static void main(String[] args) {
        Problem239 p = new Problem239();

        System.out.println(p.maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4));
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> del = new HashMap<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i >= k - 1) {
                if (i > k - 1) {
                    del.put(nums[i - k], del.getOrDefault(nums[i - k], 0) + 1);
                    while (del.containsKey(q.peek()) && del.get(q.peek()) > 0) {
                        del.put(q.peek(), del.get(q.peek()) - 1);
                        q.poll();
                    }
                }
                ans[i - k + 1] = q.peek();
            }
        }
        return ans;
    }

    private void clean(int i, int k) {
        if (!q.isEmpty() && q.getFirst() == i - k)
            q.removeFirst();
        while (!q.isEmpty() && nums[q.getLast()] <= nums[i])
            q.removeLast();
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        this.nums = nums;
        int[] out = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            clean(i, k);
            q.addLast(i);
        }
        out[0] = nums[q.getFirst()];

        for (int i = k; i < n; i++) {
            clean(i, k);
            q.addLast(i);
            out[i - k + 1] = nums[q.getFirst()];
        }
        return out;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // left to right
            if (i % k == 0)
                left[i] = nums[i];
            else
                left[i] = Math.max(nums[i], left[i - 1]);
        }

        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (i % k == k - 1)
                right[i] = nums[i];
            else
                right[i] = Math.max(nums[i], right[i + 1]);
        }

        int[] out = new int[n - k + 1];
        for (int i = 0; i + k - 1 < n; i++) {
            out[i] = Math.max(right[i], left[i + k - 1]);
        }

        return out;
    }
}
