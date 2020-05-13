package UpTo550;

public class Problem507 {
    public boolean checkPerfectNumber(int num) {
        int[] perfects = new int[]{6, 28, 496, 8128, 33550336};
        for (Integer x :
                perfects) {
            if (x == num) return true;
        }
        return false;
    }
}
