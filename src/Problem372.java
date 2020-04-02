public class Problem372 {
    int base = 1337;
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }

    private int superPow(int a, int[] b, int i) {
        if (i == 0) return powMod(a, b[0]);
        return powMod(superPow(a, b, i - 1), 10) * powMod(a, b[i]) % base;
    }

    public int powMod(int a, int k) {
        a %= base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = (res * a) % base;
        }
        return res;
    }
}
