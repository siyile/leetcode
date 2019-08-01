import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        List<Interval> a = new ArrayList<>();
        for (int[] interval :
                intervals) {
            a.add(new Interval(interval[0], interval[1]));
        }

        Collections.sort(a, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        int cnt = 0;

        while (!a.isEmpty()) {
            cnt++;
            List<Interval> tmp = new ArrayList<>();
            int end = 0;
            for (Interval x :
                    a) {
                if (x.start < end) {
                    tmp.add(x);
                }
            }
            a = tmp;
        }
        return cnt;
    }

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
