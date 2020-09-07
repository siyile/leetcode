import java.util.HashSet;
import java.util.Set;

public class Problem1521 {
    public int closestToTarget(int[] arr, int target) {
        int ans = 0;
        Set<Integer> s1 = new HashSet<>();
        for (int x :
                arr) {
            Set<Integer> s2 = new HashSet<>();
            s2.add(x);
            for (int x2 :
                    s1) {
                s2.add(x & x2);
            }
            for (int x3 :
                    s2) {
                ans = Math.min(ans, Math.abs(x3 - target));
            }
            s1 = s2;
        }
        return ans;
    }
}
