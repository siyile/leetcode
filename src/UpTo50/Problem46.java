package UpTo50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Problem46 {
    public static void main(String[] args) {
        Problem46 p = new Problem46();
        int[] a = {};
        System.out.println(p.permute(a));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        iterator(q, new ArrayList<>(), ans);
        return ans;
    }

    private void iterator(Queue<Integer> q, List<Integer> temp, List<List<Integer>> ans) {
        if (q.size() == 0) {
            ans.add(temp);
            return;
        }
        for (int i = 0; i < q.size(); i++) {
            int value = q.poll();
            temp.add(value);
            iterator(q, new ArrayList<>(temp), ans);
            temp.remove(temp.size() - 1);
            q.add(value);
        }
    }
}
