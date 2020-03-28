package UpTo350;

import java.util.ArrayList;
import java.util.List;

public class Problem301 {
    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        Problem301 p = new Problem301();

        System.out.println(p.removeInvalidParentheses("()())()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        dfs(s, 0, 0, '(', ')');
        return ans;
    }

    private void dfs(String s, int ip, int jp, char o, char c) {
        int sum = 0;
        for (int i = ip; i < s.length(); i++) {
            if (s.charAt(i) == o) sum--;
            else if (s.charAt(i) == c) sum++;
            if (sum == 1) {
                for (int j = jp; j <= i; j++) {
                    if (s.charAt(j) == c && (j == jp || s.charAt(j - 1) != c)) {
                        dfs(s.substring(0, j) + s.substring(j + 1, s.length()), i, j, o, c);
                    }
                }
                return;
            }
        }

        StringBuilder sb = new StringBuilder(s);
        if (o == '(') dfs(sb.reverse().toString(), 0, 0, ')', '(');
        else ans.add(sb.reverse().toString());
    }
}
