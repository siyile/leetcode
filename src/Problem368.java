import javax.swing.plaf.InsetsUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] count = new int[n];

        Arrays.sort(nums);

        int index = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            pre[i] = -1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + count[j] > count[i]) {
                    pre[i] = j;
                    count[i] = 1 + count[j];
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (index != -1) {
            ans.add(nums[index]);
            index = pre[index];
        }
        return ans;
    }
}
