import java.util.*;

public class Problem480 {
    public static void main(String[] args) {
        Problem480 p = new Problem480();

        Arrays.stream(p.medianSlidingWindow(new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 2)).forEach(System.out::println);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        PriorityQueue<Integer> hi = new PriorityQueue<>();
        PriorityQueue<Integer> lo = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            lo.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            hi.add(lo.poll());
        }

        int i = k;
        while (true) {
            ans[i - k] = (k % 2 == 1 ? lo.peek() : (0.0 + lo.peek() + hi.peek()) / 2);

            if (i >= nums.length)
                return ans;

            int out_num = nums[i - k],
                    in_num = nums[i++],
                    balance = 0;

            balance += out_num <= lo.peek() ? -1 : 1;
            map.put(out_num, map.getOrDefault(out_num, 0) + 1);

            if (!lo.isEmpty() && in_num <= lo.peek()) {
                balance++;
                lo.add(in_num);
            } else {
                balance--;
                hi.add(in_num);
            }

            if (balance < 0) {
                lo.add(hi.poll());
            }
            if (balance > 0) {
                hi.add(lo.poll());
            }

            while (map.getOrDefault(lo.peek(), 0) > 0) {
                map.put(lo.peek(), map.get(lo.peek()) - 1);
                lo.poll();
            }
            while (!hi.isEmpty() && map.getOrDefault(hi.peek(), 0) > 0) {
                map.put(hi.peek(), map.get(hi.peek()) - 1);
                hi.poll();
            }
        }
    }
}
