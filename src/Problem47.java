import java.util.*;

public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        iterator(nums, new ArrayList<>(), ans, used);
        return ans;
    }

    private void iterator(int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean[] used) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            iterator(nums, temp, ans, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Problem47 p = new Problem47();
        int[] a = {1,1,4,1,4,5};
        System.out.println(p.permuteUnique(a));
    }
}
