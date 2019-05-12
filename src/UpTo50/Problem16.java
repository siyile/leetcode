package UpTo50;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) return IntStream.of(nums).sum();
        Arrays.sort(nums);
        int base = -1;
        int minus = -1;
        while (true){
            minus *= -1;
            base += 1;
            target += minus * base;
            for (int i = 0; i < len - 2; i++){
                int j = i + 1;
                int k = len - 1;
                while (j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target){
                        return target;
                    }
                    else if (sum > target){
                        k--;
                        if (nums[k] == nums[k + 1]) k--;
                    }
                    else {
                        j++;
                        if (nums[j] == nums[j - 1]) j++;
                    }
                }
            }
        }
    }

    public static void main(String [] args){
        Problem16 p = new Problem16();
        int [] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(p.threeSumClosest(nums, target));
    }
}
