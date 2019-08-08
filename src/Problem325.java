import java.util.HashMap;
import java.util.Map;

public class Problem325 {
    public static void main(String[] args) {
        Problem325 p = new Problem325();

        System.out.println(p.maxSubArrayLen(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6));
    }

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k)
                ans = i + 1;
            if (map.containsKey(sum - k))
                ans = Math.max(i - map.get(sum - k), ans);
            map.putIfAbsent(sum, i);
        }
        return ans;
    }
}
