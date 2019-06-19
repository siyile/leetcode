public class Problem137 {
    public int singleNumber(int[] nums) {
        // k = 3, p = 1;
        int x1 = 0, x2 = 0, mask = 0;
        for (Integer x :
                nums) {
            x2 ^= (x1 & x);
            x1 ^= x;
            mask = ~(x1 & x2);
            x1 &= mask;
            x2 &= mask;
        }
        return x1;
    }

    public static void main(String[] args) {
        Problem137 p = new Problem137();
        System.out.println(p.singleNumber(new int[]{2,2,3,2}));
    }
}
