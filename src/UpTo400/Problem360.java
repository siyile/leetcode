package UpTo400;

import java.util.Arrays;

public class Problem360 {
    int a, b, c;
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            if (a >= 0) {
                sorted[index--] = func(nums[i]) >= func(nums[j]) ? func(nums[i++]) : func(nums[j--]);
            } else {
                sorted[index++] = func(nums[i]) >= func(nums[j]) ? func(nums[j--]) : func(nums[i++]);
            }
        }
        return sorted;
    }

    private int func(int x) {
        return a * x * x + b * x + c;
    }

    public static void main(String[] args) {
        Problem360 p = new Problem360();

        System.out.println(Arrays.toString(p.sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5)));
    }
}
