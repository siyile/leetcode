public class Problem379 {
    private class PhoneDirectory {
        int[] next;
        int pos = 0;
        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            next = new int[maxNumbers];
            for (int i = 0; i < maxNumbers - 1; i++) {
                next[i] = i + 1;
            }
            next[maxNumbers - 1] = 0;
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            if (next[pos] == -1) return -1;
            int res = pos;
            pos = next[res];
            next[res] = -1;
            return res;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return next[number] != -1;
        }

        /** Recycle or release a number. */
        public void release(int number) {
            if (next[number] != -1) return;
            next[number] = pos;
            pos = number;
        }
    }
}
