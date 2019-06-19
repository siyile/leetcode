import java.util.HashSet;
import java.util.Set;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }
        int ans = 0;
        for (Integer num :
                nums) {
            if (!s.contains(num - 1)) {
                int len = 1;
                while (s.contains(num + 1)) {
                    num += 1;
                    len += 1;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem128 p = new Problem128();

        System.out.println(p.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
