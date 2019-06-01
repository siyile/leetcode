package UpTo100;

import java.util.*;

public class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int count = 0;
            while (i < len - 1 && nums[i] == nums[i + 1]) {
                i++;
                count++;
            }
            int len2 = ans.size();
            for (int j = 0; j < len2; j++) {
                if (count > 0) {
                    for (int k = 0; k < count + 1; k++) {
                        List<Integer> temp = new ArrayList<>(ans.get(j));
                        for (int l = 0; l < k + 1; l++) {
                            temp.add(nums[i]);
                        }
                        ans.add(temp);
                    }
                } else {
                    List<Integer> temp = new ArrayList<>(ans.get(j));
                    temp.add(nums[i]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem90 p = new Problem90();
        int[] a = {1,1,2,2};
        System.out.println(p.subsetsWithDup(a));
    }
}
