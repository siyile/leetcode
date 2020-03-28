package UpTo350;

public class Problem302 {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchColumns(0, y, 0, m, image, false);
        int right = searchColumns(y, n, 0, m, image, true);
        int top = searchRows(0, x, left, right, image, false);
        int bottom = searchRows(x, m, left, right, image, true);
        return (bottom - top) * (right - left);
    }

    private int searchColumns(int left, int right, int top, int bottom, char[][] image, boolean opt) {
        while (left < right) {
            int mid = (right + left) / 2;
            int k = top;
            while (k < bottom && image[k][mid] == '0') k++;
            if (k < bottom == opt) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int searchRows(int top, int bottom, int left, int right, char[][] image, boolean opt) {
        while (top < bottom) {
            int mid = (top + bottom) / 2;
            int k = left;
            while (k < right && image[mid][k] == '0') k++;
            if (k < right == opt) {
                bottom = mid;
            } else {
                top = mid + 1;
            }
        }
        return top;
    }
}
