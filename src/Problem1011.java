public class Problem1011 {
    public static void main(String[] args) {
        Problem1011 p = new Problem1011();

        System.out.println(p.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public int shipWithinDays(int[] weights, int D) {
        int l = 1, r = 50_000 * 500;
        while (l < r) {
            int m = (l + r) / 2;
            if (possible(weights, D, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean possible(int[] weights, int d, int c) {
        int day = 0;
        int load = c;
        for (int weight :
                weights) {
            if (weight > c) return false;
            load += weight;
            if (load > c) {
                load = weight;
                day++;
            }
            if (day > d) return false;
        }
        return true;
    }
}
