package UpTo50;

import java.util.Stack;

public class Problem32 {
    public int longestValidParentheses1(String s) {
        Stack<Integer> s1 = new Stack<>();
        int len = s.length();
        int max = -1;
        s1.push(-1);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ')') {
                s1.pop();
                if (!s1.isEmpty()) {
                    max = Math.max(i - s1.peek(), max);
                }
                else {
                    s1.push(i);
                }
            }
            else {
                s1.push(i);
            }
        }

        return max;
    }

    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i > 1) {
                        dp[i] = dp[i - 2] + 2;
                    }
                    else {
                        dp[i] = 2;
                    }
                }
                else {
                    int first = i - dp[i - 1] - 1;
                    if (first >= 0 && s.charAt(first) == '(') {
                        if (first - 1 > 0) {
                            dp[i] = dp[i - 1] + dp[first - 1] + 2;
                        }
                        else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
            }
        }
        int max = 0;
        for (Integer x: dp) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem32 p = new Problem32();
        System.out.println(p.longestValidParentheses("(()())"));
    }
}
