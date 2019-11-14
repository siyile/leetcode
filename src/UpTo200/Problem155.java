package UpTo200;

import java.util.Stack;

public class Problem155 {
    class MinStack {
        Stack<Integer> s;
        int min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            s = new Stack<>();
        }

        public void push(int x) {
            if (x <= min) {
                s.push(min);
                min = x;
            }
            s.push(x);
        }

        public void pop() {
            if (s.pop() == min)
                min = s.pop();
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return min;
        }
    }

}
