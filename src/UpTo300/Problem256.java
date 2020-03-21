package UpTo300;

public class Problem256 {
    public int minCost(int[][] costs) {
        int blue = 0, green = 0, red = 0;
        for (int[] cost :
                costs) {
            int b = blue, r = red, g = green;
            blue = Math.min(g, r) + cost[0];
            green = Math.min(b, r) + cost[1];
            red = Math.min(g, b) + cost[2];
        }
        return Math.min(Math.min(blue, red), green);
    }
}
