package UpTo500;

import java.util.Arrays;

public class Problem475 {
    public static void main(String[] args) {
        Problem475 p = new Problem475();
        int a = -10;
        System.out.println(~a);
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for (Integer x :
                houses) {
            int index = Arrays.binarySearch(heaters, x);
            if (index < 0)
                index = ~index;
            int dist1 = index - 1 >= 0 ? x - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - x : Integer.MAX_VALUE;
            ans = Math.max(ans, Math.min(dist1, dist2));
        }
        return ans;
    }
}
