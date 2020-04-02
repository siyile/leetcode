public class Problem374 {
    int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
