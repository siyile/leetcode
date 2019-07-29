import java.util.HashMap;
import java.util.Map;

public class Problem169 {
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            if (count > nums.length / 2 - 1)
                return nums[i];
            map.put(nums[i], ++count);
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = nums[0];
        for (Integer x :
                nums) {
            if (count++ == 0) {
                majority = x;
            } else if (majority == x) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}
