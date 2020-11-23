import java.util.TreeMap;

public class Problem729 {
    private class MyCalendar {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer prev = map.lowerKey(end);
            if (prev == null || map.get(prev) <= start) {
                map.put(start, end);
                return true;
            } else {
                return false;
            }
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
}
