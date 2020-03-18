package Upto250;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem224 {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operand = 0, result = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = operand * 10 + ch - '0';
            } else if (ch == '+') {
                result += operand * sign;
                operand = 0;
                sign = 1;
            } else if (ch == '-') {
                result += operand * sign;
                operand = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += operand * sign;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return operand * sign + result;
    }
}
