package UpTo900;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem855 {
    private class ExamRoom {
        int N;
        Queue<Interval> q;

        private class Interval implements Comparable<Interval> {
            int l;
            int r;
            int dis;

            Interval(int l, int r) {
                this.l = l;
                this.r = r;
                if (l == -1) {
                    dis = r;
                } else if (r == N) {
                    dis = N - 1 - l;
                } else {
                    dis = (r - l) / 2;
                }
            }

            Interval(){}

            @Override
            public int compareTo(Interval o2) {
                return dis - o2.dis == 0 ? l - o2.l : - dis + o2.dis;
            }
        }

        public ExamRoom(int N) {
            N = this.N;
            q = new PriorityQueue<>();
            q.offer(new Interval(-1, N));
        }

        public int seat() {
            int seat = 0;
            Interval i = q.poll();
            System.out.println("dis," + i.dis);
            if (i.l == -1)
                seat = 0;
            else if (i.r == N)
                seat = N - 1;
            else
                seat = (i.l + i.r) / 2;
            q.offer(new Interval(i.l, seat));
            q.offer(new Interval(seat, i.r));
            System.out.println(seat);
            return seat;
        }

        public void leave(int p) {
            List<Interval> list = new ArrayList<>(q);
            Interval start = null, end = null;
            for (Interval i :
                    list) {
                if (i.r == p) start = i;
                if (i.l == p) end = i;
                if (start != null && end != null) break;
            }

            q.remove(start);
            q.remove(end);
            q.offer(new Interval(start.l, end.r));
        }
    }

}
