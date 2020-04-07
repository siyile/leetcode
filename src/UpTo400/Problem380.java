package UpTo400;

import java.util.*;

public class Problem380 {
    private class RandomizedSet {

        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int i  = map.get(val);
            list.set(i, list.get(list.size() - 1));
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
