import java.util.ArrayList;
import java.util.List;

public class Problem986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[i][0]);
            int hi = Math.min(A[i][1], B[i][1]);
            if (hi >= lo)
                ans.add(new int[]{lo, hi});
            if (A[i][1] > B[i][1])
                j++;
            else i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
