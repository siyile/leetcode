import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class Problem528 {
    private class Solution {
        int[] w;
        int range;
        Random rand = new Random();
        public Solution(int[] w) {
            for (int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }
            this.w = w;
            range = w[w.length - 1];
        }

        public int pickIndex() {
            int val = rand.nextInt(range) + 1;
            int i = Arrays.binarySearch(w, val);
            if (i < 0) i = ~i;
            return i;
        }
    }
}
