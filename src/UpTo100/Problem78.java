package UpTo100;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetsBT(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void subsetsBT(int[] nums, int start, List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsBT(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem78 p = new Problem78();
        int[] a = {1,2,3};
        System.out.println(p.subsets(a));
    }
}
