package UpTo800;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem772 {
    int i = 0;

    public static void main(String[] args) {
        Problem772 p = new Problem772();

        System.out.println(p.calculate("2*(5+5*2)/3+(6/2+8)"));
    }

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0, ans = 0;
        while (true) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '(') {
                i++;
                num = calculate(s);
                ch = '0';
            }
            if (!Character.isDigit(ch) && ch != ' ' || i + 1 < s.length() && s.charAt(i + 1) == ')' || i == s.length() - 1) {
                if (sign == '+') stack.push(num);
                else if (sign == '-') stack.push(-num);
                else if (sign == '*') stack.push(stack.poll() * num);
                else if (sign == '/') stack.push(stack.poll() / num);
                sign = ch;
                num = 0;
            }
            if (ch == ')' || i == s.length() - 1) {
                while (!stack.isEmpty()) {
                    ans += stack.poll();
                }
                return ans;
            }
            i++;
        }
    }
}
