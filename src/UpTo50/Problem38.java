package UpTo50;

public class Problem38 {
    public static void main(String[] args) {
        Problem38 p = new Problem38();
        System.out.println(p.countAndSay(1));
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = generateNext(s);
        }
        return s;
    }

    public String generateNext(String s) {
        int len = s.length();
        char cur = ' ';
        char now = s.charAt(0);
        int count = 0;
        int idx = 0;
        StringBuilder res = new StringBuilder();
        while (idx != len) {
            cur = s.charAt(idx);
            if (now == cur) {
                count++;
            } else {
                res.append(count);
                res.append(now);
                now = cur;
                count = 1;
            }
            idx++;
        }
        res.append(count);
        res.append(now);
        return res.toString();
    }
}
