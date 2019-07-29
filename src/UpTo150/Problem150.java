package UpTo150;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Problem150 {
    public static void main(String[] args) {
        Problem150 p = new Problem150();

        System.out.println(p.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> s = new Stack<>();
        Set<String> operators = new HashSet<>();
        Collections.addAll(operators, "+", "*", "/", "-");
        for (String x :
                tokens) {
            if (operators.contains(x)) {
                int e2 = s.pop();
                int e1 = s.pop();
                switch (x.charAt(0)) {
                    case '+':
                        s.push(e1 + e2);
                        break;
                    case '*':
                        s.push(e1 * e2);
                        break;
                    case '-':
                        s.push(e1 - e2);
                        break;
                    case '/':
                        s.push(e1 / e2);
                        break;
                }
            } else {
                s.push(Integer.parseInt(x));
            }
        }
        return s.peek();
    }
}
