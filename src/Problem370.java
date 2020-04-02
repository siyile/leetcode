public class Problem370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update :
                updates) {
            res[update[0]] += update[2];
            res[update[1] + 1] -= update[2];
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            int tmp = res[i];
            res[i] += sum;
            sum += tmp;
        }
        return res;
    }
}
