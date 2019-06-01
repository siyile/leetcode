package UpTo100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem80 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int cur = 0;
        for (int i = 0; i < len - 2; i++) {
            if (!(nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])){
                nums[cur++] = nums[i];
            }
        }
        nums[cur++] = nums[len - 2];
        nums[cur] = nums[len - 1];
        return cur + 1;
    }

    public static void main(String[] args) {
        Problem80 p = new Problem80();
        int[] a = {0,0,1,1,1,1,2,3,3};
        System.out.println(p.removeDuplicates(a));
        System.out.println(Arrays.stream(a).mapToObj(x -> x + " ").collect(Collectors.joining()));
    }
}
