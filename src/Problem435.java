import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Queue<Interval> q = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        for (int[] interval :
                intervals) {
            q.add(new Interval(interval[0], interval[1]));
        }
        int cnt = 1;
        int end = q.poll().end;
        while (!q.isEmpty()) {
            Interval cur = q.poll();
            if (cur.start >= end) {
                end = cur.end;
                cnt++;
            }
        }
        return intervals.length - cnt;
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
