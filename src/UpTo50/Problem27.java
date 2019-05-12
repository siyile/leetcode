package UpTo50;

public class Problem27 {
    public int removeElement(int[] nums, int val) {
        int current = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[current++] = nums[i];
            }
        }
        return current;
    }

    public static void main(String[] args) {
        Problem27 p = new Problem27();
        int [] a = {1};
        System.out.println(p.removeElement(a, 1));
    }
}
