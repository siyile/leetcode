import java.util.ArrayList;
import java.util.List;

public class Problem731 {
    class MyCalendarTwo {
        List<int[]> books = new ArrayList<>();
        List<int[]> overlaps = new ArrayList<>();
        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {

            for (int[] b : overlaps) {
                if (start < b[1] && end > b[0]) {
                    return false;
                }
            }
            for (int[] b : books) {
                if (start < b[1] && end > b[0]) {
                    overlaps.add(new int[]{Math.max(start, b[0]), Math.min(end, b[1])});
                }
            }
            books.add(new int[]{start, end});
            return true;
        }
    }
}
