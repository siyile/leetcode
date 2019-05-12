package UpTo50;

public class Problem41 {
    public int trap(int[] height) {
        int amount = 0;
        int len = height.length;
        int max = -1;
        for (int i = 0; i < len; i++) {
            max = height[i] > max ? height[i] : max;
        }
        for (int level = 0; level < max; level++) {
            int[] block = new int[len];
            for (int i = 0; i < len; i++) {
                if (height[i] > level) {
                    block[i] = 1;
                }
            }
            amount = calculateLevel(block, amount);
        }
        return amount;
    }

    private int calculateLevel(int[] block, int amount) {
        int start = 0, end = block.length - 1;
        while (block[start] != 1) {
            start++;
        }
        while (block[end] != 1) {
            end--;
        }
        if (start == end) {
            return amount;
        }
        for (int i = start; i < end; i++) {
            amount += (1 - block[i]);
        }
        return amount;
    }

    public static void main(String[] args) {
        Problem41 p = new Problem41();
        int[] a = {4,2,3};
        System.out.println(p.trap(a));
    }
}
