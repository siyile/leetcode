package UpTo50;

public class Problem43 {
    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        len2 = num2.length();
        String ans = "";
        for (int i = 0; i < len2; i++) {
            ans = plus(ans, multiplySingle(num1, num2.charAt(i), len2 - i - 1));
        }
        return ans;
    }

    public String multiplySingle(String num1, char num2, int boost) {
        StringBuilder s = new StringBuilder();
        int memory = 0;
        int sum;
        int len1 = num1.length();
        int n2 = num2 - '0';
        for (int i = len1 - 1; i >=0; i--) {
            int n1 = num1.charAt(i) - '0';
            sum = n1 * n2 + memory;
            memory = sum / 10;
            s.append(sum % 10);
        }
        if (memory != 0) s.append(memory);
        s.reverse();
        while (boost-- > 0) {
            s.append('0');
        }
        return s.toString();
    }

    public String plus(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0) return num2;
        if (len2 == 0) return num1;
        StringBuilder s = new StringBuilder();
        int memory = 0;
        int sum;
        while (0 < len1 || 0 < len2) {
            int n1 = 0 < len1 ? num1.charAt(--len1) - '0' : 0;
            int n2 = 0 < len2 ? num2.charAt(--len2) - '0' : 0;
            sum = n1 + n2 + memory;
            memory = sum / 10;
            s.append(sum % 10);
        }
        if (memory != 0) s.append(1);
        s.reverse();
        return s.toString();
    }

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];
        int memory;
        int n1, n2;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                n1 = num1.charAt(i) - '0';
                n2 = num2.charAt(j) - '0';
                memory = n1 * n2;
                int p1 = i + j, p2 = i + j + 1;
                memory += ans[p2];
                ans[p1] += memory / 10;
                ans[p2] = memory % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer x: ans) {
            if (!(sb.length() == 0 && x == 0)) sb.append(x);
        }
        if (sb.toString().equals(""))
            return "0";
        else return sb.toString();
    }

    public static void main(String[] args) {
        Problem43 p = new Problem43();
        System.out.println(p.multiply("123", "456"));
    }
}