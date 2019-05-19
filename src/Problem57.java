import java.util.ArrayList;
import java.util.List;

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        int len = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while (i < len && start > intervals[i][1]) {
            ans.add(intervals[i++]);
        }
        while (i < len && intervals[i][0] <= end) {
            start = Math.min(intervals[i][0], start);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        ans.add(new int[]{start, end});
        while (i < len) {
            ans.add(intervals[i++]);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Problem57 p = new Problem57();
        int[][] a = {{2,3},{6,9}};
        int[] b = {10,11};
        int[][] ans = p.insert(a, b);
        for (int[] x : ans) {
            System.out.println(x[0] + " " + x[1]);
        }
    }
}
