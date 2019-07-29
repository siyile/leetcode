package UpTo50;

import java.util.ArrayList;
import java.util.List;

public class Problem39 {
    public static void main(String[] args) {
        Problem39 p = new Problem39();
        int[] a = {2, 3, 5};
        int target = 8;
        System.out.println(p.combinationSum(a, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        tryFromMax(res, new ArrayList<>(), candidates, target, candidates.length - 1);
        return res;
    }

    private void tryFromMax(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int index) {
        for (int i = index; i > -1; i--) {
            int current = candidates[i];
            if (current < target) {
                tempList.add(current);
                tryFromMax(res, tempList, candidates, target - current, i);
                tempList.remove(tempList.size() - 1);
            } else if (current == target) {
                tempList.add(current);
                res.add(new ArrayList<>(tempList));
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
