package UpTo150;

public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                ans = i;
            }
        }
        if (sum < 0) return -1;
        return (ans + 1) % gas.length;
    }

    public static void main(String[] args) {
        Problem134 p = new Problem134();

        System.out.println(p.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
