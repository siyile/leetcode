package UpTo1200;

import java.util.*;

public class Problem1172 {
    private class DinnerPlates {

        int capacity;
        List<Deque<Integer>> stacks = new ArrayList<>();
        TreeSet<Integer> free = new TreeSet<>();

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            if (free.isEmpty()) {
                free.add(stacks.size());
                stacks.add(new ArrayDeque<>());
            }

            stacks.get(free.first()).push(val);
            if (stacks.get(free.first()).size() == capacity) {
                free.remove(free.first());
            }
        }

        public int pop() {
            return superPop(stacks.size() - 1);
        }

        public int popAtStack(int index) {
            return superPop(index);
        }

        private int superPop(int index) {
            if (index == -1 || index >= stacks.size() || stacks.get(index).isEmpty()) {
                return -1;
            }
            int res = stacks.get(index).pop();
            free.add(index);
            while (!free.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
                stacks.remove((int) free.pollLast());
            }
            return res;
        }
    }

}
