import java.util.HashSet;
import java.util.Set;

public class Problem1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int[] count = new int[2001];
        for (int x : arr) count[x + 1000]++;

        for (int x : count) {
            if (x != 0 && !set.add(x)) return false;
        }

        return true;
    }
}
