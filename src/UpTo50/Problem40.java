package UpTo50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        tryFromMax(res, new ArrayList<>(), candidates, target, candidates.length - 1);
        return res;
    }

    private void tryFromMax(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int index) {
        for (int i = index; i > -1; i--) {
            int current = candidates[i];
            if (current < target) {
                if (i < index && candidates[i] == candidates[i + 1]) continue;
                tempList.add(current);
                tryFromMax(res, tempList, candidates, target - current, i - 1);
                tempList.remove(tempList.size() - 1);
            } else if (current == target) {
                if (i < index && candidates[i] == candidates[i + 1]) continue;
                tempList.add(current);
                res.add(new ArrayList<>(tempList));
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem40 p = new Problem40();
        int[] a = {10, 1, 2, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(p.combinationSum2(a, target));
    }
}
