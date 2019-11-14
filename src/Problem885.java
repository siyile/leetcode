public class Problem885 {
    int cnt, idx = 0;
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int top = r0 - 1, bottom = r0 + 1, right = c0 + 1, left = c0 - 1;
        cnt = R * C;
        int x = r0, y = c0;
        int[][] ans = new int[R * C][2];
        while (cnt > 0) {
            // right
            for (; y <= right; y++) valid(x, y, ans, R, C);
            y = right++;

            // bottom
            for (; x <= bottom; x++) valid(x, y, ans, R, C);
            x = bottom++;

            // left
            for (; y >= left; y--) valid(x, y, ans, R, C);
            y = left--;

            for (; x >= top; x--) valid(x, y, ans, R, C);
            x = top--;
        }

        return ans;
    }

    private void valid(int x, int y, int[][] ans, int R, int C) {
        if (cnt > 0 && x >= 0 && y >= 0 && x < R && y < C) {
            cnt--;
            ans[idx++] = new int[]{x, y};
        }
    }

    public static void main(String[] args) {
        Problem885 p = new Problem885();

        System.out.println(p.spiralMatrixIII(1, 4, 0, 0));
    }
}
