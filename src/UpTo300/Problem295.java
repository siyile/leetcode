package UpTo300;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem295 {
    private class MedianFinder {
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> min = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            min.add(num);
            max.add(min.poll());
            if (min.size() < max.size()) {
                min.add(max.poll());
            }
        }

        public double findMedian() {
            return min.size() > max.size() ? min.peek() : (min.peek() * 1.0 + max.peek()) / 2;
        }
    }
}
