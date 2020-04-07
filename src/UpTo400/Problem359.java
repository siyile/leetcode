package UpTo400;

import java.util.HashMap;
import java.util.Map;

public class Problem359 {
    private class Logger {
        Map<String, Integer> map = new HashMap<>();
        /** Initialize your data structure here. */
        public Logger() {

        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.getOrDefault(message, -10) + 10 <= timestamp) {
                map.put(message, timestamp);
                return true;
            } else return false;
        }
    }
}
