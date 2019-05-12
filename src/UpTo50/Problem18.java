package UpTo50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++){
            if (i > 0 && nums[i] == nums[i - 1] ) continue;
            for (int j = i + 1; j < len - 2; j++){
                if (nums[j] == nums[j - 1] && j > i + 1) continue;
                int k = j + 1;
                int l = len - 1;
                while (k < l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                    else if (sum > target) l--;
                    else k++;
                }
            }
        }
        return res;
    }

    public static void main(String [] args){
        Problem18 p = new Problem18();
        int [] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(p.fourSum(nums, 0));
    }
}
