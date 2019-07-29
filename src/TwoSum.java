import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    Set<Integer> s1;
    Set<Integer> s2;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        s1 = new HashSet<>();
        s2 = new HashSet<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (s1.contains(number)) s2.add(number << 1);
        else s1.add(number);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer x :
                s1) {
            int y = value - x;
            if (y == x) {
                if (s2.contains(value)) return true;
            } else {
                if (s1.contains(value)) return true;
            }
        }
        return false;
    }
}
