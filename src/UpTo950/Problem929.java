package UpTo950;

import java.util.HashSet;
import java.util.Set;

public class Problem929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s :
                emails) {
            int mid = s.indexOf('@');
            set.add(local(s.substring(0, mid)) + s.substring(mid));
        }
        return set.size();
    }

    private String local(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+') {
                break;
            } else if (ch != '.') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem929 p = new Problem929();

        System.out.println(p.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}
