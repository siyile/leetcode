package UpTo300;

public class Problem292 {
    public boolean canWinNim(int n) {
        if (n < 4) return true;
        if (n == 4) return false;
        Boolean[] cache = new Boolean[n + 1];
        cache[1] = true;
        cache[2] = true;
        cache[3] = true;
        cache[4] = false;
        return win(n, cache);
    }

    private boolean win(int n, Boolean[] cache) {
        if (cache[n] != null) return cache[n];
        boolean res = !win(n - 1, cache) || !win(n - 2, cache) || !win(n - 3, cache);
        cache[n] = res;
        return res;
    }
}

