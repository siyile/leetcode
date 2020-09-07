package UpTo1050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem1024 {
    public int videoStitching(int[][] c, int T) {
        List<Clips> clips = new ArrayList<>();
        int n = c.length;
        for (int[] clip :
                c) {
            clips.add(new Clips(clip[0], clip[1]));
        }
        Collections.sort(clips, new Comparator<Clips>() {
            @Override
            public int compare(Clips o1, Clips o2) {
                return o1.start - o2.start;
            }
        });

        int start = 0;
        int cnt = 0;
        int i = 0;
        while (start < T) {
            Clips tmp = new Clips(0, start);
            while (i < n && clips.get(i).start <= start) {
                if (tmp.end < clips.get(i).end) {
                    tmp = clips.get(i);
                }
                i++;
            }
            if (start == tmp.end) return -1;
            start = tmp.end;
            cnt++;
        }
        return cnt;
    }

    class Clips {
        int start;
        int end;

        public Clips(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
