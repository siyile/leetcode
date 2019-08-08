public class Problem845 {
    public int longestMountain(int[] arr) {
        int ans = 0, up = 0, down = 0;
        for (int i = 1; i < arr.length; i++) {
            if (down > 0 && arr[i - 1] < arr[i] || arr[i] == arr[i - 1]) up = down = 0;
            if (arr[i - 1] < arr[i]) up++;
            if (arr[i] < arr[i - 1]) down++;
            if (up > 0 && down > 0 && up + down + 1 > ans)
                ans = up + down + 1;
        }
        return ans;
    }
}
