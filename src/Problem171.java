public class Problem171 {
    public static void main(String[] args) {
        Problem171 p = new Problem171();

        System.out.println(p.titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        int base = 1;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--, base *= 26) {
            ans += (s.charAt(i) - 'A' + 1) * base;
        }
        return ans;
    }
}
