package UpTo350;

import java.util.Arrays;

public class Problem338 {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        int x = 1, y = 1;
        for (int i = 1; i <= num; i++) {
            if (i == x) {
                count[i] = y;
                y += 1;
                x <<= 1;
                x++;
            } else {
                count[i] = y - count[x ^ i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem338 p = new Problem338();

        System.out.println(Arrays.toString(p.countBits(7)));
    }
}
