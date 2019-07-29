package UpTo150;

import java.util.Arrays;

public class Problem135 {
    public static void main(String[] args) {
        Problem135 p = new Problem135();

        System.out.println(p.candy(new int[]{2, 3, 2}));
    }

    private int count(int n) {
        return n * (1 + n) / 2;
    }

    public int candy2(int[] ratings) {
        if (ratings.length < 2) return ratings.length;
        int old_slope = 0;
        int up = 0;
        int down = 0;
        int candies = 0;
        for (int i = 1; i < ratings.length; i++) {
            int new_slope = Integer.compare(ratings[i], ratings[i - 1]);
            if (new_slope == 0 || old_slope < 0 && new_slope > 0) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope == 1) {
                up++;
            } else if (new_slope == -1) {
                down++;
            } else {
                candies++;
            }
            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }

    public int candy(int[] ratings) {
        if (ratings.length < 2) return ratings.length;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], 1 + candies[i + 1]);
            }
            sum += candies[i];
        }
        return sum;
    }
}
