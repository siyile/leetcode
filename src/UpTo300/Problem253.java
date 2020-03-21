package UpTo300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        List<Peroid> a = new ArrayList<>();
        for (int[] interval :
                intervals) {
            a.add(new Peroid(interval[0], interval[1]));
        }

        Collections.sort(a, new Comparator<Peroid>() {
            @Override
            public int compare(Peroid o1, Peroid o2) {
                return o1.end - o2.end;
            }
        });

        int cnt = 0;

        while (!a.isEmpty()) {
            cnt++;
            List<Peroid> tmp = new ArrayList<>();
            int end = 0;
            for (Peroid x :
                    a) {
                if (x.start < end) {
                    tmp.add(x);
                }
            }
            a = tmp;
        }
        return cnt;
    }

    class Peroid {
        int start;
        int end;

        public Peroid(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
