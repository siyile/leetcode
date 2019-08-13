public class Problem1154 {
    public static void main(String[] args) {
        Problem1154 p = new Problem1154();

        System.out.println(p.dayOfYear("2004-03-01"));
    }

    public int dayOfYear(String date) {
        String[] strs = date.split("-");
        int y = Integer.parseInt(strs[0]);
        int[] days;
        if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
            days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        } else {
            days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }
        int m = Integer.parseInt(strs[1]);
        int d = Integer.parseInt(strs[2]);
        int ans = 0;
        for (int i = 1; i <= m - 1; i++) {
            ans += days[i - 1];
        }
        return ans + d;
    }
}
