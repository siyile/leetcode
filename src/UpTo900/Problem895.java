package UpTo900;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Problem895 {
    private class FreqStack {

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Deque<Integer>> group = new HashMap<>();
        int max = 0;

        public FreqStack() {

        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            max = Math.max(max, f);
            if (!group.containsKey(f)) group.put(f, new ArrayDeque<>());
            group.get(f).push(x);
        }

        public int pop() {
            Deque<Integer> stack = group.get(max);
            int x = stack.pop();
            freq.put(x, max - 1);
            if (stack.isEmpty()) max--;
            return x;
        }
    }
}
