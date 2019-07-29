package UpTo100;

public class Problem84 {
    public static void main(String[] args) {
        Problem84 p = new Problem84();
        int[] a = {2, 1, 5, 6, 2, 3};
        System.out.println(p.largestRectangleArea(a));
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] nextLeft = new int[len];
        int[] nextRight = new int[len];
        nextLeft[0] = -1;
        nextRight[len - 1] = len;
        for (int i = 1; i < len; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = nextLeft[p];
            nextLeft[i] = p;
        }
        for (int i = len - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < len && heights[p] >= heights[i])
                p = nextRight[p];
            nextRight[i] = p;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, heights[i] * (nextRight[i] - nextLeft[i] - 1));
        }
        return ans;
    }
}
