package UpTo1150;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1106 {
    public static void main(String[] args) {
        Problem1106 p = new Problem1106();

        System.out.println(p.parseBoolExpr("!(&(!(t),&(f),|(f)))"));
    }

    public boolean parseBoolExpr(String expression) {
        char[] A = expression.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        boolean and = true;
        boolean negative = false;
        boolean res = true;
        for (char c :
                A) {
            if (c == '!' || c == '&' || c == '|') {
                stack.push(and ? '&' : '|');
                stack.push(res ? 'T' : 'F');
                stack.push(negative ? 'N' : 'P');
                if (c == '!') {
                    negative = res = and = true;
                } else {
                    and = res = c == '&';
                    negative = false;
                }
            } else if (c == ')') {
                if (negative) {
                    res = !res;
                }
                negative = stack.pop() == 'N';
                boolean tmp = stack.pop() == 'T';
                and = stack.pop() == '&';
                if (and) {
                    res &= tmp;
                } else {
                    res |= tmp;
                }
            } else if (c == 't' || c == 'f') {
                if (and) {
                    res &= c == 't';
                } else {
                    res |= c == 't';
                }
            }
        }
        return res;
    }
}
