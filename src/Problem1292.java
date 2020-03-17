public class Problem1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int res = 0;
/*        int x1, x2, y1, y2;
        for (int i = 0; i < m; i++) {
            int begin = 0, end = 0;
            while (true) {
                x1 = i + begin;
                y1 = begin;
                x2 = i + end;
                y2 = end;
                if (x2 > m || y2 > n)
                    break;
                while (begin < end && x2 <= m && y2 <= n && square(x1, y1, x2, y2, sum) > threshold) {
                    begin++;
                    x1 = i + begin;
                    y1 = begin;
                }
                res = Math.max(res, end - begin);
                end++;
            }
        }

        for (int i = 1; i < n; i++) {
            int begin = 0, end = 0;
            while (true) {
                x1 = begin;
                y1 = i + begin;
                x2 = end;
                y2 = i + end;
                if (x2 > m || y2 > n)
                    break;
                while (begin < end && x2 <= m && y2 <= n && square(x1, y1, x2, y2, sum) > threshold) {
                    begin++;
                    x1 = begin;
                    y1 = i + begin;
                }
                res = Math.max(res, end - begin);
                end++;
            }
        }

        return res;*/

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = res + 1;
                while (i + len <= m && j + len <= n && square(i, j, i + len, j + len, sum) <= threshold) {
                    res = len;
                    len++;
                }
            }
        }

        return res;
    }

    private int square(int x1, int y1, int x2, int y2, int[][] sum) {
        return sum[x2][y2] - sum[x1][y2] - sum[x2][y1] + sum[x1][y1];
    }

}
