import java.util.ArrayList;
import java.util.List;

public class Problem163 {
    public static void main(String[] args) {
        Problem163 p = new Problem163();

        System.out.println(p.findMissingRanges(new int[]{2147483647}, 0, 2147483647));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int cur = lower;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            if (sb.length() == 0) {
                if (cur != nums[i]) {
                    sb.append(cur);
                    if (cur == nums[i] - 1) {
                        ans.add(sb.toString());
                    } else {
                        sb.append("->");
                        sb.append(nums[i] - 1);
                        ans.add(sb.toString());
                    }
                    sb = new StringBuilder();
                    cur = nums[i] + 1;
                } else {
                    cur++;
                }
            } else {
                cur++;
            }
        }

        if (cur <= upper && (cur != Integer.MIN_VALUE && nums[nums.length - 1] == Integer.MAX_VALUE)) {
            sb.append(cur);
            if (upper > cur) {
                sb.append("->");
                sb.append(upper);
            }
            ans.add(sb.toString());
        }

        return ans;
    }
}
