package utils;

public class BinarySearch {
    // Input: Indices Range [l ... r)
    // Invariant: A[l] <= key and A[r] > key
    int GetRightPosition(int[] A, int l, int r, int key) {
        int m;
        while (r - l > 1) {
            m = l + (r - l) / 2;

            if (A[m] <= key)
                l = m;
            else
                r = m;
        }
        return l;
    }

    // Input: Indices Range (l ... r]
    // Invariant: A[r] >= key and A[l] > key
    int GetLeftPosition(int[] A, int l, int r, int key) {
        int m;
        while (r - l > 1) {
            m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }
        return r;
    }
}
