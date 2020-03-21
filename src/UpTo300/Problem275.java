package UpTo300;

public class Problem275 {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length - 1;
        int n = citations.length;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (n - mid > citations[mid]) {
                r = mid + 1;
            } else if (n - mid < citations[mid]) {
                l = mid - 1;
            } else {
                return citations[mid];
            }
        }
        return n - (r + 1);
    }
}
