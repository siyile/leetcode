package UpTo350;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem346 {
    private class MovingAverage {

        Deque<Integer> q;
        int sum = 0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            q = new ArrayDeque<>(size);
        }

        public double next(int val) {
            if (q.size() >= 3)
                sum -= q.poll();
            q.offer(val);
            sum += val;
            return val / q.size();
        }
    }
}
