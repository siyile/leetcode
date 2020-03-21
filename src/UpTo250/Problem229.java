package UpTo250;

import java.util.ArrayList;
import java.util.List;

public class Problem229 {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 1, count1 = 0, count2 = 0;
        for (int num :
                nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        List<Integer> array = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3)
            array.add(candidate1);
        if (count2 > nums.length / 3)
            array.add(candidate2);
        return array;
    }
}
