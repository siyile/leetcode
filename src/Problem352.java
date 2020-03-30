import java.util.ArrayList;
import java.util.TreeMap;

public class Problem352 {
    private class SummaryRanges {
        TreeMap<Integer, int[]> tree;

        /** Initialize your data structure here. */
        public SummaryRanges() {
            tree = new TreeMap<>();
        }

        public void addNum(int val) {
            if (tree.containsKey(val)) {
                return;
            }
            Integer l = tree.lowerKey(val);
            Integer h = tree.higherKey(val);
            if (l != null && h != null && tree.get(l)[1] + 1 == val && h == val + 1) {
                tree.get(l)[1] = tree.get(h)[1];
                tree.remove(h);
            } else if (l != null && tree.get(l)[1] + 1 >= val) {
                tree.get(l)[1] = Math.max(tree.get(l)[1], val);
            } else if (h != null && h == val + 1) {
                tree.put(val, new int[]{val, tree.get(h)[1]});
                tree.remove(h);
            } else {
                tree.put(val, new int[]{val, val});
            }
        }

        public int[][] getIntervals() {
            int[][] res = new int[tree.size()][2];
            int i = 0;
            for (int[] arr :
                    tree.values()) {
                res[i++] = arr;
            }
            return res;
        }
    }
}
