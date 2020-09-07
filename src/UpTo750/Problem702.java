package UpTo750;

public class Problem702 {
    public int search(ArrayReader reader, int target) {
        if (target > 9999 || target < -9999) return -1;
        int l = 0, r = Integer.MAX_VALUE - 2;
        while (l < r) {
            int m = l - (l - r) / 2;
            if (reader.get(m) == target)
                return m;
            else if (reader.get(m) == Integer.MAX_VALUE)
                r = m - 1;
            else if (reader.get(m) > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return reader.get(l) == target ? l : -1;
    }


    class ArrayReader {
        int get(int k) {
            return 0;
        }
    }
}
