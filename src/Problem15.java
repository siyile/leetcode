import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length < 3){
            return resList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    resList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    j++; k--;
                }
                else if (sum > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return resList;
    }

    public static void main(String [] args){
        Problem15 p = new Problem15();
        int[] nums = {1,-1,-1,0};
        System.out.println(p.threeSum(nums));
    }
}
