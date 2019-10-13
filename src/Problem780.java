public class Problem780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx > ty) tx %= ty;
            else ty %= tx;
        }

        return sx == tx && (ty - sy) % tx == 0 || sy == ty && (tx - sx) % ty == 0;
    }
}
