package UpTo150;

public class Problem136 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (Integer x :
                nums) {
            a ^= x;
        }
        return a;
    }

    public static void main(String[] args) {
        Problem136 p = new Problem136();

        System.out.println(p.singleNumber(new int[]{2,2,1}));
    }
}
