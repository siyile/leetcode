package UpTo200;

public class Problem168 {
    public static void main(String[] args) {
        Problem168 p = new Problem168();

        System.out.println(p.convertToTitle(1));
    }

    public String convertToTitle(int n) {
        int exp = 1;
        int base = 26;
        StringBuilder sb = new StringBuilder();
        while (n / exp > 0) {
            int remainder = (n / exp - 1) % base;
            sb.append((char) (remainder + 'A'));
            n -= remainder * exp;
            exp *= base;
        }
        return sb.reverse().toString();
    }
}
