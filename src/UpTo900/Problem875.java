package UpTo900;

public class Problem875 {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = 1_000_000_000;
        while (l < r) {
            int m = (l + r) / 2;
            if (possible(m, piles, H))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    private boolean possible(int k, int[] piles, int h) {
        int time = 0;
        for (int pile :
                piles)
            time += (pile - 1) / k + 1;
        return time <= h;
    }
}
