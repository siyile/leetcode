import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;
        List<int[]> ans = new ArrayList<>();
        int[] start = new int[len];
        int[] end = new int[len];
        for (int k = 0; k < len; k++) {
            start[k] = intervals[k][0];
            end[k] = intervals[k][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0, j = 0; i < len; i++) {
            if (i == len - 1 || start[i + 1] > end[i]) {
                ans.add(new int[]{start[j], end[i]});
                j = i + 1;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Problem56 p = new Problem56();
        int[][] a = {{1,4},{4,5}};
        int[][] ans = p.merge(a);
        for (int[] x : ans) {
            System.out.println(x[0] + " " + x[1]);
        }
    }
}
