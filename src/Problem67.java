public class Problem67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lena = a.length();
        int lenb = b.length();
        int len = Math.max(lena, lenb);
        int carry = 0;
        int c, d;
        int[] ans = new int[len];
        while (lena > 0 || lenb > 0) {
            if (-1 < --lena) {
                c = a.charAt(lena) - '0';
            } else {
                c = 0;
            }
            if (-1 < --lenb) {
                d = b.charAt(lenb) - '0';
            } else {
                d = 0;
            }
            int sum = carry + c + d;
            ans[--len] = sum % 2;
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(1);
        }
        for (int x :
                ans) {
            sb.append(x);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem67 p = new Problem67();
        System.out.println(p.addBinary("0", "0"));
    }
}
