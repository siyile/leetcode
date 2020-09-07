package UpTo1000;

public class Problem973 {
    public int[][] kClosest(int[][] points, int K) {
        int l = 0, r = points.length - 1;
        int[][] ans = new int[K][2];
        while (true) {
            int pivot = partition(points, l, r);
            if (pivot == K - 1)
                break;
            else if (pivot > K - 1)
                r = pivot - 1;
            else
                l = pivot + 1;
        }
        for (int i = 0; i < K; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }

        return ans;
    }

    private int compare(int[][] points, int x, int y) {
        int[] a = points[x];
        int[] b = points[y];
        return Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1]);
    }

    private void swap(int[][] points, int a, int b) {
        int[] tmp = new int[2];

        tmp[0] = points[a][0];
        tmp[1] = points[a][1];

        points[a][0] = points[b][0];
        points[a][1] = points[b][1];

        points[b][0] = tmp[0];
        points[b][1] = tmp[1];
    }

    private int partition(int[][] points, int l, int r) {
        int pivot = r;
        r--;
        while (l <= r) {
            if (compare(points, l, pivot) <= 0) l++;
            else if (compare(points, r, pivot) > 0) r--;
            else {
                swap(points, l++, r--);
            }
        }
        swap(points, l, pivot);
        return l;
    }
}
