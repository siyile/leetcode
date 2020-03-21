package UpTo250;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem227 {
    public static void main(String[] args) {
        Problem227 p = new Problem227();

        System.out.println(p.calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int results = 0, n = 0, sign = 1, operand = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand *= 10;
                operand += (ch - '0');
            } else if (ch == '+' || ch == '-') {
                if (!stack.isEmpty()) {
                    results = sign == 1 ? results * operand : results / operand;
                    results = stack.pop() == 1 ? results + stack.pop() : stack.pop() - results;
                } else {
                    results += sign * operand;
                }
                operand = 0;
                sign = ch == '+' ? 1 : -1;
            } else if (ch == '*' || ch == '/') {
                if (stack.isEmpty()) {
                    stack.push(results);
                    stack.push(sign);
                    results = operand;
                    operand = 0;
                    sign = ch == '*' ? 1 : 0;
                } else {
                    if (sign == 1) {
                        results *= operand;
                    } else {
                        results /= operand;
                    }
                    sign = ch == '*' ? 1 : 0;
                    operand = 0;
                }
            }
        }
        if (!stack.isEmpty()) {
            results = sign == 1 ? results * operand : results / operand;
            results = stack.pop() == 1 ? results + stack.pop() : stack.pop() - results;
        } else {
            results += sign * operand;
        }
        return results;
    }
}
