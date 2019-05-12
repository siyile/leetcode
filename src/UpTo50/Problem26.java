package UpTo50;

public class Problem26 {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[current] != nums[i]) {
                nums[++current] = nums[i];
            }
        }
        return ++current;
    }

    public static void main(String[] args) {
        Problem26 p = new Problem26();
        int [] a = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(p.removeDuplicates(a));
    }
}
