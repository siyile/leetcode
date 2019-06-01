package UpTo100;

public class Problem55 {
    public boolean canJump(int[] nums) {
        int canReach, farest = 0;
        int len = nums.length;
        if (len == 1) return true;
        for (int i = 0; i < len - 1; i++) {
            if (farest < i) {
                return false;
            }
            canReach = nums[i] + i;
            farest = Math.max(farest, canReach);
        }
        return farest >= len - 1;
    }

    public static void main(String[] args) {
        Problem55 p = new Problem55();
        int[] a = {1,2,4};
        System.out.println(p.canJump(a));
    }
}
