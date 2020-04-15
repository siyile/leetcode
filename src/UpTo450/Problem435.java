package UpTo450;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Queue<Period> q = new PriorityQueue<>(new Comparator<Period>() {
            @Override
            public int compare(Period o1, Period o2) {
                return o1.end - o2.end;
            }
        });
        for (int[] interval :
                intervals) {
            q.add(new Period(interval[0], interval[1]));
        }
        int cnt = 1;
        int end = q.poll().end;
        while (!q.isEmpty()) {
            Period cur = q.poll();
            if (cur.start >= end) {
                end = cur.end;
                cnt++;
            }
        }
        return intervals.length - cnt;
    }

    class Period {
        int start;
        int end;

        public Period(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
